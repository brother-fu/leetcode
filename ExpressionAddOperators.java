public class ExpressionAddOperators  {
    public List<String> addOperators(String s, int target) {
        List<String> ans = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= s.length(); i++) {
            String first = s.substring(0, i);
            long num = Long.parseLong(first);
            if (s.charAt(0) == '0' && i > 1)  /*这里也要对数进行限制*/
                break;
            sb.append(num);
            eval(ans, sb, s, num, num, i, target);
            sb.setLength(0);
        }
        return ans;
    }
    private void eval(List<String> ans, StringBuilder sb, String s,
                      long sum, long multiply, int pos, int target) 
    {
        if (pos == s.length()) {
            if (sum == (long)target) 
                ans.add(sb.toString());
            return;
        }
        int len = sb.length();
        for (int i = pos + 1; i <= s.length(); i++) {
            String next = s.substring(pos, i);
            if (s.charAt(pos) == '0' && i - pos > 1)
                break;
            long num2 = Long.parseLong(next);
            sb.append('+').append(num2);
            eval(ans, sb, s, sum + num2, num2, i, target);
            sb.setLength(len);
            sb.append('-').append(num2);
            eval(ans, sb, s, sum - num2, -num2, i, target);
            sb.setLength(len);
            sb.append('*').append(num2);
            eval(ans, sb, s, sum - multiply + multiply * num2, multiply * num2, i, target);
            sb.setLength(len);
        }
    }
}

/*复杂度分析 4^n*/