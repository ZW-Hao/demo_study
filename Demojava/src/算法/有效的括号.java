package 算法;

public class 有效的括号 {
    public static void main(String[] args) {
        String str="}]";

        System.out.println( isValid(str));
    }
    public static boolean isValid(String s) {
        char[] c=new char[100];
        int number=0;
//        int zhizhen=0;
        char[] s_char=s.toCharArray();
        for (int i = 0; i < s_char.length; i++) {
            if(s_char[i]=='('||s_char[i]=='['||s_char[i]=='{'){
                c[number]=s_char[i];
                number++;

            }
            if(number-1<0){
                return false;
            }

            if(s_char[i]==')'){
                if(c[number-1]=='('){
                    number--;
                }else{
                    return false;
                }
            }

            if(s_char[i]==']'){
                if(c[number-1]=='['){
                    number--;
                }else{
                    return false;
                }
            }

            if(s_char[i]=='}'){
                if(c[number-1]=='{'){
                    number--;
                }else{
                    return false;
                }
            }

        }
        if(number>0){
            return false;
        }




        return true;
    }
}
