package 算法;

public class 实现strStr {





    public static void main(String[] args) {
        String haytack="mississippi";
        String needle="issipi";
        //判断needle中的字符串在hsystack中第一次出现的位置,如果存在返回位置索引，如果不存在返回-1
        System.out.println(strStr(haytack,needle));
        System.out.println();

    }

    public static int strStr(String haystack, String needle) {
        int countneed=0;//存储needle中字符的个数，如果个数大于haystack，则返回-1
        int counthay=0;
        countneed=needle.toCharArray().length;
        counthay=haystack.toCharArray().length;
        if(counthay<countneed){
            return -1;
        }
        if(countneed==0){
            return 0;
        }
        //定义两个指针索引，分别指向两个字符串
        int falgone=0;
        int falgtwo=0;
        int i=0;
        char[] hay=haystack.toCharArray();
        char[] need=needle.toCharArray();

        while(falgone<counthay){
            while(falgtwo<countneed){
                if(i>counthay-1){
                    break;
                }
                if(need[falgtwo]!=hay[i]){
                    break;
                }
                if(falgtwo==countneed-1){
                    return falgone;
                }
                i++;
                falgtwo++;
            }

            falgone++;
            i=falgone;
            falgtwo=0;

        }


        return -1;
    }
}
