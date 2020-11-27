package 算法;

public class 搜索目标值最先和最后位置 {

    public static void main(String[] args) {
        int [] nums={5,7,7,8,8,10};
        int[] ints = searchRange(nums, 11);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }


    }
    //时间复杂度为O（n）的情况
    public static int[] searchRange(int[] nums,int target){
        int[] result=new int[2];
        int i,j;
        for ( i = 0; i < nums.length; i++) {
            if(nums[i]==target){
                result[0]=i;
                break;
            }
        }

        for (j = nums.length-1; j >=0 ; j--) {
            if(nums[j]==target){
                result[1]=j;
                break;
            }
        }

        if(i>nums.length-1){
            result[0]=-1;
        }
        if(j<0){
            result[1]=-1;
        }

        return result;
    }
    //时间复杂度为log（n）的情况需要用二分查找法

}
