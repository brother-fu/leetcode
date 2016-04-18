public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new ArrayList();
        if (n <= 2)
            return ans;
        List<Integer> factors = getFactor(n);
        List<Integer> list = new ArrayList();
        dfs(ans, factors, list, n, 0);
        return ans;
    }
    private void dfs(List<List<Integer>> ans, List<Integer> factors, 
                     List<Integer> list, int left, int pos) 
    {
        if (left == 0)
            return;
        if (left == 1) {
            ans.add(new ArrayList(list));
            return;
        }
        for (int i = pos; i < factors.size(); i++) {
            if (left % factors.get(i) == 0) {
                list.add(factors.get(i));
                dfs(ans, factors, list, left / factors.get(i), i);
                list.remove(list.size() - 1);
            }
        }
    }
    private List<Integer> getFactor(int n) {
        List<Integer> list = new ArrayList();
        for (int i = 2; i <= (int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                list.add(i);
                if (i != n / i)
                    list.add(n / i); //这里有点问题；
            }
        }
        Collections.sort(list);
        return list;
    }
}