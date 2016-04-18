public class WordSearchII {
    private class Trie{
        private class TrieNode {
            int val; 
            TrieNode[] next;
            public TrieNode() {
                next = new TrieNode[26];
            }
        }
        private TrieNode root;
        public void put(String word) {
            root = put(root, word, 0);
        } 
        private TrieNode put(TrieNode x, String word, int pos) {
            if (x == null) x = new TrieNode();
            if (pos == word.length()) {
                x.val = 1; return x;
            }
            char c = word.charAt(pos);
            x.next[c - 'a'] = put(x.next[c - 'a'], word, pos + 1);
            return x;
        }
        public boolean startsWith(String word) {
            TrieNode x = find(root, word, 0);
            return x != null;
        }
        public boolean contains(String word) {
            TrieNode x = find(root, word, 0);
            return (x != null && x.val == 1);
        }
        private TrieNode find(TrieNode x, String word, int pos) {
            if (x == null) return x;
            if (pos == word.length()) return x;
            return find(x.next[word.charAt(pos) - 'a'], word, pos + 1);
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList();
        if (board == null || board.length == 0) 
            return ans;
        Trie trie = new Trie();
        for (String word : words) 
            trie.put(word);
        //dfs search
        //System.out.println("has a?" + trie.startsWith("a"));
        int row = board.length, col = board[0].length;
        boolean[][] isVisited = new boolean[row][col];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(ans, board, isVisited, i, j, trie, sb);
            }
        }
        return ans;
    }
    private void dfs(List<String> ans, char[][] board, 
                     boolean[][] isVisited, int x, int y,
                     Trie trie, StringBuilder sb) 
    {
        int row = board.length, col = board[0].length;
        if (x < 0 || x >= row || y < 0 || y >= col || isVisited[x][y])
            return;
        sb.append(board[x][y]);
        isVisited[x][y] = true;
        String tmp = sb.toString();
        if (!trie.startsWith(tmp)) {
           // System.out.println("here");
            sb.setLength(sb.length() - 1);
            isVisited[x][y] = false;
            return;
        }
        if (trie.contains(tmp) && !ans.contains(tmp)) ans.add(tmp);
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : dirs) {
            int xx = x + dir[0];
            int yy = y + dir[1];
            dfs(ans, board, isVisited, xx, yy, trie, sb); //重复；
        }
        isVisited[x][y] = false;
        sb.setLength(sb.length() - 1);
    }
}