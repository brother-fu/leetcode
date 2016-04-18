public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        int[] dp = new int[len];
        int count = 0;
        for (int num : nums) {
            int find = Arrays.binarySearch(dp, 0, count,num); //带search range 的binary search;
            if (find < 0) {
                find = -find - 1;
                dp[find] = num; //只要小于0，就一定往里面插入，所有的数都是如此
                if (find == count) {
                    count++; //不是所有的数都有这个效果；
                }
            }
        }
        return count;
    }
}

/*35*/