package 编译原理;

import java.util.ArrayList;

public class OperatorPrecedenceGrammar {

    /*
        算符优先文法实现，先求出firstvt和lastvt，通过firstvt和lastvt求出算符优先关系表
        E→E+T|E-T|T    T→T*F|T/F|F    F→(E)|id

    E→E+T
    E→E-T
    E→T
    T→T*F
    T→T/F
    T→F
    F→(E)
    F→id

    求解完firstvt和lastvt之后判断文法中的右半部分
    如果存在 E+  则说明lastvt（E）> +
    如果存在 +E  则说明firstvt（E）> +
    以此类推判断所有出现的元素是否存在以上文法

     */
    static String grammer_E="E → E + T | E - T | T";
    static String grammer_T="T → T * F | T / F | F";
    static String grammer_F="F → ( E ) | id";

    static ArrayList<String> first_vt_E=new ArrayList<>();
    static ArrayList<String> first_vt_T=new ArrayList<>();
    static ArrayList<String> first_vt_F=new ArrayList<>();
    static ArrayList<String> lastvt_E=new ArrayList<>();
    static ArrayList<String> lastvt_T=new ArrayList<>();
    static ArrayList<String> lastvt_F=new ArrayList<>();
    public static void main(String[] args) {


        getfistvt(grammer_F,first_vt_F);
        System.out.println("F的firstvt集");
        for (int i = 0; i < first_vt_F.size(); i++) {
            System.out.print(first_vt_F.get(i));
        }
        System.out.println();
        System.out.println("T的firstvt集");
        getfistvt(grammer_T,first_vt_T);
        for (int i = 0; i < first_vt_T.size(); i++) {
            System.out.print(first_vt_T.get(i));
        }
        System.out.println();
        System.out.println("E的firstvt集");
        getfistvt(grammer_E,first_vt_E);
        for (int i = 0; i < first_vt_E.size(); i++) {
            System.out.print(first_vt_E.get(i));
        }
        System.out.println();
        System.out.println("F的lastvt集");
        getlastvt(grammer_F,lastvt_F);
        for (int i = 0; i < lastvt_F.size(); i++) {
            System.out.print(lastvt_F.get(i));
        }
        System.out.println();
        System.out.println("T的lastvt集");
        getlastvt(grammer_T,lastvt_T);
        for (int i = 0; i < lastvt_T.size(); i++) {
            System.out.print(lastvt_T.get(i));
        }
        System.out.println();
        System.out.println("E的lastvt集");
        getlastvt(grammer_E,lastvt_E);
        for (int i = 0; i < lastvt_E.size(); i++) {
            System.out.print(lastvt_E.get(i));
        }
        System.out.println();


        //求优先级关系


        if(grammer_E.contains("E +")){
            System.out.print("+  <  ");        }
        for (int i = 0; i < lastvt_E.size(); i++) {
            System.out.print(lastvt_E.get(i)+"  ");
        }
        System.out.println();
        if (grammer_E.contains("+ T")){
            System.out.print("+  <  ");
        }
        for (int i = 0; i < first_vt_T.size(); i++) {
            System.out.print(first_vt_T.get(i)+" ");
        }
        System.out.println();
        if(grammer_E.contains("E -")){
            System.out.print("-  <  ");        }
        for (int i = 0; i < lastvt_E.size(); i++) {
            System.out.print(lastvt_E.get(i)+"  ");
        }
        System.out.println();
        if (grammer_E.contains("- T")){
            System.out.print("-  <  ");
        }
        for (int i = 0; i < first_vt_T.size(); i++) {
            System.out.print(first_vt_T.get(i)+" ");
        }

        //T→T*F|T/F|F
        System.out.println();

        if(grammer_T.contains("T *")){
            System.out.print("*  <  ");        }
        for (int i = 0; i < lastvt_T.size(); i++) {
            System.out.print(lastvt_T.get(i)+"  ");
        }
        System.out.println();
        if (grammer_T.contains("* F")){
            System.out.print("*  <  ");
        }
        for (int i = 0; i < first_vt_F.size(); i++) {
            System.out.print(first_vt_F.get(i)+" ");
        }

        System.out.println();
        if(grammer_T.contains("T /")){
            System.out.print("/  <  ");        }
        for (int i = 0; i < lastvt_T.size(); i++) {
            System.out.print(lastvt_T.get(i)+"  ");
        }
        System.out.println();
        if (grammer_T.contains("/ F")){
            System.out.print("/  <  ");
        }
        for (int i = 0; i < first_vt_F.size(); i++) {
            System.out.print(first_vt_F.get(i)+" ");
        }
        //F→(E)|id
        System.out.println();
        if(grammer_F.contains("( E")){
            System.out.print("(  <  ");        }
        for (int i = 0; i < first_vt_E.size(); i++) {
            System.out.print(first_vt_E.get(i)+"  ");
        }

        System.out.println();
        if(grammer_F.contains("E )")){
            System.out.print(")  <  ");        }
        for (int i = 0; i < lastvt_E.size(); i++) {
            System.out.print(lastvt_E.get(i)+"  ");
        }

        System.out.println();
        if(grammer_F.contains("( E )")){
            System.out.print("(  ==  )");
        }

        System.out.println();
        System.out.print("#  <  ");
        for (int i = 0; i < first_vt_E.size(); i++) {
            System.out.print(first_vt_E.get(i)+"  ");
        }
        System.out.println();
        System.out.print("#  <  ");
        for (int i = 0; i < lastvt_E.size(); i++) {
            System.out.print(lastvt_E.get(i)+"  ");
        }


    }

    private static void getlastvt(String str,ArrayList<String> list) {
        String[] strsplit=str.split(" ");
        ArrayList<String> lastvt_E_copy=new ArrayList<>();
        ArrayList<String> lastvt_T_copy=new ArrayList<>();
        ArrayList<String> lastvt_F_copy=new ArrayList<>();
        lastvt_E_copy.addAll(lastvt_E);
        lastvt_T_copy.addAll(lastvt_T);
        lastvt_F_copy.addAll(lastvt_F);

        if(strsplit[strsplit.length-1].equals("+")||
                strsplit[strsplit.length-1].equals("-")||
                strsplit[strsplit.length-1].equals("*")||
                strsplit[strsplit.length-1].equals("/")||
                strsplit[strsplit.length-1].equals("id")||
                strsplit[strsplit.length-1].equals("(")||
                strsplit[strsplit.length-1].equals(")")
        ){
            list.add(strsplit[strsplit.length-1]);
        }

        for (int i = strsplit.length-1; i >=0; i--) {

            if(strsplit[i].equals("|")){
                if(strsplit[i-1].equals("+")||
                        strsplit[i-1].equals("-")||
                        strsplit[i-1].equals("*")||
                        strsplit[i-1].equals("/")||
                        strsplit[i-1].equals("id")||
                        strsplit[i-1].equals("(")||
                        strsplit[i-1].equals(")")

                ){
                    list.add(strsplit[i-1]);
                }
                if(strsplit[i-1].equals("F")){
                    //加入F的lastvt集合
                    list.addAll(lastvt_F_copy);
                    if(strsplit[i-2].equals("+")||
                            strsplit[i-2].equals("-")||
                            strsplit[i-2].equals("*")||
                            strsplit[i-2].equals("/")||
                            strsplit[i-2].equals("id")||
                            strsplit[i-2].equals("(")||
                            strsplit[i-2].equals(")")

                    ){
                        list.add(strsplit[i-2]);
                    }
                }

                if(strsplit[i-1].equals("T")){
                    //加入T
                    list.addAll(lastvt_T_copy);
                    if(strsplit[i-2].equals("+")||
                            strsplit[i-2].equals("-")||
                            strsplit[i-2].equals("*")||
                            strsplit[i-2].equals("/")||
                            strsplit[i-2].equals("id")||
                            strsplit[i-2].equals("(")||
                            strsplit[i-2].equals(")")

                    ){
                        list.add(strsplit[i-2]);
                    }
                }

                if(strsplit[i-1].equals("E")){
                    //加入E的lastvt集合
                    list.addAll(lastvt_E_copy);
                    if(strsplit[i-2].equals("+")||
                            strsplit[i-2].equals("-")||
                            strsplit[i-2].equals("*")||
                            strsplit[i-2].equals("/")||
                            strsplit[i-2].equals("id")||
                            strsplit[i-2].equals("(")||
                            strsplit[i-2].equals(")")

                    ){
                        list.add(strsplit[i-2]);
                    }
                }
            }
        }

        int low=0;
        int high=list.size()-1;
        while(low<high){

            while(low<high){
                if(list.get(low).equals(list.get(high))){
                    list.remove(high);
                }
                high--;
            }
            high=list.size()-1;
            low++;
        }


    }

    private static void getfistvt(String str,ArrayList<String> list) {
        String[] strsplit=str.split(" ");
         ArrayList<String> first_vt_E_copy=new ArrayList<>();
         ArrayList<String> first_vt_T_copy=new ArrayList<>();
         ArrayList<String> first_vt_F_copy=new ArrayList<>();
        first_vt_E_copy.addAll(first_vt_E);
        first_vt_T_copy.addAll(first_vt_T);
        first_vt_F_copy.addAll(first_vt_F);
        for (int i = 0; i < strsplit.length; i++) {
            //如果为终结符时
            if(strsplit[i].equals("→")){
                if(strsplit[i+1].equals("+")||
                        strsplit[i+1].equals("-")||
                        strsplit[i+1].equals("*")||
                        strsplit[i+1].equals("/")||
                        strsplit[i+1].equals("id")||
                        strsplit[i+1].equals("(")||
                        strsplit[i+1].equals(")")

                ){
                    list.add(strsplit[i+1]);
                }
                if(strsplit[i+1].equals("E")){
                    //加入E的firstvt集合
                    list.addAll(first_vt_E_copy);
                    if(strsplit[i+2].equals("+")||
                            strsplit[i+2].equals("-")||
                            strsplit[i+2].equals("*")||
                            strsplit[i+2].equals("/")||
                            strsplit[i+2].equals("id")||
                            strsplit[i+2].equals("(")||
                            strsplit[i+2].equals(")")

                    ){
                        list.add(strsplit[2+i]);
                    }
                }
                if(strsplit[i+1].equals("T")){
                    //加入T的firstvt集合
                    list.addAll(first_vt_T_copy);
                    if(strsplit[i+2].equals("+")||
                            strsplit[i+2].equals("-")||
                            strsplit[i+2].equals("*")||
                            strsplit[i+2].equals("/")||
                            strsplit[i+2].equals("id")||
                            strsplit[i+2].equals("(")||
                            strsplit[i+2].equals(")")

                    ){
                        list.add(strsplit[i+2]);
                    }
                }
                if(strsplit[i+1].equals("F")){
                    //加入F的firstvt集合
                    list.addAll(first_vt_F_copy);
                    if(strsplit[i+2].equals("+")||
                            strsplit[i+2].equals("-")||
                            strsplit[i+2].equals("*")||
                            strsplit[i+2].equals("/")||
                            strsplit[i+2].equals("id")||
                            strsplit[i+2].equals("(")||
                            strsplit[i+2].equals(")")

                    ){
                        list.add(strsplit[i+2]);
                    }
                }

            }
            if(strsplit[i].equals("|")){
                if(strsplit[i+1].equals("+")||
                        strsplit[i+1].equals("-")||
                        strsplit[i+1].equals("*")||
                        strsplit[i+1].equals("/")||
                        strsplit[i+1].equals("id")||
                        strsplit[i+1].equals("(")||
                        strsplit[i+1].equals(")")

                ){
                    list.add(strsplit[i+1]);
                }
                if(strsplit[i+1].equals("E")){
                    //加入E的firstvt集合
                    list.addAll(first_vt_E_copy);
                    if(i+2< strsplit.length-1){
                        if(strsplit[i+2].equals("+")||
                                strsplit[i+2].equals("-")||
                                strsplit[i+2].equals("*")||
                                strsplit[i+2].equals("/")||
                                strsplit[i+2].equals("id")||
                                strsplit[i+2].equals("(")||
                                strsplit[i+2].equals(")")

                        ){
                            list.add(strsplit[i+2]);
                        }
                    }

                }
                if(strsplit[i+1].equals("T")){
                    //加入T的firstvt集合
                    list.addAll(first_vt_T_copy);
                    if(i+2< strsplit.length-1){
                        if(strsplit[i+2].equals("+")||
                                strsplit[i+2].equals("-")||
                                strsplit[i+2].equals("*")||
                                strsplit[i+2].equals("/")||
                                strsplit[i+2].equals("id")||
                                strsplit[i+2].equals("(")||
                                strsplit[i+2].equals(")")

                        ){
                            list.add(strsplit[i+2]);
                        }
                    }
                }
                if(strsplit[i+1].equals("F")){
                    //加入F的firstvt集合
                    list.addAll(first_vt_F_copy);
                    if(i+2< strsplit.length-1){
                        if(strsplit[i+2].equals("+")||
                                strsplit[i+2].equals("-")||
                                strsplit[i+2].equals("*")||
                                strsplit[i+2].equals("/")||
                                strsplit[i+2].equals("id")||
                                strsplit[i+2].equals("(")||
                                strsplit[i+2].equals(")")

                        ){
                            list.add(strsplit[i+2]);
                        }
                    }
                }
            }
        }
    }
}
