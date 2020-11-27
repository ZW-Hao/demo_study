package 算法;

public class 删除重复项 {

    public static void main(String[] args) {
        int[] nums={};
        System.out.println(removeDuplicates(nums));
    }

    public  static int removeDuplicates(int[] nums) {

        int low=0;
        int high=1;
        if(nums.length==0){
            return 0;
        }
        while(high<nums.length){
            if(nums[low]==nums[high]){
                high++;
            }else{
                low++;
                nums[low]=nums[high];
                high++;
            }
        }
        return low+1;
    }
}
