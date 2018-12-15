package DynasticProgramming;

/**
 * Created by user on 2018/12/14.
 */
public class UniquePathII63 {
    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        System.out.println(UniquePathsWithObstacles(obstacleGrid));
        obstacleGrid = new int[][]{{1}};
        System.out.println(UniquePathsWithObstacles(obstacleGrid));
        obstacleGrid = new int[][]{{0, 0, 0}, {1, 1, 0}};
        System.out.println(UniquePathsWithObstacles(obstacleGrid));
        obstacleGrid = new int[][]{};
        System.out.println(UniquePathsWithObstacles(obstacleGrid));
        obstacleGrid = new int[][]{{}};
        System.out.println(UniquePathsWithObstacles(obstacleGrid));
    }
    public static int UniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length < 1 || obstacleGrid[0].length < 1) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) dp[j] = 0;
                else if (j > 0) dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
