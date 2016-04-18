public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int row = board.length, col = board[0].length;
        HashSet<String> seen = new HashSet<String>();
        List<int[]> dotPos = new ArrayList();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] != '.') {
                    String b = "(" + board[i][j] + ")";
                    seen.add(i + b);
                    seen.add(b + j);
                    seen.add(i / 3 + b + j / 3);
                } else {
                    dotPos.add(new int[] {i, j});
                }
            }
        }
        dfs(board, seen, row, col, dotPos, 0);
    }
    private boolean dfs (char[][] board, HashSet<String> seen, int row, int col, List<int[]> dotPos, int pos) {
        if (pos >= dotPos.size()) return true;
        int[] cord = dotPos.get(pos);
        int i = cord[0], j = cord[1];
        for (char c = '1'; c <= '9'; c++) {
            String b = "(" + c + ")";
            if (!seen.contains(i + b) && !seen.contains(b + j) && !seen.contains(i / 3 + b + j / 3)) {
                board[i][j] = c;
                seen.add(i + b); seen.add(b + j); seen.add(i / 3 + b + j / 3);
                if (!dfs(board, seen, row, col, dotPos, pos + 1)) {
                    board[i][j] = '.';
                    seen.remove(i + b); seen.remove(b + j); seen.remove(i / 3 + b + j / 3);
                }
            }
        }
        if (board[i][j] == '.') return false;
        return true;
    }
}