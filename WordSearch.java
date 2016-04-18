public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0)  
            return false;
        int row = board.length, col = board[0].length;
        boolean[][] isVisited = new boolean[row][col];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, isVisited, sb, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, boolean[][] isVisited,
                        StringBuilder sb, int x, int y, 
                        String word, int pos)
    {
        int row = board.length, col = board[0].length;
        if (pos == word.length()) return true;
        if (x < 0 || x >= row || y < 0 || y >= col || isVisited[x][y])
            return false;
        int[][] dirs = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        if (board[x][y] == word.charAt(pos)) {
            char c = board[x][y];
            sb.append(c);
            isVisited[x][y] = true;
            for (int[] dir : dirs) {
                int xx = x + dir[0], yy = y + dir[1];
                if (dfs(board, isVisited, sb, xx, yy, word, pos + 1))
                    return true;
            }
            sb.setLength(sb.length() - 1);
            isVisited[x][y] = false;
        }
        return false;
    }
}