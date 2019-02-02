package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 15501 on 2019/2/2.
 */
public class WordSearchII212 {
    public static void main(String[] args) {
        String[] words = {"oath","pea","eat","rain"};
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        for (String word : findWords(board, words)) System.out.print(word + ", ");
        System.out.println();
    }

    // 下面的方法利用了字典树
    public static List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        if (board.length < 1 || board[0].length < 1) return res;
        int m = board.length, n = board[0].length;
        TrieNode root = buildTrie(words);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    private static void dfs(char[][] board, int i, int j, TrieNode node, List<String> res) {

        char c = board[i][j];

        if (c == '#' || node.next[c - 'a'] == null) return;

        node = node.next[c - 'a'];

        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';

        if (i > 0) dfs(board, i - 1, j, node, res);
        if (j > 0) dfs(board, i, j - 1, node, res);
        if (i < board.length - 1) dfs(board, i + 1, j, node, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, node, res);

        board[i][j] = c;

    }

    private static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int j = c - 'a';
                if (node.next[j] == null) {
                    node.next[j] = new TrieNode();
                }
                node = node.next[j];
            }
            node.word = word;
        }
        return root;
    }

    // 下面的方法沿用了WordSearch的方法，但时间复杂度很高
//    public static List<String> findWords(char[][] board, String[] words) {
//
//        Set<String> res = new HashSet<String>();
//
//        if (board.length < 1 || board[0].length < 1) return new ArrayList<String>(res);
//
//        for (String word : words) {
//            if (wordSearch(board, word)) res.add(word);
//        }
//
//        return new ArrayList<String>(res);
//    }
//
//    private static boolean wordSearch(char[][] board, String word) {
//
//        int m = board.length, n = board[0].length;
//
//        boolean[][] visited = new boolean[m][n];
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (wordSearch(board, word, visited, i, j)) return true;
//            }
//        }
//        return false;
//    }
//
//    private static boolean wordSearch(char[][] board, String word, boolean[][] visited, int i, int j) {
//
//        if (word.length() < 1) return true;
//
//        char c = word.charAt(0);
//
//        int m = board.length, n = board[0].length;
//
//        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || c != board[i][j]) return false;
//
//        visited[i][j] = true;
//
//        boolean res = wordSearch(board, word.substring(1), visited, i - 1, j)
//                || wordSearch(board, word.substring(1), visited, i + 1, j)
//                || wordSearch(board, word.substring(1), visited, i, j - 1)
//                || wordSearch(board, word.substring(1), visited, i, j + 1);
//
//        visited[i][j] = false;
//
//        return res;
//    }
}

class TrieNode {
    TrieNode[] next;
    String word;
    public TrieNode() {
        next = new TrieNode[26];
    }
}
