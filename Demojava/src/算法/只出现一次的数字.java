package 算法;

public class 只出现一次的数字 {

    public static void main(String[] args) {
        int [] nums={4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }

    /*public static int singleNumber(int[] nums) {
        int result=0;
        //判断当前数字出现的次数，遍历数组，如果当前数组只出现一次则将其返回，如果数组中有相同的数字，则判断下一个数字
        *//*int high=nums.length-1;
        int low=0;
        while(low<high){
            while(low<high){
                if(nums[low]==nums[high]){
                    break;
                }
                high--;
            }

            if(low==high){
                return nums[low];
            }

            high=nums.length-1;
            low++;
        }*//*

        //双循环方法，时间复杂度太高
        *//*int i=0;
        int j=0;
        for (i = 0; i <nums.length ; i++) {
            for (j = 0; j < nums.length; j++) {
                if(nums[i]==nums[j]&&i!=j){
                    break;
                }
            }
            if(j==nums.length){
                return nums[i];
            }

        }
*//*
        //线性时间复杂度

        //提前判断第一个数字是否有重复的
        int k;
        for (k=1; k < nums.length; k++) {
            if(nums[0]==nums[k]){
                break;
            }
        }
        if(k==nums.length){
            return nums[0];
        }

        int low=0;
        int high=nums.length-1;
        for (high=nums.length-1 ; high >=0; high--) {
            if(high==0&&nums[0]!=nums[low]){
                return nums[low];
            }
            if(nums[low]==nums[high]&&low!=high){
                low++;
                high=nums.length;//for会执行一次--
            }
        }


       return 0;
    }*/


        public static int singleNumber(int[] nums) {
            int res = 0;
            for (int i : nums) {
                res ^= i;
            }
            return res;
        }

}
