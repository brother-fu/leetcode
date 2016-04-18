public class WildcardMatching {
    public boolean isMatch1(String s, String p) {
        int i = 0, j = 0;
        int match = 0, lastStart = -1;
        int len1 = s.length(), len2 = p.length();
        while (i < len1) {
            char sc = s.charAt(i);
            if (j < len2 && equals(sc, p.charAt(j))) {
                i++; j++;
            } else if (j < len2 && p.charAt(j) == '*') {
                lastStart = ++j;
                match = i;
            } else {
                if (lastStart == -1)
                    return false;
                else {
                    i = ++match;
                    j = lastStart;
                }
            }
        }
        while (j < len2  && p.charAt(j) == '*')
            j++;
        return j == len2;
    }
    private boolean equals(char c1, char c2) {
        return c2 == '?' || c1 == c2;
    }
    
    public boolean isMatch(String s, String p) {
        /*50-01*/
        int len1 = s.length(), len2 = p.length();
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = dp[0][j - 1] && p.charAt(j - 1) == '*';
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                if (equals(sc, pc))
                    dp[i][j] = dp[i - 1][j - 1];
                if (pc == '*')
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j]; 
            }
        }
        return dp[len1][len2];
    }

}

/*25-37 greedy一次通过*/