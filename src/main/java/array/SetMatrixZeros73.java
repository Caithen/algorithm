package array;

/**
 * Created by 15501 on 2019/1/6.
 */
public class SetMatrixZeros73 {
    public static void main(String[] args) {

    }
    public void setZeroes(int[][] matrix) {
        if (matrix.length < 1 || matrix[0].length < 1) return;
        int m = matrix.length, n = matrix[0].length;
        if (m == 1 && n == 1) return;
        int[] rows = new int[m], cols = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] == 1 || cols[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
