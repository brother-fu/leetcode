public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
           return;
        boolean rzero = false, czero = false;
        int row = matrix.length, col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) 
                        rzero = true;
                    if (j == 0)
                        czero = true;
                    if (i != 0 && j != 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
        }
        for (int i = 1; i < row; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < col; j++)
                    matrix[i][j] = 0;
            }
        }
        for (int j = 1; j < col; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < row; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (rzero) {
            for (int j = 0; j < col; j++)
                matrix[0][j] = 0;
        }
        if (czero) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
          
    }
}