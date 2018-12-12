package search;

/**
 * Created by 15501 on 2018/12/6.
 */
public class SurroundedRegions130 {
    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}};
        solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + "    ");
            }
            System.out.println();
        }
        board = new char[][]{{}};
        solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + "    ");
            }
            System.out.println();
        }
    }

    // 逆向思维
    // 一般情况下，我们会想办法找被围起来的'O'，然后把它变为'X'，这种方法非常难
    // 现在，我们找没有被围起来的'O'，然后把它变为'$'，怎么找呢？
    // 找矩形周边的'O'，然后递归遍历和这个'O'相连的'O'，都变为'S'。
    // 最后剩余的'O'就是被围起来的'O'。
    public static void solve(char[][] board) {
        int m = board.length;
        if (m < 1) return;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    if (board[i][j] == 'O') dfs(board, i, j, m, n);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '$') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
    private static void dfs(char[][] board, int i, int j, int m, int n) {
        board[i][j] = '$';
        if (i > 1 && board[i - 1][j] == 'O') dfs(board, i - 1, j, m, n);
        if (i < m - 2 && board[i + 1][j] == 'O') dfs(board, i + 1, j, m, n);
        if (j > 1 && board[i][j - 1] == 'O') dfs(board, i , j - 1, m, n);
        if (j < n - 2 && board[i][j + 1] == 'O') dfs(board, i, j + 1, m, n);
    }
}
