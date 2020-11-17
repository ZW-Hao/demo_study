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
    private static biaodashi[] biaodashis = new biaodashi[20];
    //符号编码
    private static HashMap<Integer, String> map_one;
    private static HashMap<String, Integer> map_two;

    public static void main(String[] args) {
        int stackTop = 1;
        int readlistTop = 0;
        int index = 0; // 当前步骤数
        initMap(); // 初始化种别码Map
        initbiaodashis(); // 产生式初始化
        stack.add(0, String.valueOf(map_two.get("#"))); // 在stack底部加上#
        stack.add(stackTop, "S'"); // 将S'压入栈
        System.out.print("请输入词法分析结果的文件路径：");
        Scanner scanner = new Scanner(System.in);
        String filepath = scanner.next();

        try {
            readToreadlist(filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        readlist.add(map_two.get("#"));
        while (stackTop >= 0) {
            System.out.printf("栈：");

            StringBuffer sb = new StringBuffer();
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
                stackTop += stackPush(stackTop, biaodashis[i]); // 压栈
                System.out.printf("        下一步所用产生式：" + biaodashis[i].prod);
                System.out.println();

            }
        }
        if (stackTop == -1) {
            System.out.println("语法分析成功");

        }

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

    private static void initbiaodashis() {

        biaodashis[1] = new biaodashi("S",
                new String[]{String.valueOf(map_two.get("id")), "B"},
                "S --> id B");
        biaodashis[2] = new biaodashi("S'",
                new String[]{"S", "S'"},
                "S' --> SS'");
        biaodashis[3] = new biaodashi("B",
                new String[]{String.valueOf(map_two.get("=")), "E", String.valueOf(map_two.get(";"))},
                "B --> =E;");
        biaodashis[4] = new biaodashi("E",
                new String[]{"T", "E'"},
                "E --> TE'");
        biaodashis[5] = new biaodashi("T",
                new String[]{"F", "T'"},
                "T --> FT'");
        biaodashis[6] = new biaodashi("S'",
                new String[]{"ε"},
                "S' --> ε");
        biaodashis[7] = new biaodashi("F",
                new String[]{String.valueOf(map_two.get("(")), "E", String.valueOf(map_two.get(")"))},
                "F --> (E)");
        biaodashis[8] = new biaodashi("F",
                new String[]{String.valueOf(map_two.get("id"))},
                "F --> id");
        biaodashis[9] = new biaodashi("T'",
                new String[]{"ε"},
                "T' --> ε");
        biaodashis[10] = new biaodashi("E'",
                new String[]{"M", "E'"},
                "E' --> ME'");
        biaodashis[11] = new biaodashi("M",
                new String[]{String.valueOf(map_two.get("+")), "T"},
                "M --> +T");
        biaodashis[12] = new biaodashi("E'",
                new String[]{"ε"},
                "E' --> ε");
        biaodashis[13] = new biaodashi("T'",
                new String[]{"N", "T'"},
                "T' --> NT'");
        biaodashis[14] = new biaodashi("N",
                new String[]{String.valueOf(map_two.get("*")), "F"},
                "N --> *F");
        biaodashis[15] = new biaodashi("F",
                new String[]{String.valueOf(map_two.get("num"))},
                "F --> num");
    }


    private static int stackPush(int stackTop, biaodashi biaodashi) {
        int len = biaodashi.r_str.length;
        stack.remove(stackTop);
        if ("ε".equals(biaodashi.r_str[0])) {
        } else {
            for (int i = len - 1; i >= 0; i--) {
                stack.add(biaodashi.r_str[i]);
            }
            return len - 1;
        }
        return -1;
    }
    /**
     * 产生式类
     */
    private static class biaodashi {
        String l_str;
        String[] r_str;
        String prod;
        public biaodashi(String l_str, String[] r_str, String prod) {
            this.l_str = l_str;
            this.r_str = r_str;
            this.prod = prod;
        }
    }
}
