public class BurstBalloons {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        int[] pad = new int [len + 2];
        for (int i = 0; i <= len + 1; i++) {
            if (i == 0 || i == len + 1)
                pad[i] = 1;
            else pad[i] = nums[i - 1];
        }
        
        int[][] dp = new int[len + 2][len + 2];
        for (int size = 1; size <= len; size++) {
            for (int i = 1; i <= len - size + 1; i++) {
                for (int k = i; k <= i + size - 1; k++) {
                    int left = /*k == i ? 0 : */dp[i][k - 1];
                    int middle = pad[i - 1] * pad[k] * pad[i + size];
                    int right = /*k == i + size - 1 ? 0 : */dp[k + 1][i + size - 1];
                    dp[i][i + size - 1] = Math.max(dp[i][i + size - 1], left + middle + right);
                    //我差，取到数组边界[1][0]不影响；
                }
            }
        }
        return dp[1][len];
    }
}


/*02*/