public class BestTimetoBuyandSellStockwithCooldown {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)    
            return 0;
        int len = prices.length;
        int[][] dp = new int[len][3];
        //0: buy, 1 : sell, 2: cooldown
        dp[0][0] = -prices[0]; dp[0][1] = 0; dp[0][2] = 0;
        int localMax = dp[0][0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i - 1][2] - prices[i];
            dp[i][1] = localMax + prices[i];
            localMax = Math.max(localMax, dp[i][0]);
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(0, Math.max(dp[len - 1][1], dp[len - 1][2]));
    }
}

/*43 - 48轻松搞定*/