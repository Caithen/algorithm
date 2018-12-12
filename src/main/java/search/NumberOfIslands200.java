package search;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 15501 on 2018/12/9.
 */
public class NumberOfIslands200 {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
        grid = new char[][]{{'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        System.out.println(numIslands(grid));
    }

    // 这道题特别像130题，思想一样，标记1，只是这次使遍历整个矩阵，记录dfs的次数
    public static int numIslands(char[][] grid) {
        int m = grid.length;
        if (m < 1) return 0;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;

    }
    private static void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '$';
        if (i > 0 && grid[i - 1][j] == '1') dfs(grid, i - 1, j);
        if (i < grid.length - 1 && grid[i + 1][j] == '1') dfs(grid, i + 1, j);
        if (j > 0 && grid[i][j - 1] == '1') dfs(grid, i, j - 1);
        if (j < grid[0].length - 1 && grid[i][j + 1] =='1') dfs(grid, i, j + 1);
    }
}

