public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        if (nums == null || nums.length == 0)
            return ans;
        Arrays.sort(nums);
        boolean[] isVisited = new boolean[nums.length];
        List<Integer> list = new ArrayList();
        helper(ans, list, nums, isVisited);
        return ans;
    }
    private void helper(List<List<Integer>> ans, List<Integer> list, int[] nums, boolean[] isVisited) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i] || (i > 0 && nums[i] == nums[i - 1] && !isVisited[i - 1]))
                continue;
            isVisited[i] = true;
            list.add(nums[i]);
            helper(ans, list, nums, isVisited);
            isVisited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}