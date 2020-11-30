package 算法;

public class 合并有序数组 {
    // TODO: 2020/11/30 合并排序数组 
    public static void main(String[] args) {
        //创建两个有序数组
        int[] a={1,2,3,0,0,0};
        int[] b={2,5,6};
        merge(a,3,b,3);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    public  static void merge(int[] nums1, int m, int[] nums2, int n) {
        //nums1数组足够大，需要将nums1中的数字向后移动
        //m n分别是两个数组的长度
        for (int i = 0; i < nums2.length; i++) {
            for (int j = 0; j < nums1.length; j++) {
                //2中元素大于1中元素
                if(nums2[i]>=nums1[j]){
                    j++;
                }else{
                    //当1中元素大于2中元素的时候，需要将2中的元素放到1中元素之前，即需要向后移动1中的元素
                    for (int k = m+1; k >j ; k--) {
                        nums1[k]=nums1[k-1];
                    }
                    nums1[j]=nums2[i];

                }
            }
        }

    }
}
