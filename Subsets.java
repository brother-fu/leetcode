public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        if (nums == null || nums.length == 0)
            return ans;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList();
        helper(ans, list, nums, 0);
        return ans;
    }
    private void helper(List<List<Integer>> ans, List<Integer> list, int[] nums, int pos) {
        ans.add(new ArrayList(list));
        if (pos >= nums.length) return;
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            helper(ans, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}