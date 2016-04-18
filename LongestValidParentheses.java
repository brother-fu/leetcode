public class LongestValidParentheses {
    //用stack的方式解决；
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int lastStart = 0;
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') stack.push(i);
            if (c == ')') {
                if (stack.empty())
                    lastStart = i + 1;
                else {
                    stack.pop();
                    if (stack.empty())
                        max = Math.max(max, i - lastStart + 1);
                    else 
                       max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}

/*用dp的方式解决*/
public class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        int len = s.length();
        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            char c = s.charAt(i - 1);
            if (c == '(') dp[i] = 0;
            else {
                int t = i - dp[i - 1] - 2;
                if (t >= 0 && s.charAt(t) == '(') {
                    dp[i] = dp[i - 1] + 2 + dp[t];
                    max = Math.max(max, dp[i]);
                } else {
                    dp[i] = 0;
                }
            }
        }
        return max;
    }
}
/*这种跨越型，往前找任意位置子问题的dp，第一次接触！*/