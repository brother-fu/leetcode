

    static String[] simpleWordsII(String[] words) {
        int len = words.length;
        //Set<String> dict = new HashSet();
        Map<String, Boolean> dict = new HashMap();
        int count = 0;
        //List<String> list = new ArrayList();
        int minLen = Integer.MAX_VALUE;
        for (String word : words) {
            //dict.add(word);
            dict.put(word, true);
            minLen = Math.min(minLen, word.length());
        }
        for (String word : words) {
            if (word.length() < 2 * minLen) {
                //list.add(word);
                count++;
            } else {
                //dict.remove(word);
                dict.put(word, false);
                if (!canBreak(word, dict)) {
                    dict.put(word, true);
                    count++;
                    //dict.add(word);
                    
                    //list.add(word);
                }                 
            }
        }
        String[] rst = new String[count];
        //for (int i = 0; i < rst.length; i++)
            //rst[i] = list.get(i);
        int j = 0;
        for (String word : words) {
            if (dict.get(word))
                rst[j++] = word;
        }
        return rst;
    }
     
    //private static boolean canBreak(String s, Set<String> dict) {
    private static boolean canBreak(String s, Map<String, Boolean> dict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                //if (dp[j] && dict.contains(s.substring(j, i))) {
                String tmp = s.substring(j ,i);
                if (dp[j] && dict.containsKey(tmp) && dict.get(tmp)) {
                    dp[i] = true;
                    break;
                }  
            }
        }
        return dp[len];
    }

