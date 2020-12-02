package 算法;

public class 最后一个单词的长度 {
    public static void main(String[] args) {
        String s="hello world";
        int i = lengthOfLastWord(s);
        System.out.println(i);
    }

    public static int lengthOfLastWord(String s) {
        String[] sp=s.split("");
        int l=0;
        boolean flag=true;
        //需要跳过最后的空格,从不等于空格的地方开始计数，直到找到下一个空格为止
        for (int i = sp.length-1;i>=0 ; i--) {
            if(sp[i].equals(" ")&&l==0){
                continue;
            }
            if(sp[i].equals(" ")&&l!=0){
                break;
            }
            if(!sp[i].equals(" ")){
                l++;
            }

        }

        return l;
    }

   /* public static int lengthOfLastWord(String s) {
        String[] sp=s.split("");
        int l=0;
        //需要跳过最后的空格

        for (int i = sp.length-1; i >=0 ; i--) {

            if(!sp[i].equals(" ")){
                break;
            }
            if(sp[i].equals(" ")){
                sp[i]="";
            }
        }

        for (int i = sp.length-1;i>=0 ; i--) {
            if(sp[i].equals("")){
                continue;
            }
            if(!sp[i].equals(" ")){
                l++;
            }else{
                break;
            }
        }

        return l;
    }*/
}
