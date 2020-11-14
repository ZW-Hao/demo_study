package 人工智能;

import java.util.Scanner;
import java.util.function.ToDoubleBiFunction;

/*
    给出一个谓词公式求子句集
    原子公式
    否定、合取、析取、蕴含、等价
    全称量词、存在量词




 */
public class seekingClause {

    public static void main(String[] args) {
        //String weicigongshi=inputweici();
        //System.out.println(weicigongshi);
        //String str="A > B";
        String str=if_yunhan("A->B");


    }


    // TODO: 2020/11/11 消去等价符号，使用较少，先不考虑
    private static String if_dengjia(String str) {

        return null;
    }


    /**
     * 缩小否定辖域
     *
     * @param text
     * @return
     */
    private static String shrinkNotSign(String text) {
        String res = text;
        boolean isFistAddErrorChar = true;
        // 否定内移
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            res = res.replace("~($" + c + ")", "(@" + c + ")~");
            res = res.replace("~(@" + c + ")", "($" + c + ")~");

        }
        // TODO: 2020/11/11  对于外层否定的处理



        return null;
    }
    // TODO: 2020/11/11 消去蕴含符号
    /**
     *
     * 谓词逻辑消除蕴含
     *
     * @param Text
     *
     * @return
     */
    public static String if_yunhan(String Text) {
        String[] splitText = Text.split("→");
        boolean isFistAddErrorChar = true;
        int flag = 1;// 标志,当前是第几个text
        String res = "";
        for (String text : splitText) {
            // 将字符串逆序
            text = new StringBuffer(text).reverse().toString();

            int count = 0;// 标志
            String tempStr = "";
            for (char c : text.toCharArray()) {

                if (c == '}' || c == ']') {
                    count++;
                } else if (c == '{' || c == '[') {
                    count--;
                }

                if (count < 0 && isFistAddErrorChar) {

                    tempStr = c + "~" + tempStr;
                    count++;
                    isFistAddErrorChar = false;
                } else {

                    tempStr = c + tempStr;

                }

            }
            if (flag == 1 && isFistAddErrorChar) {
                if (tempStr.charAt(0) == '[' || tempStr.charAt(0) == '(' || tempStr.charAt(0) == '{') {
                    res = "~" + tempStr + "v";
                } else {
                    res = "~" + "(" + tempStr + ")" + "v";
                }

            } else if (flag != splitText.length) {
                res = res + tempStr + "v";
            } else {
                res = res + tempStr;
            }

            flag++;
        }

        System.out.println(res);
        return res;

    }



}
