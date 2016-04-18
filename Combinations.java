public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList();
        List<Integer> list = new ArrayList();
        dfs(ans, list, n, k, 1);
        return ans;
    }
    private void dfs(List<List<Integer>> ans, List<Integer> list, 
                     int n, int k, int pos)
    {
        if (list.size() == k) {
            ans.add(new ArrayList(list));
            return;
        }
        for (int i = pos; i <= n; i++) {
            list.add(i);
            dfs(ans, list, n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
}