/*
Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].

*/
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList();
        lower--; upper++;
        int pre = lower;
        for (int i = 0; i <= nums.length; i++) {
            int now = i == nums.length ? upper : nums[i];
            if (now - pre == 1);
            else if (now - pre == 2) {
                ans.add("" + (pre + 1));
            } else {
                ans.add("" + (pre + 1) + "->" + (now - 1));
            }
            pre = now;
        }
        return ans;
    }
}

/*超过50min, 已跪，重新看了之前的思路，不用two pointer*/
/*重看思路5min*/