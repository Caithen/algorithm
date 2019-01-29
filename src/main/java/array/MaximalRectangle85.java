package array;

/**
 * Created by user on 2019/1/8.
 */
public class MaximalRectangle85 {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(maximalRectangle(matrix));
    }
    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length < 1 || matrix[0].length < 1) return 0;
        int m = matrix.length, n = matrix[0].length, res = 0;
        int[] heights = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') heights[j] = 0;
                else heights[j] += 1;
            }
            for (int j = 0; j < n; j++) {
                if (j < n - 1 && heights[j] < heights[j + 1]) continue;
                int minH = Integer.MAX_VALUE;
                for (int k = j; k >= 0; k--) {
                    minH = Math.min(minH, heights[k]);
                    res = Math.max(res, minH * (j - k + 1));
                }
            }
        }
        return res;
    }
}
