package backtracking;

/**
 * Created by user on 2019/1/4.
 */
public class NQueenII52 {
    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
        System.out.println(totalNQueens(5));
    }
    public static int totalNQueens(int n) {
       int[] res = new int[1];
        char[][] chessboard = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chessboard[i][j] = '.';
            }
        }
        helper(chessboard, 0, res);
        return res[0];
    }
    public static void helper(char[][] chessboard, int row, int[] res) {
        if (row == chessboard.length) {
            res[0]++; return ;
        }
        for (int k = 0; k < chessboard.length; k++) {
            chessboard[row][k] = 'Q';
            if (isValid(chessboard, row, k)) helper(chessboard, row+1, res);
            chessboard[row][k] = '.';
        }
    }
    public static boolean isValid(char[][] chessboard, int row, int col) {
        for (int i = 0; i < row; i++) if (chessboard[i][col] == 'Q') return false;
        for (int j = 0; j < col; j++) if (chessboard[row][j] == 'Q') return false;
        int k = 1;
        while (row - k >= 0 && col - k >= 0) {
            if (chessboard[row - k][col - k] == 'Q') return false;
            k++;
        }
        k = 1;
        while (row - k >= 0 && col + k < chessboard[0].length) {
            if (chessboard[row - k][col + k] == 'Q') return false;
            k++;
        }
        return true;
    }
}
