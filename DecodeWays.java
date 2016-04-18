public class DecodeWays {
    public int numDecodings(String s) {
       if (s == null || s.length() == 0 ||s.charAt(0) == '0')  return 0;
       int len = s.length();
       int[] dp = new int[len + 1];
       dp[0] = 1; dp[1] = 1;  //根据通项公式翻过来推导需要初始化的信息
       for (int i = 2; i <= len; i++) {
           char c = s.charAt(i - 1);
           char pc = s.charAt(i - 2);
           if (c == '0') {
               if (pc == '1' || pc == '2')
                   dp[i] = dp[i - 2];
               else return 0;
           }
           else if ((c >= '7' && c <= '9'&& pc == '1') || (c >= '1' && c <= '6' && (pc == '1' || pc == '2')))
               dp[i] = dp[i - 1] + dp[i - 2];
           else dp[i] = dp[i - 1];
       }
       return dp[len];
    }
}

/*稍微记下答案， 0的时候反制，其它的时候确定什么时候能够double, 不然的话至少能够和dp[i - 1]相同*/
/*  按 curC 分
     ＝0; 反制
     1-6,  7-9时， pc什么情况下会double
     else  dp[i] = dp[i - 1];
*/