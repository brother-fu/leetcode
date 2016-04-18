public class WordBreakII   {
    public List<String> wordBreak(String s, Set<String> wordDict) {
       List<String> ans = new ArrayList();
       StringBuilder sb = new StringBuilder();
       int len = s.length();
       boolean[] isPossible = new boolean[len + 1];
       isPossible[len] = true;
       for (int i = len - 1; i >= 0; i--) {
           for (int j = i + 1; j <= len; j++) {
               if (wordDict.contains(s.substring(i, j)) && isPossible[j]) {
                   isPossible[i] = true;
                   break;
               }
           }
       }
       dfs(ans, sb, s, 0, wordDict, isPossible);
       return ans;
    }
    
    private void dfs (List<String> ans, StringBuilder sb, String s, int pos, Set<String> wordDict, boolean[] isPossible) {
        if (pos == s.length()) {
            ans.add(sb.toString().trim());
            return;
        }
        int len = sb.length();
        for (int i = pos + 1; i <= s.length(); i++) {
            if (isPossible[i] && wordDict.contains(s.substring(pos, i))) {
                sb.append(s.substring(pos, i)).append(' ');
                dfs(ans, sb, s, i, wordDict, isPossible);
                sb.setLength(len);
            }
        }
    }
}