package 算法;

public class 回文数 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1211));
    }

    public static boolean isPalindrome(int x) {
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
    }
}
