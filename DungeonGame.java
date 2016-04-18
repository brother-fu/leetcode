public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = dungeon[m - 1][n - 1] > 0 ? 1 : 1 - dungeon[m - 1][n - 1];
        for (int i = m - 2; i >= 0; i--)
            dp[i][n - 1] = dungeon[i][n - 1] <= 0 
                           ? dp[i + 1][n - 1] - dungeon[i][n - 1] 
                           : (dungeon[i][n - 1] + 1 >= dp[i + 1][n - 1] 
                           ? 1 : dp[i + 1][n - 1] - dungeon[i][n - 1]);
        for (int j = n - 2; j >= 0; j--) 
           dp[m - 1][j] = dungeon[m - 1][j] <= 0
                          ? dp[m - 1][j + 1] - dungeon[m - 1][j]
                          : (dungeon[m - 1][j] + 1 >= dp[m - 1][j + 1] 
                          ? 1 : dp[m - 1][j + 1] - dungeon[m - 1][j]);
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = 1 + dungeon[i][j] <= Math.min(dp[i + 1][j], dp[i][j + 1]) 
                           ? Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]
                           : 1;
                           /*
                           dungeon[i][j] <= 0 
                           ? Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]
                           : 1 + dungeon[i][j] >= Math.min(dp[i + 1][j], dp[i][j + 1])
                           ? 1 : Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]
                           */
            }
        }
        return dp[0][0];
    }
}



/* 
1. min1 < min2 && left1 < left2
2. min1 > min2 && left1 > left2
3. min1 < min2 && left1 > left2 
4. min1 > min2 && left1 < left2 
3 ／ 4 的情况下选择得根据后面的情况来；
*/

//第一次的思路是max of min [get the min blood of each path] + 1
//when you tried your best, you will not regret anything.
//想到了可能要从后面往前考虑的情况，但是仍然没法解出答案来！！