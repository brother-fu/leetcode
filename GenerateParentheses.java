public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        StringBuilder sb = new StringBuilder();
        dfs(ans, sb, 0, 0, n);
        return ans;
    }
    private void dfs(List<String> ans, StringBuilder sb, 
                     int l, int r, int n) 
    {
        if (r > l || l > n || r > n)
            return;
        if (l == n && r == n) {
            ans.add(sb.toString());
            return;
        }
        int len = sb.length();
        dfs(ans, sb.append('('), l + 1, r, n);
        sb.setLength(len);
        dfs(ans, sb.append(')'), l, r + 1, n);
        sb.setLength(len);
    }
    
}