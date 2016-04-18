public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] table = new int[256];
        for (char c : t.toCharArray())
            table[c]++;
        int i = 0, j = 0;
        int start = -1, len = Integer.MAX_VALUE;
        int count = t.length();
        while (j < s.length()) {
            if (table[s.charAt(j++)]-- >0) count--;
            while (count == 0) {
                if (j - i < len) {
                    start = i;
                    len = j - i;
                }
                if (table[s.charAt(i++)]++ >= 0)
                    count++;
            }
        }
        if (start == -1) return "";
        return s.substring(start, start + len);
    }
}