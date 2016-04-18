public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
        int len = matrix.length;
        // step 1 mirror reverse
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= len - 1 - i; j++) {
                swap(matrix, i, j, len - 1 - j, len - 1 - i);
            }
        }
        for (int i = 0; i < len / 2; i++) {
            for (int j = 0; j < len; j++) {
                swap(matrix, i, j, len - 1 - i, j);
            }
        }
        
    }
    private void swap (int[][] matrix, int x1, int y1, int x2, int y2) {
        int tmp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = tmp;
    }
}