package com.Bzhan;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/*
    文件上传案例的服务器端
        将客户端上传的文件保存到本地硬盘中
        实现步骤
            创建一个serversocket对象
            使用serversocket对象中的方法获取到请求的客户端socket对象

    自定义文件的命名规则
        防止同名文件覆盖，域名+毫秒值+随机数


        服务器一直处于开启状态，有一个客户端上传文件时就开启一个线程来为其服务。
        注意在服务器中是不能读取到本地文件的结束符，所以要在客户端代码中手动关闭上传文件时创建的输入流对象，否则程序陷入死循环


 */
public class demo_11_12_05 {

    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(8888);

        //让服务器一直处于监听状态，有客户端上传文件就保存文件
        while(true){
            Socket socket=server.accept();

            /*
                使用多线程提高效率
                可以同时有多个客户端上传文件，每次来一个客户端就开启一个线程
             */

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        InputStream is=socket.getInputStream();

                        String filename="itcast"+ System.currentTimeMillis()+new Random().nextInt(9999)+".txt";
                        File file=new File("src\\serverupload");
                        if(!file.exists()){
                            file.mkdir();
                        }

                        FileOutputStream fos=new FileOutputStream(file+"\\"+filename);

                        int len=0;
                        byte[] b=new byte[1024];
                        while((len=is.read(b))!=-1){//本地文件是读取到-1结束，但并不会读取-1，也不会将结束标记写给服务器，所以
                            fos.write(b,0,len); //循环一直运行（读取不到文件结束标记）进入到阻塞状态。
                        }

                        socket.getOutputStream().write("上传成功".getBytes());
                        fos.close();
                        socket.close();
                    }catch(IOException e){
                        System.out.println(e);
                    }
                }
            }).start();


        }



    }
}
