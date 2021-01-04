package 算法;

public class 最长公共前缀 {
    public static void main(String[] args) throws Exception {
        //String[] str=new String[]{"flower","flow","flight"};
        //String[] str=new String[]{"flower","flower","flower","flower"};
        String[] str=new String[]{"",""};
        String s = longestCommonPrefix(str);
        System.out.println(s);
    }

    public static String longestCommonPrefix(String[] strs) throws Exception {
        //逐个比较每一个字符串的字符
        int number=0;//记录相同字符的个数
        String str="";
        for (int i = 0; i < strs.length; i++) {
            if(strs[i]==""){
                return "";
            }
        }

        if(strs.length==1){
            return strs[0];
        }
        for (int i = 1; i < strs.length; i++) {
            try{
                if (strs[i].charAt(number)!=strs[0].charAt(number)){
                    break;
                }
            }catch(Exception e){
                break;
            }

            if(i==strs.length-1){
                number++;
                i=0;
            }


        }

        for (int i = 0; i < number; i++) {

                str=str+strs[0].charAt(i);
        }
        return str;


    }
}
