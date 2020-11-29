package 算法;

public class 二进制求和 {
    public static void main(String[] args) {
        String b="1";
        String a="1";
        String s = addBinary(a, b);
        System.out.println(s);
    }

    public static String addBinary(String a, String b) {
        if(a.equals("0")&&b.equals("0")){
            return "0";
        }
        //需要将元素进行对齐后再进行下一步的相加运算
        char[] charone=null;
        char[] chartwo=null;
        String strzero="";
        String addbinary="";
        if(a.toCharArray().length>=b.toCharArray().length){
            charone=a.toCharArray();
            for (int i = 0; i < a.length()-b.length(); i++) {
                strzero=strzero+"0";
            }
                b=strzero+b;

            chartwo=b.toCharArray();
            //得到对齐后的字符串
            //与门  或门  的实现方法
            char flag='0';
            char[] result=new char[charone.length+1];
            for (int i = charone.length-1; i >= 0; i--) {
                if(charone[i]=='0'&&chartwo[i]=='0'){
                    if(flag=='0'){
                        result[i+1]='0';
                    }else{
                        result[i+1]='1';
                        flag='0';
                    }
                }
                if(charone[i]=='1'&&chartwo[i]=='1'){
                    if(flag=='0'){
                        result[i+1]='0';
                        flag='1';
                    }else {
                        result[i+1]='1';
                        flag='1';
                    }
                }
                if(charone[i]=='0'&&chartwo[i]=='1'){
                    if(flag=='0'){
                        result[i+1]='1';
                    }else{
                        result[i+1]='0';
                        flag='1';
                    }
                }
                if(charone[i]=='1'&&chartwo[i]=='0'){
                    if(flag=='0'){
                        result[i+1]='1';
                    }else{
                        result[i+1]='0';
                        flag='1';
                    }
                }
            }
            //对第一个元素进行处理,因为此时第一个二进制数一定比第二个长，所以进位取决于flag的值
            if(flag=='1'){
                result[0]='1';
            }else{
                result[0]='0';
            }
            for (int i = 0; i < result.length; i++) {
                addbinary=addbinary+result[i];
            }
          //  System.out.println(addbinary);




        }else{

            charone=b.toCharArray();
            for (int i = 0; i < b.length()-a.length(); i++) {
                strzero=strzero+"0";
            }
            a=strzero+a;
            chartwo=a.toCharArray();
            //得到对齐后的字符串
            //与门  或门  的实现方法
            char flag='0';
            char[] result=new char[charone.length+1];
            for (int i = charone.length-1; i >= 0; i--) {
                if(charone[i]=='0'&&chartwo[i]=='0'){
                    if(flag=='0'){
                        result[i+1]='0';
                    }else{
                        result[i+1]='1';
                        flag='0';
                    }
                }
                if(charone[i]=='1'&&chartwo[i]=='1'){
                    if(flag=='0'){
                        result[i+1]='0';
                        flag='1';
                    }else {
                        result[i+1]='1';
                        flag='1';
                    }
                }
                if(charone[i]=='0'&&chartwo[i]=='1'){
                    if(flag=='0'){
                        result[i+1]='1';
                    }else{
                        result[i+1]='0';
                        flag='1';
                    }
                }
                if(charone[i]=='1'&&chartwo[i]=='0'){
                    if(flag=='0'){
                        result[i+1]='1';
                    }else{
                        result[i+1]='0';
                        flag='1';
                    }
                }
            }
            //对第一个元素进行处理,因为此时第一个二进制数一定比第二个长，所以进位取决于flag的值
            if(flag=='1'){
                result[0]='1';
            }else{
                result[0]='0';
            }
            for (int i = 0; i < result.length; i++) {
                addbinary=addbinary+result[i];
            }
           // System.out.println(addbinary);

        }

        //对结果字符串进行处理，如果最前面是0，需要去掉
        String str="";
        String[] strsplit=addbinary.split("");
        if(strsplit[0].equals("0")){
            strsplit[0]="";
            for (int i = 0; i < strsplit.length; i++) {
                str=str+strsplit[i];
            }
            addbinary=str;
        }


        return addbinary;
    }
}
