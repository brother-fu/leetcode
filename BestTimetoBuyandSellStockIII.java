public class BestTimetoBuyandSellStockIII {
    /*挑选两个差值最大 VS presum[] 两种解法*/
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int len = prices.length;
        long[] left = new long[len];
        long[] right = new long[len];
        long min = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, prices[i] - min);
            left[i] = max;
            min = Math.min(min, prices[i]);
        }
        max = Integer.MIN_VALUE; min = 0;
        for (int i = len - 1; i >= 0; i--) {
            min = Math.min(min, prices[i] - max);
            right[i] = min;
            max = Math.max(max, prices[i]);
        }
        int rst = 0;
        for (int i = 0; i < len; i++) {
            rst = Math.max(rst, (int)left[i] - (int)right[i]);
        }
        return rst;
    }
    
    
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;
        int len = prices.length;
        int[] profits = new int[len];
        for (int i = 1; i < len; i++)
            profits[i] = prices[i] - prices[i - 1];
        int[] left = new int[len];
        int[] right = new int[len];
        int sum = 0, min = 0, max = 0;
        for (int i = 0; i < len; i++) {
            sum += profits[i];
            max = Math.max(max, sum - min);
            left[i] = max;
            min = Math.min(min, sum);
        }
        sum = 0; min = 0; max = 0;
        for (int i = len - 1; i >= 0; i--) {
            sum += profits[i];
            max = Math.max(sum - min, max);
            right[i] = max;
            min = Math.min(min, sum);
        }
        int rst = 0;
        for (int i = 0; i < len - 1; i++) {
            rst = Math.max(rst, left[i] + right[i + 1]); //profits不能有重叠；
        }
        return rst;
    }
}