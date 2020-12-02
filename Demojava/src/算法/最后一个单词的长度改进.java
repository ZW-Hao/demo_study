package 算法;

public class 最后一个单词的长度改进 {
    public static void main(String[] args) {
        String s=" hello world   ";
        System.out.println(jisuan(s));

    }
    public static int jisuan(String s){

        //在原来的空间上更改字符串，可以减少空间复杂度
        //创建一个新的字符数组空间代价太高，所以不采用split方法
        StringBuilder sb=new StringBuilder(s);
        int i=sb.length();//确定字符串的长度
        //System.out.println(i);
        int l=0;
        for (int j = i-1; j >=0 ; j--) {

            if(sb.charAt(j)==' '&&l!=0){
                break;//此时最后一个单词已经读完，退出循环
            }
            if (sb.charAt(j)!=' '){
                l++;
            }
            if(sb.charAt(j)==' '&&l==0){
                sb.deleteCharAt(j);//删掉字符串最后面的空格，为计数做准备
            }



        }
        return l;
    }
}
