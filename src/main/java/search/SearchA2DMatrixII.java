package search;

/**
 * Created by 15501 on 2019/2/6.
 */
public class SearchA2DMatrixII {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 5;
        System.out.println(searchMatrix(matrix, target));
        target = 20;
        System.out.println(searchMatrix(matrix, target));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length < 1 || matrix[0].length < 1) return false;
        int nrow = matrix.length, ncol = matrix[0].length, row = nrow - 1, col = 0;
        while (row >= 0 && row < nrow && col >= 0 && col < ncol) {
            if (matrix[row][col] == target) return true;
            if (matrix[row][col] > target) row--;
            else col++;
        }
        return false;
    }
}
