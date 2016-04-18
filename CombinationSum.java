public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList();
        List<Integer> list = new ArrayList();
        Arrays.sort(nums);
        dfs(ans, list, nums, target, 0);
        return ans;
    }
    private void dfs(List<List<Integer>> ans, List<Integer> list,
                     int[] nums, int target, int pos)
    {
        if (target < 0) return;
        if (target == 0) {
            ans.add(new ArrayList(list));
        }
        for(int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            list.add(nums[i]);
            dfs(ans, list, nums, target - nums[i], i);
            list.remove(list.size() - 1);
        }
    }
}