package 排序算法;

public class selectSort {
    //选择排序，找到最小值放到前面
    static void selectSort(int[] array){
        int minPosition=0;

        for (int j = 0; j <array.length ; j++) {
            minPosition=j;
            //找到最小值和第一个数进行交换
            for (int i = j; i < array.length; i++) {
                if (array[minPosition]>array[i]){
                    minPosition=i;
                }
            }
            //找到最小值位置后进行交换
            swap(array,minPosition,j);




        }




    }


    private static void swap(int[] array,int a,int b) {
        int temp;
        temp=array[a];
        array[a]=array[b];
        array[b]=temp;
    }

    public static void main(String[] args) {
        int[] arrry={6,4,2,1,3,8,7,9};

        selectSort(arrry);


        for (int i = 0; i < arrry.length; i++) {
            System.out.println(arrry[i]);
        }
    }
}
