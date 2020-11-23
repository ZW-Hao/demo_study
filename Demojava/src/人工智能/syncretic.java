package 人工智能;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

//求最一般合一
/*
    求公式集S={P(a,x,f(g(y)))  ,  P(z,h(z,u),f(u))}的最一般合一
    首先要存入这两个将集合元素
 */
public class syncretic {

    static ArrayList<String> gongshi_one=new ArrayList<>();
    static ArrayList<String> gongshi_two=new ArrayList<>();
    //使用hashmap储存替换规则
    static HashMap<String,String> o=new HashMap<>();//用键来替换值

    public static void main(String[] args) {
        //将集合中的元素存储起来
        /*gongshi_one.add("a");
        gongshi_one.add("x");
        gongshi_one.add("f(g(y))");
        gongshi_two.add("z");
        gongshi_two.add("h(z,u)");
        gongshi_two.add("f(u)");*/

        gongshi_one.add("u");
        gongshi_one.add("y");
        gongshi_one.add("g(y)");
        gongshi_two.add("x");
        gongshi_two.add("f(u)");
        gongshi_two.add("z");
        //显示公式集
        System.out.println("给定的元素集");
        showFormulaSet();
        System.out.println("===============================");


        //找出第一个元素的替换
        tihuan(0);
        System.out.println("替换规则：");
        showtihuan();
        qiuxingongshi();
        System.out.println("替换后形成的新元素集：");
        showFormulaSet();
        //判断是否为单元素集
        if_danyuansuji();
        System.out.println("===============================");

        //找出第二个元素的替换
        tihuan(1);
        System.out.println("替换规则：");
        showtihuan();
        qiuxingongshi();
        System.out.println("替换后形成的新元素集：");
        showFormulaSet();
        //判断是否为单元素集
        if_danyuansuji();
        System.out.println("===============================");

        //找出第二个元素的替换
        tihuan(2);
        System.out.println("替换规则：");
        showtihuan();
        qiuxingongshi();
        System.out.println("替换后形成的新元素集：");
        showFormulaSet();
        //判断是否为单元素集
        if_danyuansuji();
        System.out.println("===============================");

        System.out.println("找到最一般合一：");
        showtihuan();
    }


    private static void qiuxingongshi() {
        //遍历gongshione 和 gongshitwo，如果存在和替换规则中的键相同的字符，则将其替换为相应的值
        Set<String> keys=o.keySet();
        String[] gongshione_zero=gongshi_one.get(0).split("");
        String[] gongshione_one=gongshi_one.get(1).split("");
        String[] gongshione_two=gongshi_one.get(2).split("");
        String[] gongshitwo_zero=gongshi_two.get(0).split("");
        String[] gongshitwo_one=gongshi_two.get(1).split("");
        String[] gongshitwo_two=gongshi_two.get(2).split("");
        for(String key:keys){
            for (int i = 0; i < gongshione_zero.length; i++) {
                if(gongshione_zero[i].equals(key)){
                    gongshione_zero[i]=o.get(key);
                }
            }
            String str="";
            for (int i = 0; i < gongshione_zero.length; i++) {

                str=str+gongshione_zero[i];
            }
            gongshi_one.set(0,str);
            for (int i = 0; i < gongshione_one.length; i++) {
                if(gongshione_one[i].equals(key)){
                    gongshione_one[i]=o.get(key);
                }
            }
            str="";
            for (int i = 0; i < gongshione_one.length; i++) {

                str=str+gongshione_one[i];
            }
            gongshi_one.set(1,str);
            for (int i = 0; i < gongshione_two.length; i++) {
                if(gongshione_two[i].equals(key)){
                    gongshione_two[i]=o.get(key);
                }
            }
            str="";
            for (int i = 0; i < gongshione_two.length; i++) {

                str=str+gongshione_two[i];
            }
            gongshi_one.set(2,str);
            for (int i = 0; i < gongshitwo_zero.length; i++) {
                if(gongshitwo_zero[i].equals(key)){
                    gongshitwo_zero[i]=o.get(key);
                }
            }
            str="";
            for (int i = 0; i < gongshitwo_zero.length; i++) {

                str=str+gongshitwo_zero[i];
            }
            gongshi_two.set(0,str);
            for (int i = 0; i < gongshitwo_one.length; i++) {
                if(gongshitwo_one[i].equals(key)){
                    gongshitwo_one[i]=o.get(key);
                }
            }
            str="";
            for (int i = 0; i < gongshitwo_one.length; i++) {

                str=str+gongshitwo_one[i];
            }
            gongshi_two.set(1,str);
            for (int i = 0; i < gongshitwo_two.length; i++) {
                if(gongshitwo_two[i].equals(key)){
                    gongshitwo_two[i]=o.get(key);
                }
            }
            str="";
            for (int i = 0; i < gongshitwo_two.length; i++) {

                str=str+gongshitwo_two[i];
            }
            gongshi_two.set(2,str);

        }
    }


    private static void tihuan(int num) {
        if(gongshi_one.get(num).equals(gongshi_two.get(num))){
            System.out.println("两个元素相同");
        }else{
            //将集合中的元素分割，判断其中是否含有变元（x,y,z）,如果含有变元则用常量来替换
            String[] strsplitone=gongshi_one.get(num).split("");
            String[] strsplittwo=gongshi_two.get(num).split("");
            //判断是否为变量
            boolean flagone=false;
            boolean flag=false;//判断变量是否被一个函数包围，如果变量周围是一个函数，则将其整体表示在差异集中
            int count=0;
            for (int i = 0; i < strsplitone.length; i++) {
                if(strsplitone[i].equals("f")||strsplitone[i].equals("g")){
                    count++;
                }
            }
            if(count>=2){
                flag=true;
            }

            if(!flag){
                for (int i = 0; i < strsplitone.length; i++) {
                    if(strsplitone[i].equals("x")||
                            strsplitone[i].equals("y")||
                            strsplitone[i].equals("z")
                    ){
                        flagone=true;//如果存在着变量，置为true
                    }
                }

                boolean flagtwo=false;
                for (int i = 0; i < strsplittwo.length; i++) {
                    if(strsplittwo[i].equals("x")||
                            strsplittwo[i].equals("y")||
                            strsplittwo[i].equals("z")
                    ){
                        flagtwo=true;//如果存在着变量，置为true
                    }
                }
                //差异集中如果存在两个函数，需要单独判断替换规则

                //对差异集中没有两个函数时变量的处理，找出替换规则
                if(flagone && !flagtwo){
                    o.put(gongshi_one.get(num),gongshi_two.get(num));
                }
                if(!flagone && flagtwo){
                    o.put(gongshi_two.get(num),gongshi_one.get(0));
                }
            }else{
                //对最后一种的处理操作

                //找出差异集
                if(strsplitone.length>strsplittwo.length){
                    String strone="";
                    String strtwo="";//存储差异集
                    //消去两个表达式中相同的元素，判断相同元素时只能消去一个元素
                    //消去左右括号时要判断，只能消去一个
                    for (int i = 0; i < strsplittwo.length; i++) {
                        for (int j = 0; j < strsplitone.length; j++) {
                            if(strsplitone[j].equals(strsplittwo[i])){
                                strsplitone[j]="";
                                strsplittwo[i]="";
                                break;
                            }
                        }
                    }
                    for (int i = 0; i < strsplitone.length; i++) {
                        strone=strone+strsplitone[i];
                    }
                    for (int i = 0; i < strsplittwo.length; i++) {
                        strtwo=strtwo+strsplittwo[i];
                    }

                    /*System.out.println("====");
                    System.out.println(strone);
                    System.out.println(strtwo);
                    System.out.println("====");*/
                    boolean flagthree=false;
                    boolean flagfour=false;
                    for (int i = 0; i < strone.toCharArray().length; i++) {
                        if(strone.toCharArray()[i]=='f'||
                                strone.toCharArray()[i]=='g'||
                                strone.toCharArray()[i]=='h'
                        ){
                            flagthree=true;
                        }
                    }

                    for (int i = 0; i < strtwo.toCharArray().length; i++) {
                        if(
                                strtwo.toCharArray()[i]=='f'||
                                        strtwo.toCharArray()[i]=='g'||
                                        strtwo.toCharArray()[i]=='h'

                        ){
                            flagfour=true;
                        }
                    }

                    if(flagthree&&!flagfour){//strone中有函数，strsplitone中有函数，将strsplittwo中的变量替换
                        o.put(strtwo,strone);
                    }

                }else{
                    // TODO: 2020/11/18 当strsplittwo[2] 比strsplitone[2]中字符数多的时候，和if中的代码一致，换一下变量就行
                }

            }





        }
    }

    /*private static void jiancha(){
        Set<String> keys=o.keySet();
        for(String keyone:keys){
            for(String keytwo:keys){
                if(o.get(keytwo).equals(keyone)){

                }
            }
        }
    }*/
    private static void if_danyuansuji() {
        if(gongshi_one.get(0).equals(gongshi_two.get(0))
                &&gongshi_one.get(1).equals(gongshi_two.get(1))
                &&gongshi_one.get(2).equals(gongshi_two.get(2))
        ){
            System.out.println("已经是单元素集");
        }else{
            System.out.println("不是单元素集");
        }
    }

    private static void showtihuan() {
        Set<String> keys=o.keySet();
        System.out.print("{  ");
        for(String key:keys){
            System.out.print(o.get(key)+"/"+key+"    ");
        }
        System.out.println("  }");
    }
    private static void showFormulaSet() {
        System.out.println("{P("+gongshi_one.get(0)+","+gongshi_one.get(1)+","+gongshi_one.get(2) +")"
                +"    "+"P("+gongshi_two.get(0)+","+gongshi_two.get(1)+","+gongshi_two.get(2)+")"+"}");
    }

}
