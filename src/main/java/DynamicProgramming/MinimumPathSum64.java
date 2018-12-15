package DynamicProgramming;

/**
 * Created by user on 2018/12/14.
 */
public class MinimumPathSum64 {
    public static void main(String[] args) {
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(minPathSum(grid));
        grid = new int[][]{};
        System.out.println(minPathSum(grid));
        grid = new int[][]{{}};
        System.out.println(minPathSum(grid));
        grid = new int[][]{{4}};
        System.out.println(minPathSum(grid));
        grid = new int[][]{{1, 2, 3, 4}, {2, 3, 4, 5}};
        System.out.println(minPathSum(grid));
    }
    public static int minPathSum(int[][] grid) {
        if (grid.length < 1 || grid[0].length < 1) return 0;
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) dp[j] = grid[i][j];
                else if (i == 0) dp[j] = dp[j - 1] + grid[i][j];
                else if (j == 0) dp[j] += grid[i][j];
                else dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }
        }
        return dp[n - 1];
    }
}
