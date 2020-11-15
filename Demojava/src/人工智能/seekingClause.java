package 人工智能;

import java.util.Scanner;
import java.util.function.ToDoubleBiFunction;
import java.util.jar.JarOutputStream;

/*
    给出一个谓词公式求子句集
    否定 ~ 否定符号作用域【】
    合取 ^
    析取 v
    蕴含 → 作用域[]
    等价 =

    全称量词 @
    存在量词 $  作用域<>

    @x{    [@yP(x,y)]  →  [ ~ 【  @y{  [Q(x,y)]→[R(x,y)] } 】 ] }

    消去蕴含符号
    缩小否定量词的作用范围




 */
public class seekingClause {

    static String str = "@x<{[@y<P(x,y)>]→[~【@y<{[Q(x,y)]→[R(x,y)]}>】]}>";

    public static void main(String[] args) {
        if_yunhan();
        if_yunhan();
        System.out.println("消去蕴含符号：");
        System.out.println(str);
        if_fouding();
        if_fouding();
        foudingneiyi();
        System.out.println("消去否定符号：");
        System.out.println(str);
        if_chongming();
        System.out.println("改名：");
        System.out.println(str);
        xiaoqu$();
        System.out.println("消去存在量词：");
        System.out.println(str);
        xiaoququancheng();
        System.out.println("消去全称量词");
        System.out.println(str);
        huahequ();
        System.out.println("化为合取范式：");
        System.out.println(str);
        gaiming();
        System.out.println("改名，使子句之间没有同名变元：");
        System.out.println(str);
        xiaoquhequ();
        System.out.println("原谓词公式的子句集：");
        System.out.println(str);



    }

    //消去所有的蕴含符号,将字符串拆分为字符数组，判断蕴含符号的作用域，需要判断蕴含符号作用两侧的括号
    private static void if_yunhan() {
        String[] strsplit = new String[1024];
        strsplit = str.split("");

        /*for (int i = 0; i < strsplit.length; i++) {
            System.out.print(strsplit[i]+" ");
        }*/

        //定位作用域
        //int[] index_yunhan=new int[5];//存放蕴含符号的位置
        //int number=0;//记录有几个蕴含符
        int index_yunhan_now = 0;
        for (int i = 0; i < strsplit.length; i++) {
            if (strsplit[i].equals("→")) {
                index_yunhan_now = i;
                break;
            }
        }
        //System.out.println(index_yunhan_now);
        //System.out.println(number);

        //消去蕴含符号，需要考虑多个蕴含符的情况，从index_yunhan数组中从后往前取出数据，依次消除标记位置的蕴含符号
        int m = 0;
        int n = 0;

        String strzero = "";
        String strone = "";
        String strtwo = "";
        String strthree = "";


        //找出作用域

        for (int i = index_yunhan_now; i > 0; i--) {
            if (strsplit[i].equals("[")) {
                m = i;
                break;
            }
        }
        for (int i = index_yunhan_now; i < strsplit.length; i++) {
            if (strsplit[i].equals("]")) {
                n = i;
                break;
            }
        }
        //System.out.println(m+" "+n);
        for (int i = 0; i < m; i++) {
            strzero = strzero + strsplit[i];
        }
        for (int i = m; i < index_yunhan_now; i++) {
            strone = strone + strsplit[i];
        }

        String[] strone_split = strone.split("");
        int index_last = strone_split.length;
        strone_split[0] = "【";
        strone_split[index_last - 1] = "】";
        strone = "";
        for (int i = 0; i < strone_split.length; i++) {
            strone = strone + strone_split[i];
        }

        for (int i = index_yunhan_now + 1; i <= n; i++) {
            strtwo = strtwo + strsplit[i];
        }
        for (int i = n + 1; i < strsplit.length; i++) {
            strthree = strthree + strsplit[i];
        }
            /*System.out.println(strzero);
            System.out.println(strone);
            System.out.println(strtwo);
            System.out.println(strthree);*/
        //消去蕴含符号
        str = strzero + "~" + strone + "v" + strtwo + strthree;

    }
    //消去谓词公式中的否定
    private static void if_fouding() {
        String[] strsplit = new String[1024];
        strsplit = str.split("");
        //判断否定的作用域
        int[] index_fouding = new int[5];
        int number = 0;

        for (int i = 0; i < strsplit.length; i++) {
            if (strsplit[i].equals("~")) {
                index_fouding[number] = i;
                number++;
            }
        }
        //System.out.println(number);
        /*for (int i = 0; i < index_fouding.length; i++) {
            System.out.println(index_fouding[i]);
        }*/

        int count = 0;
        int m = 0;
        int n = 0;
        while (true) {
            String strzero = "";//存放否定前的语句
            String strone = "";//存放~
            String strtwo = "";//存放否定作用域
            String strthree = "";//存放作用域后的语句
            //对于否定的操作
            int index_now = index_fouding[count];
            //定位作用域
            m = index_now + 1;
            int flag = 0;
            for (int i = m + 1; i < strsplit.length; i++) {

                if (strsplit[i].equals("【")) {
                    flag++;
                    continue;
                }

                if (strsplit[i].equals("】") && flag <= 0) {
                    n = i;
                    break;
                }
                if (strsplit[i].equals("】") && flag > 0) {
                    flag--;
                }

            }
            //System.out.println(m+" "+n);

            for (int i = 0; i < index_now; i++) {
                strzero = strzero + strsplit[i];
            }
            strone = "~";
            for (int i = m; i <= n; i++) {
                strtwo = strtwo + strsplit[i];
            }
            for (int i = n + 1; i < strsplit.length; i++) {
                strthree = strthree + strsplit[i];
            }

            /*System.out.println(strzero);
            System.out.println(strone);
            System.out.println(strtwo);
            System.out.println(strthree);*/

            //判断是否作用于原子语句，如果作用于原子语句则不需要进行操作,需要判断strtwo中第一个字符是不是大写字母
            if (strtwo.split("")[1].equals("P") ||
                    strtwo.split("")[1].equals("Q") ||
                    strtwo.split("")[1].equals("R")
            ) {
                //System.out.println("已经作用于原子公式");
            } else {
                //作用域中有全称量词
                if (strtwo.split("")[1].equals("@")) {


                    //不存在^ V

                    String strtwo_one = strtwo.split("")[0] + "$" + strtwo.split("")[2];
                    String strtwo_two = "";
                    for (int i = 3; i < strtwo.split("").length; i++) {
                        strtwo_two = strtwo_two + strtwo.split("")[i];
                    }
                    //System.out.println(strtwo_one);
                    String strone_strtwo = strtwo_one + strone + strtwo_two;
                    str = strzero + strone_strtwo + strthree;
                    //System.out.println(strone_strtwo);
                    //System.out.println(str);
                }
                /*
                if(strtwo.split("")[1].equals("$")){

                }*/
            }

            //退出条件，否定全部作用于原子公式时退出
            count++;
            if (count == number) {
                break;
            }

        }

        //否定内移处理，直到否定只作用与原子公式

    }
    //对于否定符号作用域内还有否定情况的处理
    private static void foudingneiyi() {
        String[] strsplit = str.split("");
        int[] index_fouding = new int[5];
        int number = 0;
        for (int i = 0; i < strsplit.length; i++) {
            if (strsplit[i].equals("~")) {
                index_fouding[number] = i;
                number++;
            }
        }
        int index_xiqu = 0;
        for (int i = 0; i < strsplit.length; i++) {
            if (strsplit[i].equals("v")) {
                index_xiqu = i;
            }
        }
        /*for (int i = 0; i < index_fouding.length; i++) {
            System.out.println(index_fouding[i]);
        }*/
        int index_one = index_fouding[1];
        int index_two = index_fouding[2];
        strsplit[index_one] = "";
        strsplit[index_two] = "";
        strsplit[index_xiqu] = "^~";
        String strone = "";
        for (int i = 0; i < strsplit.length; i++) {
            if(strsplit[i].equals("【")||strsplit[i].equals("】")){
                strsplit[i]="";
            }
        }
        for (int i = 0; i < strsplit.length; i++) {
            strone = strone + strsplit[i];
        }
        str = strone;
    }
    //判断量词间是否存在同名指导变元和约束变元
    private static void if_chongming() {

        //定位全称量词和存在量词的作用域，并且判断是否有两个量词之间存在同名指导和约束变元
        String[] strsplit = str.split("");
        int[] index_liangci = new int[5];
        int number = 0;
        for (int i = 0; i < strsplit.length; i++) {
            if (strsplit[i].equals("@") || strsplit[i].equals("$")) {
                index_liangci[number] = i;
                number++;
            }
        }
        /*for (int i = 0; i < index_liangci.length; i++) {
            System.out.println(index_liangci[i]);
        }*/
        //判断两个量词是不是同级别的
        int index_one = index_liangci[0];
        int index_two = index_liangci[1];
        int index_three = index_liangci[2];

        if (strsplit[index_two].equals(strsplit[index_three])) {

            for (int i = index_two; i < index_three; i++) {
                if (strsplit[i].equals("y")) {
                    strsplit[i] = "z";
                }
            }
        }
        String strone = "";
        for (int i = 0; i < strsplit.length; i++) {
            strone = strone + strsplit[i];
        }
        str = strone;
        //System.out.println(str);


    }
    //消去存在量词
    private static void xiaoqu$() {
        String[] strsplit = str.split("");
        int[] index_$ = new int[3];
        int number = 0;
        for (int i = 0; i < strsplit.length; i++) {
            if (strsplit[i].equals("$")) {
                index_$[number] = i;
                number++;
            }
        }
        int index_one = index_$[0];
        int index_two = index_$[1];

        strsplit[index_one] = "";
        strsplit[index_two] = "";

        String str_z = strsplit[index_one + 1];
        String str_y = strsplit[index_two + 1];

        strsplit[index_one + 1] = "";
        strsplit[index_two + 1] = "";
        for (int i = 0; i < strsplit.length; i++) {
            if (strsplit[i].equals(str_z)) {
                strsplit[i] = "f(x)";
            }
        }
        for (int i = 0; i < strsplit.length; i++) {
            if (strsplit[i].equals(str_y)) {
                strsplit[i] = "g(x)";
            }
        }

        String strone = "";
        for (int i = 0; i < strsplit.length; i++) {
            strone = strone + strsplit[i];
        }
        str = strone;
    }

    //消去全称量词
    private static void xiaoququancheng() {
        String[] strsplit = str.split("");
        for (int i = 0; i < strsplit.length; i++) {
            if (strsplit[i].equals("@")) {
                strsplit[i] = "";
                strsplit[i + 1] = "";
            }
        }

        if (strsplit[2].equals("<")) {
            strsplit[2] = "";
        }
        if(strsplit[3].equals("{")){
            strsplit[3] = "";
        }


        strsplit[strsplit.length - 1] = "";
        strsplit[strsplit.length - 2] = "";
        String strone = "";
        for (int i = 0; i < strsplit.length; i++) {
            if(strsplit[i].equals("<")||strsplit[i].equals(">")||strsplit[i].equals("{")||strsplit[i].equals("}")){
                strsplit[i]="";
            }
        }
        for (int i = 0; i < strsplit.length; i++) {
            strone = strone + strsplit[i];
        }
        str = strone;

    }
    //化为合取范式
    private static void huahequ() {
        String[] strsplit=str.split("");
        int index_hequ=0;
        int index_xiqu=0;
        for (int i = 0; i < strsplit.length; i++) {
            if(strsplit[i].equals("v")){
                index_xiqu=i;
            }
        }
        for (int i = 0; i < strsplit.length; i++) {
            if(strsplit[i].equals("^")){
                index_hequ=i;
            }
        }
        String strone="";
        String strtwo="";
        String strthree="";

        for (int i = 0; i < index_xiqu; i++) {
            strone=strone+strsplit[i];
        }
        for (int i = index_xiqu+2; i <index_hequ; i++) {
            strtwo=strtwo+strsplit[i];
        }
        for (int i = index_hequ+1; i < strsplit.length-1; i++) {
            strthree=strthree+strsplit[i];
        }
        /*System.out.println(strone);
        System.out.println(strtwo);
        System.out.println(strthree);*/

        str="{"+strone+"v"+strtwo+"}"+"^"+"{"+strone+"v"+strthree+"}";

    }

    //改名，使得子句之间没有同名变元
    private static void gaiming() {
        String[] strsplit=str.split("");
        int index_hequ=0;
        for (int i = 0; i < strsplit.length; i++) {
            if(strsplit[i].equals("^")){
                index_hequ=i;
            }
        }
        for (int i = index_hequ; i < strsplit.length; i++) {
            if(strsplit[i].equals("x")){
                strsplit[i]="y";
            }
        }
        String strone="";
        for (int i = 0; i < strsplit.length; i++) {
            strone=strone+strsplit[i];
        }
        str=strone;
    }

    //将合取范式变为子句集的形式
    private static void xiaoquhequ() {
        String[] strsplit=str.split("");
        for (int i = 0; i < strsplit.length; i++) {
            if(strsplit[i].equals("^")){
                strsplit[i]=",";
            }
        }
        String strone="";
        for (int i = 0; i < strsplit.length; i++) {
            strone=strone+strsplit[i];
        }
        str=strone;
    }





}
