public class 3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        if (nums == null || nums.length == 0)
            return ans;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int tmp = nums[i] + nums[j] + nums[k];
                if (tmp < 0) j++;
                if (tmp > 0) k--;
                if (tmp == 0) {
                    List<Integer> part = new ArrayList();
                    part.add(nums[i]);
                    part.add(nums[j]);
                    part.add(nums[k]);
                    ans.add(part);
                    j++; 
                    while(j < nums.length && nums[j] == nums[j - 1])
                        j++;
                    k--;
                }
            }
            i++;
            while(i < nums.length && nums[i] == nums[i - 1])
                i++;
        }
        return ans;
    }
}