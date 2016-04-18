public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int up = 0, down = n - 1, left = 0, right = n - 1;
        int t = 1;
        while (t <= n * n) {
            for (int j = left; j <= right; j++)
                ans[up][j] = t++;
            up++;
            //if (t > n * n) break;
            for (int i = up; i <= down; i++) 
                ans[i][right] = t++;
            right--;
            //if (t > n * n) break;
            for (int j = right; j >= left; j--)
                ans[down][j] = t++;
            down--;
            //if (t > n * n) break;
            for (int i = down; i >= up; i--)
                ans[i][left] = t++;
            left++;
            //if (t > n * n) break;
        }
        return ans;
    }
}