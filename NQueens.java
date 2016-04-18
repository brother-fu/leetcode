public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>> ways = new ArrayList();
        List<Integer> list = new ArrayList();
        solve(ways, list, n);
        List<List<String>> ans = drawMap(ways, n);
        return ans;
    }
    private List<List<String>> drawMap(List<List<Integer>> ways, int n) {
        List<List<String>> ans = new ArrayList();
        for (List<Integer> way : ways) {
            List<String> list = new ArrayList();
            for (int i = 0; i < way.size(); i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == way.get(i))
                        sb.append('Q');
                    else
                        sb.append('.');
                }
                list.add(sb.toString());
            }
            ans.add(list);
        }
        return ans;
    }
    private void solve(List<List<Integer>> ways, List<Integer> list, int n) {
        if (list.size() == n) {
            ways.add(new ArrayList(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!list.contains(i) && isValid(list, i)) {
                list.add(i);
                solve(ways, list, n);
                list.remove(list.size() - 1);
            }
        }
    }
    private boolean isValid(List<Integer> list, int y) {
        int x = list.size();
        for (int i = 0; i < x; i++) {
            if (i + list.get(i) == x + y)
                return false;
        }
        for (int i = 0; i < x; i++) {
            if (i - list.get(i) == x - y)
                return false;
        }
        return true;
    }
}