

    static String[] simpleWords(String[] words) {
        int len = words.length;
        Set<String> dict = new HashSet();
        List<String> list = new ArrayList();
        int minLen = Integer.MAX_VALUE;
        for (String word : words) {
            dict.add(word);
            minLen = Math.min(minLen, word.length());
        }
        for (String word : words) {
            if (word.length() < 2 * minLen) {
                list.add(word);
            } else {
                dict.remove(word);
                if (!canBreak(word, dict)) {
                    dict.add(word);
                    list.add(word);
                }                 
            }
        }
        String[] rst = new String[list.size()];
        for (int i = 0; i < rst.length; i++)
            rst[i] = list.get(i);
        return rst;
    }
     
    private static boolean canBreak(String s, Set<String> dict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }  
            }
        }
        return dp[len];
    }

