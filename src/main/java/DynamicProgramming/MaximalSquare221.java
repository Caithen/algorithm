package DynamicProgramming;

/**
 * Created by user on 2018/12/15.
 */
public class MaximalSquare221 {
    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare(matrix));
        matrix = new char[][]{};
        System.out.println(maximalSquare(matrix));
        matrix = new char[][]{{}};
        System.out.println(maximalSquare(matrix));
        matrix = new char[][]{{'0'}};
        System.out.println(maximalSquare(matrix));
        matrix = new char[][]{{'1'}};
        System.out.println(maximalSquare(matrix));
    }
//    public static int maximalSquare(char[][] matrix) {
//        int res = 0;
//        if (matrix.length < 1 || matrix[0].length < 1) return res;
//        int m = matrix.length, n = matrix[0].length;
//        int[][] dp = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i == 0 || j == 0) dp[i][j] = matrix[i][j] - '0';
//                else if (matrix[i][j] == '0') dp[i][j] = 0;
//                else dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
//                res = Math.max(res, dp[i][j] * dp[i][j]);
//            }
//        }
//        return res;
//    }

    // 用一维数组降低空间复杂度，使用dp[0]代表行首（每行第一个元素）之前虚设的元素，
    // pre记录更新前的dp[j]，即上一轮的dp[j]，为更新dp[j + 1]做准备。
    public static int maximalSquare(char[][] matrix) {
        int res = 0;
        if (matrix.length < 1 || matrix[0].length < 1) return res;
        int m = matrix.length, n = matrix[0].length;
        int[] dp = new int[n + 1];
        for (int i = 0; i < m; i++) {
            // 记录左上角的值
            int pre = 0;
            for (int j = 1; j <= n; j++) {
                int t = dp[j];
                if (matrix[i][j - 1] == '1') {
                    dp[j] = Math.min(dp[j], Math.min(dp[j - 1], pre)) + 1;
                    res = Math.max(res, dp[j] * dp[j]);
                } else dp[j] = 0;
                pre = t;
            }
        }
        return res;
    }

    // 下面方法是二位数组动态规划
//    public static int maximalSquare(char[][] matrix) {
//
//        if (matrix.length < 1 || matrix[0].length < 1) return 0;
//
//        int m = matrix.length, n = matrix[0].length;
//
//        int[][] dp = new int[m][n];
//
//        int res = 0;
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i == 0 || j == 0) dp[i][j] = matrix[i][j] - '0';
//                else if (matrix[i][j] == '0') dp[i][j] = 0;
//                else {
//                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
//                }
//                res = Math.max(res, dp[i][j] * dp[i][j]);
//            }
//        }
//
//        return res;
//    }


}
