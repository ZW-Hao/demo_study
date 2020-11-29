package 算法;

import java.util.Arrays;

public class 加一 {
    //数组中组成的数字加上1
    public static void main(String[] args) {
        int[] digts={9,9,5,8,9,9,7,8,9,9,9};
        Arrays.stream(plusOne(digts)).forEach(System.out::println);

    }
    public static int[] plusOne(int[] digits){
        int [] result=new int[digits.length+1];
        if(digits[digits.length-1]!=9){
            digits[digits.length-1]=digits[digits.length-1]+1;
            return digits;
        }
        //判断9存在的个数，从后向前判断，直到找到不是9的数，将其加1，将其后面的数全部变为0
        int flag=0;
        int j;
        for ( j = digits.length-1; j >=0; j--) {
            if(digits[j]!=9){
                flag=j;
                break;
            }

        }
        //System.out.println(flag);
        if(j>=0){
            digits[flag]=digits[flag]+1;
            for (int i = flag+1; i <digits.length ; i++) {
                digits[i]=0;
            }
        }else{
            result[0]=1;
            return result;

        }

        //特殊情况，数组中的元素全都为9，需要开辟一个新的数组来存储计算结果
        return digits;

    }
}
