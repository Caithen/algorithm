package search;

/**
 * Created by 15501 on 2018/12/10.
 */
public class SearchMatrix240 {
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
        target = 10;
        System.out.println(searchMatrix(matrix, target));
        target = 20;
        System.out.println(searchMatrix(matrix, target));
    }

    // 不用二分搜索，思想有点像旋转数组，使用++或--来更新指针
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m < 1) return false;
        int n = matrix[0].length;
        int i = m - 1, j = 0;
        while (i >= 0 && i < m && j >= 0 && j < n) {
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] < target) j++;
            else i--;
        }
        return false;
    }
}
