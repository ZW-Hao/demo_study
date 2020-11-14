package 编译原理;

/*
    语法分析器的实现
    用一个链表模拟栈，另一个链表模拟队列
    栈中压入#和起始符，用来存储表达式
    队列中存储待分析的字符串
    存入预测分析表中的规则，用栈顶的非终结符与其进行匹配，如果此非终结符可以经过若干步推导出想要的终结符
    通过HASHMAP存储预测分析表

 */

import java.util.HashMap;

public class LL1 {
    //将预测分析表存入hashmap集合ForecastAnalysisTable
    static HashMap<String,String[]> FAT_E=new HashMap<>();
    static HashMap<String,String[]> FAT_E_1=new HashMap<>();
    static HashMap<String,String[]> FAT_T=new HashMap<>();
    static HashMap<String,String[]> FAT_T_1=new HashMap<>();
    static HashMap<String,String[]> FAT_F=new HashMap<>();


    public static void main(String[] args) {
     add_FAT();   //加入预测分析表

    }

    private static void add_FAT() {
        FAT_E.put("E",new String[]{"T","E1)"});

    }


}
