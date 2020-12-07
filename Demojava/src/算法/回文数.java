package 算法;

public class 回文数 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1211));
    }

    /*public static boolean isPalindrome(int x) {
        String s=""+x;
        String[] split = s.split("");
        int low=0;
        int high=split.length-1;
        while(low<=high){
            if(!split[low].equals(split[high])){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }*/
    //不转换为字符串的写法
    public static boolean isPalindrome(int x){
        //负数一定不是回文数
        if(x<0){
            return false;
        }
        //计算出倒着读出的数的值，与x进行比较,如果相等返回true 否则返回false
        int y=x;
        int num=0;
        while(y!=0){
            num=num*10+y%10;
            y=y/10;
        }


        return num==x;

    }
}
