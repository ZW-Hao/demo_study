package 算法;

public class two {
    public static void main(String[] args) {
        int[] nums={1,3,5,6,7,7};
        int a=searchInsert(nums,8);
        System.out.println(a);
    }
    public static int searchInsert(int[] nums, int target) {


        int i=0;
        for (i = 0; i < nums.length; i++) {

            if(target==nums[i]){
                return i;

            }else if(target<nums[i]){
                return i;

            }

        }
        if(i>=nums.length){
            return nums.length;
        }
        return 0;
    }
}
