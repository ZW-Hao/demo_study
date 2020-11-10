
package 人工智能;

        import java.text.DecimalFormat;
        import java.util.Random;

        import static java.lang.System.arraycopy;

//遗传算法实现
//p89页算法实现y=x^2在0—31上的最大值
//生成初始种群，通过遗传、交叉、变异来找到最大值31（二进制为11111）
public class GeneticAlgorithm {

    public static void main(String[] args) {
        Random r=new Random();
        int x=0;//变异率，当累积到10的时候发生变异
        //生成初始种群，数组存储
        int[] a={0,1,1,0,1};//13
        int[] b={1,1,0,0,0};//24
        int[] c={0,1,0,0,0};//8
        int[] d={1,0,0,1,1};//19
        double r1=0.450126;
        double r2=0.110347;
        double r3=0.572496;
        double r4=0.98503;

        int[] count;
        int number=0;
        while(true){
            System.out.println("遗传前：");
            show(a);
            show(b);
            show(c);
            show(d);
            x=2+x;
            System.out.println("变异的概率："+x+"(等于10的时候发生变异)");
            if(x>=10){
                Mutations(x,a,b,c,d);
                x=0;
            }
            count=count(a,b,c,d,r1,r2,r3,r4);
            System.out.print("种群被选择的次数：");
            show(count);
            //show(count);
            fuzhi(a,b,c,d,count);
            //生成随机数，确定需要交换的两个染色体编码
            int ran=r.nextInt(3);
            if(all_is_one(count)){
                if(ran==0){
                    cross(a,b,3);
                    cross(c,d,3);
                }
                if(ran==1){
                    cross(a,c,3);
                    cross(b,d,3);
                }
                if(ran==2){
                    cross(a,d,3);
                    cross(b,c,3);
                }


            }else{
                if(ran==0){
                    cross(a,b);
                    cross(c,d);
                }
                if(ran==1){
                    cross(a,c);
                    cross(b,d);
                }
                if(ran==2){
                    cross(a,d);
                    cross(b,c);
                }
            }
//        int sum=calculate(a);
//        System.out.println(sum);
            System.out.println("遗传后：");
            show(a);
            show(b);
            show(c);
            show(d);
            System.out.println("================");
            number++;
            if(is_end(a,b,c,d)){
                break;
            }
            if(number>100){
                System.out.println("循环达到上限");
                break;
            }
        }
        if(number<=100){
            System.out.println("找到染色体编码为【1，1，1，1，1】的种群");
        }
    }
    //变异，将0随机变为1
    public static void Mutations(int x,int[] a,int[] b,int[] c,int[] d){
        Random r=new Random();
        int ran=r.nextInt(4);

        if(x>=10){
//            System.out.println(ran);
            if(ran==0){
                for (int i = 0; i < a.length; i++) {
                    if(a[i]==0){
                        a[i]=1;
                        System.out.println("a种群中的第"+i+"个编码由0变为1");
                        break;
                    }
                }
            }
            if(ran==1){
                for (int i = 0; i < b.length; i++) {
                    if(b[i]==0){
                        b[i]=1;
                        System.out.println("b种群中的第"+i+"个编码由0变为1");
                        break;
                    }
                }
            }
            if(ran==2){
                for (int i = 0; i < c.length; i++) {
                    if(c[i]==0){
                        c[i]=1;
                        System.out.println("c种群中的第"+i+"个编码由0变为1");
                        break;
                    }
                }
            }
            if(ran==3){
                for (int i = 0; i < d.length; i++) {
                    if(d[i]==0){
                        d[i]=1;
                        System.out.println("d种群中的第"+i+"个编码由0变为1");
                        break;
                    }
                }
            }
        }

    }
    //判断count是否全为一
    public  static boolean all_is_one(int[] count){
        boolean flag=true;
        for (int j : count) {
            if (j != 1) {
                flag = false;
                break;
            }
        }
        return flag;
    }
    //判断是否出现了{1，1，1，1，1}的种群，出现了则需要停止复制交叉变异
    public static boolean is_end(int[] a,int[] b,int[] c,int[] d){
        boolean flag=false;
        boolean flagone=true;
        boolean flagtwo=true;
        boolean flagthree=true;
        boolean flagfour=true;

        for (int j : a) {
            if (j != 1) {
                flagone = false;
                break;
            }
        }
        for (int j : b) {
            if (j != 1) {
                flagtwo = false;
                break;
            }
        }
        for (int j : c) {
            if (j != 1) {
                flagthree = false;
                break;
            }
        }
        for (int j : d) {
            if (j != 1) {
                flagfour = false;
                break;
            }
        }
        if(flagone || flagtwo||flagthree||flagfour){
            flag=true;
        }
        return flag;
    }
    //交叉,传入两个种群的染色体，进行交叉操作，交换染色体的后三位

    public  static void cross(int[] a,int[] b,int bit){
        int tempone;
        int temptwo;
        int tempthree;
        tempone=a[3];
        temptwo=a[4];
        tempthree=a[2];
        a[2]=b[2];
        a[3]=b[3];
        a[4]=b[4];
        b[2]=tempthree;
        b[3]=tempone;
        b[4]=temptwo;
    }
    //交叉,传入两个种群的染色体，进行交叉操作，交换染色体的后两位
    public  static void cross(int[] a,int[] b){
        int tempone;
        int temptwo;
        tempone=a[3];
        temptwo=a[4];
        a[3]=b[3];
        a[4]=b[4];
        b[3]=tempone;
        b[4]=temptwo;
    }
    //种群数组复制
    public static void copy(int[] a,int[] b){
        arraycopy(b, 0, a, 0, a.length);
    }
    //复制染色体
    public static void fuzhi(int[]a,int[]b,int[]c,int[]d,int[]count){
        int flagzero=0;
        int flagtwo=0;
        for (int i = 0; i < count.length; i++) {
            //标记选中次数为0和2的种群
            if(count[i]==0){
                flagzero=i;
            }
            if(count[i]==2){
                flagtwo=i;
            }
        }
//        copy(c,b);
        if(flagzero==0&&flagtwo==1){
            copy(a,b);
        }
        if(flagzero==0&&flagtwo==2){
            copy(a,c);
        }
        if(flagzero==0&&flagtwo==3){
            copy(a,d);
        }
        if(flagzero==1&&flagtwo==0){
            copy(b,a);
        }
        if(flagzero==1&&flagtwo==2){
            copy(b,c);
        }
        if(flagzero==1&&flagtwo==3){
            copy(b,d);
        }
        if(flagzero==2&&flagtwo==0){
            copy(c,a);
        }
        if(flagzero==2&&flagtwo==1){
            copy(c,b);
        }
        if(flagzero==2&&flagtwo==3){
            copy(c,b);
        }
        if(flagzero==3&&flagtwo==0){
            copy(d,a);
        }
        if(flagzero==3&&flagtwo==1){
            copy(d,b);
        }
        if(flagzero==3&&flagtwo==2){
            copy(d,c);
        }



//        System.out.println("=====");
//        System.out.println(flagzero);
//        System.out.println(flagtwo);
    }
    //估计被返回的次数,传入种群的二进制编码和生成的随机数，计算适应度、选择概率、累积概率、选择次数
    public static int[] count(int[] a,int[] b,int[] c,int[] d,double m,double n,double p,double q){

        int[] count={0,0,0,0};
        int add;//适应度之和
        int a1=calculate(a)*calculate(a);//a的适应度
        int b1=calculate(b)*calculate(b);
        int c1=calculate(c)*calculate(c);
        int d1=calculate(d)*calculate(d);
        add=a1+b1+c1+d1;
        //计算选择概率
        double a2=(double)(Math.round((a1*1.0)*100/add)/100.0);
        double b2=(double)(Math.round((b1*1.0)*100/add)/100.0);
        double c2=(double)(Math.round((c1*1.0)*100/add)/100.0);
        double d2=(double)(Math.round((d1*1.0)*100/add)/100.0);
        //计算积累概率
        double a3=a2;
        double b3=a2+b2;
        double c3=a2+b2+c2;
        double d3=a2+b2+c2+d2;
        //估计选择次数
        if(m<a3){
            count[0]++;
        }
        if(n<a3){
            count[0]++;
        }
        if(p<a3){
            count[0]++;
        }
        if(q<a3){
            count[0]++;
        }
        if(m>a3&&m<b3){
            count[1]++;
        }
        if(n>a3&&n<b3){
            count[1]++;
        }
        if(p>a3&&p<b3){
            count[1]++;
        }
        if(q>a3&&q<b3){
            count[1]++;
        }
        if(m>b3&&m<c3){
            count[2]++;
        }
        if(n>b3&&n<c3){
            count[2]++;
        }
        if(p>b3&&p<c3){
            count[2]++;
        }
        if(q>b3&&q<c3){
            count[2]++;
        }
        if(m>c3&&m<d3){
            count[3]++;
        }
        if(n>c3&&n<d3){
            count[3]++;
        }
        if(p>c3&&p<d3){
            count[3]++;
        }
        if(q>c3&&q<d3){
            count[3]++;
        }
//        System.out.println(a2);
//        System.out.println(b2);
//        System.out.println(c2);
//        System.out.println(d2);
        return count;
    }
    //求二进制编码所对应的十进制数
    public static int calculate(int[] a){
        int sum=0;
        sum=a[4]+a[3]*2+a[2]*4+a[1]*8+a[0]*16;
        return sum;
    }
    //打印种群编码
    public static void show(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}