public class BestTimetoBuyandSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;
        int len = prices.length;
        if (k > len / 2) {
            return getMax(prices);
        }
        int[][] dp = new int[len][k + 1];
        for (int j = 1; j <= k; j++) {
            int localMax = dp[0][k - 1] - prices[0];
            for (int i = 1; i < len; i++) {
                dp[i][j] = Math.max(dp[i - 1][j], localMax + prices[i]);
                localMax = Math.max(localMax, dp[i][j - 1] - prices[i]);
            }
        }
        return Math.max(dp[len - 1][k], 0);
    }
    private int getMax(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0)
                sum += tmp;
        }
        return sum;
    }
}

/*05*/
/*dp[i][j] 表示到i为止，交易不超过j次的最大的钱数*/
/*所以如果存在dp[i][j] = dp[t][j - 1] - prices[k] + prices[i], 则必然能保证dp[k][j - 1] = dp[t][j - 1]*/