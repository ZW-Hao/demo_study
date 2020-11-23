package 算法;

public class 删除重复项 {

    public static void main(String[] args) {
        int[] nums={1,1,2};
        System.out.println(removeDuplicates(nums));
    }

    public  static int removeDuplicates(int[] nums) {

        int low=1;
        int high=nums.length-1;
        int val=nums[low-1];
        while(low<high){
            if (nums[low] == val) {
                if (nums[high] != val) {
                    nums[low] = nums[high];
                    high--;
                } else {
                    high--;
                    continue;
                }

            }
            low++;
            val=nums[low-1];
        }


        return high+1;
    }
}
