public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        int lens = s.length(), lenp = p.length();
        if (lenp== 0) return lens == 0;
        boolean[][] isMatch = new boolean[lens + 1][lenp + 1];
        isMatch[0][0] = true;
        for (int j = 2; j <= lenp; j++)
            isMatch[0][j] = isMatch[0][j - 2] && p.charAt(j - 1) == '*';
        for (int i = 1; i <= lens; i++) {
            for (int j = 1; j <= lenp; j++) {
                char sc = s.charAt(i - 1); 
                char pc = p.charAt(j - 1);
                if (isEqual(sc, pc)) {
                    isMatch[i][j] = isMatch[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    isMatch[i][j] = isMatch[i][j - 2] || (isMatch[i - 1][j] && isEqual(sc, p.charAt(j - 2)));
                } 
            }
        }
        return isMatch[lens][lenp];
    }
    private boolean isEqual(char sc, char pc) {
        if (pc == '.') return true;
        return sc == pc;
    }
}