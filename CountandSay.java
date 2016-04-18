public class CountandSay {
    public String countAndSay(int n) {
       return helper("1", n - 1);
    }
    private String helper(String s, int count) {
        if (count == 0) return s;
        int i = 0, j = 0;
        char[] bits = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        while (j < bits.length) {
            while(bits[j] == bits[i]) {
                j++;
                if (j == bits.length) break;
            }
            sb.append(j - i).append(bits[i]);
            i = j;
        }
        return helper(sb.toString(), --count);
    }
}