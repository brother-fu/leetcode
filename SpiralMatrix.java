public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList();
        if (matrix == null || matrix.length == 0)
            return ans;
        int row = matrix.length, col = matrix[0].length;
        int top = 0, down = row - 1, left = 0, right = col - 1;
        while (top <= down && left <= right) {
            for (int i = left; i <= right; i++) 
                ans.add(matrix[top][i]);
            top++;
            for (int i = top; i <= down; i++) 
                ans.add(matrix[i][right]);
            right--;
            if (down < top) break; //这里是比较down 和 top哦！！
            for (int i = right; i >= left; i--)
                ans.add(matrix[down][i]);
            down--;
            if (right < left) break;
            for (int i = down; i >= top; i--) 
                ans.add(matrix[i][left]);
            left++;
        }
        return ans;
    }
}