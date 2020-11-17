package 算法;
/*
给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。


//数组中的数字过多时会发生超时的情况
//采用快速排序先将数组由小到大进行一次排序处理，然后定义两个指针分别指向数组的开头和末尾的元素，
//会有三种情况
//1、如果指针指向的两个数之和等于目标值，则找到这两个数，将这两个数和原数组中的位置进行对比，可以得到这两个数在原数组中的位置
//2、如果指针指向的两个数之和大于目标值，则将high指针向前移动
//3、如果指针指向的两个数之和小于目标值，则将low指针向后移动
//当low指针和high指针相遇时结束循环，此时返回的数组的值为【0，0】


 */
public class one {

    //快速排序
    public static void main(String[] args) {
        int[] nums={-1,-2,-3,-4,-5};
        int[] a=twoSum(nums,-8);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target){
        int[] result=new int[2];
        int[] buffer=new int[2];
        int[] nums_demo=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums_demo[i]=nums[i];
        }
        if(nums[0]+nums[nums.length]==target){
            result[0]=0;
            result[1]=nums.length-1;
            return result;
        }
        quicksort(nums_demo,0,nums_demo.length-1);
        int low=0;
        int high=nums.length-1;
        while(low<high){
            if(nums_demo[low]+nums_demo[high]==target){
                buffer[0]=nums_demo[low];
                buffer[1]=nums_demo[high];
                break;
            }
            if(nums_demo[low]+nums_demo[high]>target){
                high--;
                continue;
            }
            if(nums_demo[low]+nums_demo[high]<target){
                low++;
                continue;
            }
        }
        int count=0;

        for (int i=0; i < nums.length; i++) {
            if(buffer[0]==nums[i]){
                result[0]=i;
                break;
            }

        }
        for (int i = 0; i < nums.length; i++) {
            if(buffer[1]==nums[i]&&i!=result[0]){
                result[1]=i;
                break;
            }
        }
        //此时返回的时新数组中的位置，需要将新数组中的位置和原来数组中的位置进行比较，得出原来数字的位置
        return  result;
    }
    static void quicksort(int n[], int left, int right) {
        int dp;
        if (left < right) {
            dp = partition(n, left, right);
            quicksort(n, left, dp - 1);
            quicksort(n, dp + 1, right);
        }
    }

    static int partition(int n[], int left, int right) {
        int pivot = n[left];
        while (left < right) {
            while (left < right && n[right] >= pivot)
                right--;
            if (left < right)
                n[left++] = n[right];
            while (left < right && n[left] <= pivot)
                left++;
            if (left < right)
                n[right--] = n[left];
        }
        n[left] = pivot;
        return left;
    }
    /*public static int[] twoSum(int[] nums, int target) {

        //定义两个指针分别指向头尾
        int [] result=new int[2];
        int low=0;
        int high=nums.length-1;
        while(low<high){
            while(low<high){
                if(nums[low]+nums[high]==target){
                    result[0]=low;
                    result[1]=high;
                    break;
                }
                high--;
            }
            high=nums.length-1;
            low++;
            if(result[0]!=0&&result[1]!=0){
                break;
            }
        }
        return result;
    }*/
}
