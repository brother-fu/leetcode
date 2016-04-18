public class PaintHouseII {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0)
            return 0;
        int n = costs.length, k = costs[0].length;
        int min = -1, smin = -1;
        int rst = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            /*找第一第二小的问题感觉比较复杂；*/
            if (min == -1) { //找第一第2小的问题；
                min = j;
            } else if (costs[0][j] <= costs[0][min]) {
                smin = min; min = j;
            } else if (smin == -1 || costs[0][j] < costs[0][smin]){
                smin = j;
            }
        }
        if (n == 1)
            return costs[0][min];
        for (int i = 1; i < n; i++) {
            int tmin = -1, tsmin = -1;
            for (int j = 0; j < k; j++) {
                costs[i][j] += j == min ? costs[i - 1][smin] : costs[i - 1][min];
                if (tmin == -1) {
                    tmin = j;
                } else if (costs[i][j] <= costs[i][tmin]) {
                    tsmin = tmin; tmin = j;
                } else if (tsmin == -1 || costs[i][j] < costs[i][tsmin]){
                   tsmin = j;
                }
                if (i == n - 1) {
                    rst = Math.min(rst, costs[i][j]);
                }
            }
            min = tmin; smin = tsmin;
        }
        return rst;
    }
}


/*别人精简化的代码，求最小和次小的逻辑比你简单很多*/
public int minCostII(int[][] costs) {
    if (costs == null || costs.length == 0) return 0;

    int n = costs.length, k = costs[0].length;
    // min1 is the index of the 1st-smallest cost till previous house
    // min2 is the index of the 2nd-smallest cost till previous house
    int min1 = -1, min2 = -1;

    for (int i = 0; i < n; i++) {
        int last1 = min1, last2 = min2;
        min1 = -1; min2 = -1;

        for (int j = 0; j < k; j++) {
            if (j != last1) {
                // current color j is different to last min1
                costs[i][j] += last1 < 0 ? 0 : costs[i - 1][last1];
            } else {
                costs[i][j] += last2 < 0 ? 0 : costs[i - 1][last2];
            }

            // find the indices of 1st and 2nd smallest cost of painting current house i
            if (min1 < 0 || costs[i][j] < costs[i][min1]) {  /*wy: 这里小于或者小于等于都不影响结果*/
                min2 = min1; min1 = j;
            } else if (min2 < 0 || costs[i][j] < costs[i][min2]) {
                min2 = j;
            }
        }
    }

    return costs[n - 1][min1];
}