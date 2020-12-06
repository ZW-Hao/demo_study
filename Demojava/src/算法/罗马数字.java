package 算法;

public class 罗马数字 {

    public static void main(String[] args) {
        String s="MMMCCIX";
        int result = romanToInt(s);
        System.out.println(result);

    }


    public  static int romanToInt(String s) {
        //字符串的处理
        String[] split = s.split("");
        //合并字符
        for (int i = split.length-1;i>=0 ; i--) {
            if(split[i].equals("I")){
                if(i+1< split.length){
                    if (split[i+1].equals("V")){
                        split[i]="IV";
                        split[i+1]="";
                    }
                    if (split[i+1].equals("X")){
                        split[i]="IX";
                        split[i+1]="";
                    }
                }

                if (i-1>=0){
                    if (split[i-1].equals("I")&&i-2>=0){
                        if(split[i-2].equals("I")){
                            split[i-2]="III";
                            split[i]="";
                            split[i-1]="";
                            continue;
                        }
                        split[i-1]="II";
                        split[i]="";
                    }
                }

            }
            if(split[i].equals("X")){
                if (i+1<split.length){
                    if (split[i+1].equals("L")){
                        split[i]="XL";
                        split[i+1]="";
                    }
                    if (split[i+1].equals("C")){
                        split[i]="XC";
                        split[i+1]="";
                    }
                }

                if (i-1>=0){
                    if (split[i-1].equals("X")&&i-2>=0){
                        if(split[i-2].equals("X")){
                            split[i-2]="XXX";
                            split[i]="";
                            split[i-1]="";
                            continue;
                        }
                        split[i-1]="XX";
                        split[i]="";
                    }
                }

            }
            if(split[i].equals("C")){
                if (i+1<split.length){
                    if (split[i+1].equals("D")){
                        split[i]="CD";
                        split[i+1]="";
                    }
                    if (split[i+1].equals("M")){
                        split[i]="CM";
                        split[i+1]="";
                    }
                }

                if (i-1>=0){
                    if (split[i-1].equals("C")&&i-2>=0){
                        if(split[i-2].equals("C")){
                            split[i-2]="CCC";
                            split[i]="";
                            split[i-1]="";
                            continue;
                        }
                        split[i-1]="CC";
                        split[i]="";
                    }
                }


            }

            if(split[i].equals("M")&&i-1>=0){
                if (split[i-1].equals("M")&&i-2>=0){
                    if(split[i-2].equals("M")){
                        split[i-2]="MMM";
                        split[i]="";
                        split[i-1]="";
                        continue;
                    }
                    split[i-1]="MM";
                    split[i]="";
                }
            }






        }


        int result=0;
        for (int i = 0; i < split.length; i++) {
            if(split[i].equals("I")){
                result=result+1;
                continue;
            }
            if(split[i].equals("II")){
                result=result+2;
                continue;
            }
            if(split[i].equals("III")){
                result=result+3;
                continue;
            }
            if(split[i].equals("X")){
                result=result+10;
                continue;
            }
            if(split[i].equals("XX")){
                result=result+20;
                continue;
            }
            if(split[i].equals("XXX")){
                result=result+30;
                continue;
            }
            if(split[i].equals("C")){
                result=result+100;
                continue;
            }
            if(split[i].equals("CC")){
                result=result+200;
                continue;
            }
            if(split[i].equals("CCC")){
                result=result+300;
                continue;
            }
            if(split[i].equals("M")){
                result=result+1000;
                continue;
            }
            if(split[i].equals("MM")){
                result=result+2000;
                continue;
            }
            if(split[i].equals("MMM")){
                result=result+3000;
                continue;
            }
            if(split[i].equals("IV")){
                result=result+4;
                continue;
            }
            if(split[i].equals("V")){
                result=result+5;
                continue;
            }
            if(split[i].equals("IX")){
                result=result+9;
                continue;
            }
            if(split[i].equals("XL")){
                result=result+40;
                continue;
            }
            if(split[i].equals("L")){
                result=result+50;
                continue;
            }
            if(split[i].equals("XC")){
                result=result+90;
                continue;
            }

            if(split[i].equals("CD")){
                result=result+400;
                continue;
            }
            if(split[i].equals("D")){
                result=result+500;
                continue;
            }
            if(split[i].equals("CM")){
                result=result+900;
                continue;
            }
        }


        return result;
    }
}
