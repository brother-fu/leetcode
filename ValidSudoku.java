public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return false;
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!isValid(board, i, j))
                       return false;
                }
            }
        }
        return true;
    }
    private boolean isValid (char[][] board, int row, int col) {
        //check row
        for (int i = 0; i < 9; i++) {
            if (i != row && board[i][col] == board[row][col])
               return false;
        }
        //check col 
        for (int j = 0; j < 9; j++) {
            if (j != col && board[row][j] == board[row][col])
               return false;
        }
        //check box
        int k = row / 3, t = col / 3;
        for (int i = row / 3 * 3; i < row / 3 * 3 + 3; i++) {
            for (int j = col / 3 * 3; j < col / 3 * 3 + 3; j++) {
                if (board[i][j] == board[row][col] && (i != row || j != col))
                   return false;
            }
        }
        return true;
    }
}

//https://leetcode.com/discuss/64668/short-simple-java-using-strings 牛逼哄哄的匠人！！