public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int begin = 0;
        if (s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        if (len == 1) return s;
        boolean[][] isPalindrome = new boolean[len][len];
        int max = 0;
        for (int i = 0; i < len; i++)
           isPalindrome[i][i] = true;
        for (int i = 0; i < len - 1; i++) {
           isPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
           if(isPalindrome[i][i + 1]) {
               max = 2;
               begin = i;
           }
        }
        int size = 3;
        for (size = 3; size <= len; size++) {
            for (int i = 0; i <= len - size; i++) {
               isPalindrome[i][i + size - 1] = isPalindrome[i + 1][i + size - 2] && s.charAt(i) == s.charAt(i + size - 1);
               if (isPalindrome[i][i + size - 1]) {
                   begin = i;
                   max = size;
               }
                
            }
        }
        return s.substring(begin, begin + max);
    }
}