package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2019/1/4.
 */
public class SpiralMatrix54 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12}
        };
        for (int r : spiralOrder(matrix)) System.out.print(r + ", ");
        System.out.println();
        matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        for (int r : spiralOrder(matrix)) System.out.print(r + ", ");
        System.out.println();
        matrix = new int[][]{
                {1}
        };
        for (int r : spiralOrder(matrix)) System.out.print(r + ", ");
        System.out.println();
    }

    // 这里需要注意三点：
    // 不要忽略中心元素
    // 向右遍历时不需要判断所在行是否被遍历过，因为时第一次遍历，向下遍历同理。
    // 向左向上遍历有可能和向右向下重复，所以要确保向左遍历不与向右遍历同行，向上遍历不与向下遍历同行
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList();
        if (matrix.length == 0 || matrix[0].length == 0) return res;
        int m = matrix.length, n = matrix[0].length;
        for (int k = 0; k < (m + 1) / 2 && k < (n + 1) / 2; k++) {
            for (int j = k; j <= n - 1 - k; j++) res.add(matrix[k][j]);
            for (int i = k + 1; i <= m - 1 - k; i++) res.add(matrix[i][n - 1 - k]);
            for (int j = n - 2 - k; j >= k && m - 1 - k > k; j--) res.add(matrix[m - 1 - k][j]);
            for (int i = m - 2 - k; i > k && k < n - 1 - k; i--) res.add(matrix[i][k]);
        }
        return res;
    }
}
