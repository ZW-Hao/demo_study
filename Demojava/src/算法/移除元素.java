package 算法;

public class 移除元素 {
    public static void main(String[] args) {
        int[] nums = {};

        System.out.println(removeElement(nums, 2));
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeElement(int[] nums, int val) {
        int low = 0;
        int high = nums.length - 1;

        if(high<0){
            return 0;
        }
        while (low < high) {


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
        }
        if(nums[high]==val){
            return high;
        }
        return high+1 ;
    }
}
