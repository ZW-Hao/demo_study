package 算法;

public class 有效的数独 {
    public static void main(String[] args) {
        char[][] board={
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','3','.','.','7','9'}

        };
        boolean b=isValidSudoku(board);
        System.out.println(b);
    }
    public static boolean isValidSudoku(char[][] board) {
    //横向比较
        for (int k = 0; k < 9; k++) {
            char[] flag=new char[9];
            int number=0;
            for (int i = 0; i < 9; i++) {
                if(board[k][i]!= '.'){
                    flag[number]=board[k][i];
                    number++;
                }
            }
            //直接判断flag数组中是否有重复的数
            int low=0;
            int high=number-1;
            while(low<high){
                while(low<high){
                    if(flag[low]==flag[high]){
                        return false;
                    }
                    high--;
                }
                high=number-1;
                low++;
            }

        }
        //竖向比较

        for (int k = 0; k < 9; k++) {
            char[] flag=new char[9];
            int number=0;
            for (int i = 0; i < 9; i++) {
                if(board[i][k]!= '.'){
                    flag[number]=board[i][k];
                    number++;
                }
            }
            //直接判断flag数组中是否有重复的数
            int low=0;
            int high=number-1;
            while(low<high){
                while(low<high){
                    if(flag[low]==flag[high]){
                        return false;
                    }
                    high--;
                }
                high=number-1;
                low++;
            }

        }

        //方格中比较
        char[] flag=new char[9];
        int number=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j]!= '.'){
                    flag[number]=board[i][j];
                    number++;
                }
            }
        }
        int low=0;
        int high=number-1;
        while(low<high){
            while(low<high){
                if(flag[low]==flag[high]){
                    return false;
                }
                high--;
            }
            high=number-1;
            low++;
        }

         flag=new char[9];
         number=0;
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j]!= '.'){
                    flag[number]=board[i][j];
                    number++;
                }
            }
        }
         low=0;
         high=number-1;
        while(low<high){
            while(low<high){
                if(flag[low]==flag[high]){
                    return false;
                }
                high--;
            }
            high=number-1;
            low++;
        }

        flag=new char[9];
        number=0;
        for (int i = 6; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j]!= '.'){
                    flag[number]=board[i][j];
                    number++;
                }
            }
        }
        low=0;
        high=number-1;
        while(low<high){
            while(low<high){
                if(flag[low]==flag[high]){
                    return false;
                }
                high--;
            }
            high=number-1;
            low++;
        }

        flag=new char[9];
        number=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 6; j++) {
                if(board[i][j]!= '.'){
                    flag[number]=board[i][j];
                    number++;
                }
            }
        }
        low=0;
        high=number-1;
        while(low<high){
            while(low<high){
                if(flag[low]==flag[high]){
                    return false;
                }
                high--;
            }
            high=number-1;
            low++;
        }

        flag=new char[9];
        number=0;
        for (int i = 3; i < 6; i++) {
            for (int j = 3; j < 6; j++) {
                if(board[i][j]!= '.'){
                    flag[number]=board[i][j];
                    number++;
                }
            }
        }
        low=0;
        high=number-1;
        while(low<high){
            while(low<high){
                if(flag[low]==flag[high]){
                    return false;
                }
                high--;
            }
            high=number-1;
            low++;
        }

        flag=new char[9];
        number=0;
        for (int i = 6; i < 9; i++) {
            for (int j = 3; j < 6; j++) {
                if(board[i][j]!= '.'){
                    flag[number]=board[i][j];
                    number++;
                }
            }
        }
        low=0;
        high=number-1;
        while(low<high){
            while(low<high){
                if(flag[low]==flag[high]){
                    return false;
                }
                high--;
            }
            high=number-1;
            low++;
        }

        flag=new char[9];
        number=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 6; j < 9; j++) {
                if(board[i][j]!= '.'){
                    flag[number]=board[i][j];
                    number++;
                }
            }
        }
        low=0;
        high=number-1;
        while(low<high){
            while(low<high){
                if(flag[low]==flag[high]){
                    return false;
                }
                high--;
            }
            high=number-1;
            low++;
        }

        flag=new char[9];
        number=0;
        for (int i = 3; i < 6; i++) {
            for (int j = 6; j < 9; j++) {
                if(board[i][j]!= '.'){
                    flag[number]=board[i][j];
                    number++;
                }
            }
        }
        low=0;
        high=number-1;
        while(low<high){
            while(low<high){
                if(flag[low]==flag[high]){
                    return false;
                }
                high--;
            }
            high=number-1;
            low++;
        }

        flag=new char[9];
        number=0;
        for (int i = 6; i < 9; i++) {
            for (int j = 6; j < 9; j++) {
                if(board[i][j]!= '.'){
                    flag[number]=board[i][j];
                    number++;
                }
            }
        }
        low=0;
        high=number-1;
        while(low<high){
            while(low<high){
                if(flag[low]==flag[high]){
                    return false;
                }
                high--;
            }
            high=number-1;
            low++;
        }



        return true;
    }
}
