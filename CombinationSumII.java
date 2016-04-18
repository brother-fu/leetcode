public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       List<List<Integer>> ans = new ArrayList<List<Integer>>();
       List<Integer> list = new ArrayList<Integer>();
       Arrays.sort(candidates);
       helper(ans, list, candidates, 0, target);
       return ans;
    }
    private void helper(List<List<Integer>>ans, List<Integer> list, int[]candidates, int pos, int target) {
        if (target == 0) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            if (i > 0 && i != pos && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) return;
            list.add(candidates[i]);
            helper(ans, list, candidates, i + 1, target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}



