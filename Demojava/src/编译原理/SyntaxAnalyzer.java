package 编译原理;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 语法分析器
 */
public class SyntaxAnalyzer {
    // 创建栈和队列
    private static ArrayList<String> stack = new ArrayList<>(); 
    private static ArrayList<Integer> readlist = new ArrayList<>(); 
    
    
    
    private static Production[] productions = new Production[20]; 
    

    //符号编码
    private static HashMap<Integer, String> map_one;
    private static HashMap<String, Integer> map_two;

    public static void main(String[] args) {
        int stackTop = 1;
        int readlistTop = 0;
        int index = 0; // 当前步骤数
        initMap(); // 初始化种别码Map
        initProductions(); // 产生式初始化
        stack.add(0, String.valueOf(map_two.get("#"))); // 在stack底部加上#
        stack.add(stackTop, "S'"); // 将S'压入栈
        System.out.print("请输入词法分析结果的文件路径：");
        Scanner scanner = new Scanner(System.in);
        String filepath = scanner.next();

        // 通过词法分析器的输出结果，初始化readlist
        try {
            readToreadlist(filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        readlist.add(map_two.get("#")); // 在readlist末尾加上#
        while (stackTop >= 0) {
            System.out.printf("栈：");

            StringBuffer sb = new StringBuffer(); // 引入StringBuffer仅为控制在控制台的输出格式对齐
            for (int i = 0; i <= stackTop; i++) {
                String str = null;
                try {
                    str = map_one.get(Integer.valueOf(stack.get(i)));
                    if (str != null) {
                        sb.append(str + " ");

                    }
                } catch (NumberFormatException e) {
                    sb.append(stack.get(i) + " ");

                }
            }
            System.out.printf( sb.toString());
            System.out.print("        待读队列：");

            sb = new StringBuffer();
            for (int i = 0; i < readlist.size(); i++) {
                sb.append(map_one.get(readlist.get(i)) + " ");

            }
            System.out.printf(sb.toString());

            if (match(stackTop, readlistTop)) {
                stackTop--;
                System.out.print("\n");

            } else {
                int i = ll1_table(stackTop, readlistTop);
                stackTop += stackPush(stackTop, productions[i]); // 压栈
                System.out.printf("        下一步所用产生式：" + productions[i].prod);
                System.out.println();

            }
        }
        if (stackTop == -1) {
            System.out.println("语法分析成功");

        }

    }

    public static void readToreadlist(String filePath) throws IOException {
        InputStream is = new FileInputStream(filePath);
        String line; // 用来保存每行读取的内容
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        line = br.readLine(); // 读取第一行
        while (line != null) { // 如果 line 为空说明读完了
            int pos = line.indexOf(",");
            readlist.add(Integer.valueOf(line.substring(0, pos)));
            line = br.readLine(); // 读取下一行
        }
        br.close();
        is.close();
    }

    private static int stackPush(int stackTop, Production production) {
        int len = production.r_str.length;
        stack.remove(stackTop);
        if ("ε".equals(production.r_str[0])) {
        } else {
            for (int i = len - 1; i >= 0; i--) {
                stack.add(production.r_str[i]);
            }
            return len - 1;
        }
        return -1;
    }

    // 利用LL(1)预测分析表进行分析
    private static int ll1_table(int stackTop, int readlistTop) {
        if ("S".equals(stack.get(stackTop))) {
            if ("id".equals(map_one.get(readlist.get(readlistTop)))) {
                return 1;

            } else if ("#".equals(map_one.get(readlist.get(readlistTop)))) {
                return 4;
            } else {
                return -1;
            }
        } else if ("B".equals(stack.get(stackTop))) {
            if ("=".equals(map_one.get(readlist.get(readlistTop)))) {
                return 3;
            } else {
                return -1;
            }
        } else if ("L".equals(stack.get(stackTop))) {
            if ("id".equals(map_one.get(readlist.get(readlistTop)))) {
                return 7;
            } else {
                return -1;
            }
        } else if ("L'".equals(stack.get(stackTop))) {
            if ("#".equals(map_one.get(readlist.get(readlistTop)))) {
                return 9;
            } else {
                return -1;
            }
        } else if ("E".equals(stack.get(stackTop))) {
            if ("id".equals(map_one.get(readlist.get(readlistTop)))) {
                return 4;
            } else if ("num".equals(map_one.get(readlist.get(readlistTop)))) {
                return 4;
            } else if ("(".equals(map_one.get(readlist.get(readlistTop)))) {
                return 4;
            } else if ("+".equals(map_one.get(readlist.get(readlistTop)))) {
                return 13;
            } else if ("-".equals(map_one.get(readlist.get(readlistTop)))) {
                return 14;
            } else {
                return -1;
            }
        } else if ("E'".equals(stack.get(stackTop))) {
            if ("+".equals(map_one.get(readlist.get(readlistTop)))) {
                return 10;
            } else if (";".equals(map_one.get(readlist.get(readlistTop)))) {
                return 12;
            } else if (")".equals(map_one.get(readlist.get(readlistTop)))) {
                return 12;
            } else {
                return -1;
            }
        } else if ("M".equals(stack.get(stackTop))) {
            if ("+".equals(map_one.get(readlist.get(readlistTop)))) {
                return 11;
            } else if ("-".equals(map_one.get(readlist.get(readlistTop)))) {
                return 19;
            } else {
                return -1;
            }
        } else if ("T".equals(stack.get(stackTop))) {
            if ("id".equals(map_one.get(readlist.get(readlistTop)))) {
                return 5;
            } else if ("num".equals(map_one.get(readlist.get(readlistTop)))) {
                return 5;
            } else if ("(".equals(map_one.get(readlist.get(readlistTop)))) {
                return 5;
            }
        } else if ("T'".equals(stack.get(stackTop))) {
            if ("+".equals(map_one.get(readlist.get(readlistTop)))) {
                return 9;
            } else if ("*".equals(map_one.get(readlist.get(readlistTop)))) {
                return 13;
            } else if (";".equals(map_one.get(readlist.get(readlistTop)))) {
                return 9;
            } else if (")".equals(map_one.get(readlist.get(readlistTop)))) {
                return 9;
            } else {
                return -1;
            }
        } else if ("N".equals(stack.get(stackTop))) {
            if ("*".equals(map_one.get(readlist.get(readlistTop)))) {
                return 14;
            } else {
                return -1;
            }
        } else if ("F".equals(stack.get(stackTop))) {
            if ("id".equals(map_one.get(readlist.get(readlistTop)))) {
                return 8;
            } else if ("num".equals(map_one.get(readlist.get(readlistTop)))) {
                return 15;
            } else if ("(".equals(map_one.get(readlist.get(readlistTop)))) {
                return 7;
            } else {
                return -1;
            }
        } else if ("S'".equals(stack.get(stackTop))) {
            if ("id".equals(map_one.get(readlist.get(readlistTop)))) {
                return 2;
            } else if ("#".equals(map_one.get(readlist.get(readlistTop)))) {
                return 6;
            } else {
                return -1;
            }
        } else {
            System.out.println("语法错误");
        }
        return -1;
    }

    private static boolean match(int stackTop, int readlistTop) {
        try {
            int stackTopVal = Integer.valueOf(stack.get(stackTop)); // 未抛出异常说明是终结符
            if (stackTopVal == readlist.get(0)) {
                stack.remove(stackTop);
                readlist.remove(readlistTop);
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            // 抛出异常说明是非终结符
            return false;
        }
    }

    private static void initProductions() {

        productions[1] = new Production("S",
                new String[]{String.valueOf(map_two.get("id")), "B"},
                "S --> id B");
        productions[2] = new Production("S'",
                new String[]{"S", "S'"},
                "S' --> SS'");
        productions[3] = new Production("B",
                new String[]{String.valueOf(map_two.get("=")), "E", String.valueOf(map_two.get(";"))},
                "B --> =E;");
        productions[4] = new Production("E",
                new String[]{"T", "E'"},
                "E --> TE'");
        productions[5] = new Production("T",
                new String[]{"F", "T'"},
                "T --> FT'");
        productions[6] = new Production("S'",
                new String[]{"ε"},
                "S' --> ε");
        productions[7] = new Production("F",
                new String[]{String.valueOf(map_two.get("(")), "E", String.valueOf(map_two.get(")"))},
                "F --> (E)");
        productions[8] = new Production("F",
                new String[]{String.valueOf(map_two.get("id"))},
                "F --> id");
        productions[9] = new Production("T'",
                new String[]{"ε"},
                "T' --> ε");
        productions[10] = new Production("E'",
                new String[]{"M", "E'"},
                "E' --> ME'");
        productions[11] = new Production("M",
                new String[]{String.valueOf(map_two.get("+")), "T"},
                "M --> +T");
        productions[12] = new Production("E'",
                new String[]{"ε"},
                "E' --> ε");
        productions[13] = new Production("T'",
                new String[]{"N", "T'"},
                "T' --> NT'");
        productions[14] = new Production("N",
                new String[]{String.valueOf(map_two.get("*")), "F"},
                "N --> *F");
        productions[15] = new Production("F",
                new String[]{String.valueOf(map_two.get("num"))},
                "F --> num");
    }

    private static void initMap() {
        map_two = new HashMap<>();

        map_two.put("id", 1);
        map_two.put("num", 2);
        map_two.put("=", 3);
        map_two.put("+", 4);
        map_two.put("*", 5);
        map_two.put("(", 6);
        map_two.put(")", 7);
        map_two.put(";", 8);
        map_two.put("#", 9);

        map_one = new HashMap<>();
        map_one.put(1, "id");
        map_one.put(2, "num");
        map_one.put(3, "=");
        map_one.put(4, "+");
        map_one.put(5, "*");
        map_one.put(6, "(");
        map_one.put(7, ")");
        map_one.put(8, ";");
        map_one.put(9, "#");
    }

    /**
     * 产生式类
     */
    private static class Production {
        String l_str;
        String[] r_str;
        String prod;
        public Production(String l_str, String[] r_str, String prod) {
            this.l_str = l_str;
            this.r_str = r_str;
            this.prod = prod;
        }
    }
}
