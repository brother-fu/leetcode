public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int head = 0, end = 0, repeat = 0;
        int[] sTable = new int[256];
        int max = 0;
        char[] bits = s.toCharArray();
        while(end < s.length()) {
            if (sTable[bits[end++]]++ > 0) repeat++;
            while(repeat > 0) {
                if (sTable[bits[head++]]-- > 1) repeat--;
            }
            max = Math.max(max, end - head);
        }
        return max;
    }
}

//你贡献的代码，嘻嘻