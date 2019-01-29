package array;

/**
 * Created by user on 2019/1/7.
 */
public class WordSearch79 {
    public static void main(String[] args) {
        char[][] board =
                {
                        {'A','B','C','E'},
                        {'S','F','C','S'},
                        {'A','D','E','E'}
                };
        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));
        board = new char[][]{{'a'}};
        System.out.println(exist(board, "a"));
    }
    public static boolean exist(char[][] board, String word) {
        if (word.length() < 1) return true;
        if (board.length < 1 || board[0].length < 1) return false;
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (isValid(board, visited, i, j, word)) return true;
                }
            }
        }
        return false;
    }
    private static boolean isValid(char[][] board, boolean[][] visited, int i, int j, String word) {
        if (word.length() == 0) return true;
        int m = board.length, n = board[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || board[i][j] != word.charAt(0)) return false;
        visited[i][j] = true;
        boolean res = isValid(board, visited, i - 1, j, word.substring(1)) || isValid(board, visited, i + 1, j, word.substring(1)) ||
                isValid(board, visited, i, j - 1, word.substring(1)) || isValid(board, visited, i, j + 1, word.substring(1));
        visited[i][j] = false;
        return res;
    }
}
