package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2019/1/3.
 */
public class NQueens51 {
    public static void main(String[] args) {
        for (List<String> r : solveNQueens(4)) {
            for (String s : r) {
                System.out.println(s);
            }
            System.out.println();
        }
        System.out.println("****************************************");
        for (List<String> r : solveNQueens(5)) {
            for (String s : r) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

    // 这道题其实就是 数独 + 排列组合 的合体
    public static List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chessboard[i][j] = '.';
            }
        }
        List<String> temp = new ArrayList<String>();
        List<List<String>> res = new ArrayList<List<String>>();
        helper(chessboard, 0, n, temp, res);
        return res;
    }

    private static void helper(char[][] chessboard, int row, int n, List<String> temp, List<List<String>> res) {
        if (row == n) {
            res.add(temp); return;
        }
        for (int k = 0; k < n; k++) {
            chessboard[row][k] = 'Q';
            if (isValid(chessboard, row, k, n)) {
                List<String> tmp = new ArrayList<String>(temp);
                String str = "";
                for (int j = 0; j < n; j++) str += chessboard[row][j];
                tmp.add(str);
                helper(chessboard, row + 1, n, tmp, res);
            }
            chessboard[row][k] = '.';
        }
    }

    private static boolean isValid(char[][] chessboard, int row, int col, int n) {
        for (int i = 0; i < row; i++) if (chessboard[i][col] == 'Q') return false;
        for (int j = 0; j < col; j++) if (chessboard[row][j] == 'Q') return false;
        int k = 1;
        while (row - k >= 0 && col - k >= 0) {
            if (chessboard[row - k][col - k] == 'Q') return false;
            k++;
        }
        k = 1;
        while (row - k >= 0 && col + k < n) {
            if (chessboard[row - k][col + k] == 'Q') return false;
            k++;
        }
        return true;
    }
}
