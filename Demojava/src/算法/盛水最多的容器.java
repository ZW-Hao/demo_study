package 算法;

import static java.lang.Math.max;

public class 盛水最多的容器 {
    public static void main(String[] args) {
        int[] height={8,4,3,77,99,4,1,3,7};
        System.out.println(maxArea(height));
    }
    public static int maxArea(int[] height) {

        int low=0;
        int high=height.length-1;
        int sum;
        sum=(high-low)*min(height[low],height[high]);
        while(low<high){
            sum=max(sum,(high-low)*min(height[low],height[high]));
            if(height[low]>height[high]){
                high--;
            }else{
                low++;
            }

        }
        return sum;
    }

    private static int min(int a, int b) {
        if(a>=b){
            return b;
        }else{
            return a;
        }
    }
}
