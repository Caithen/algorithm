package search;

/**
 * Created by 15501 on 2018/11/13.
 */
public class SearchA2DMatrix74 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
        System.out.println(searchMatrix(matrix, 60));
        System.out.println(searchMatrix(matrix, 0));
        System.out.println(searchMatrix(matrix, 21));
        System.out.println(searchMatrix(new int[][]{{}}, 1));
        System.out.println(searchMatrix(new int[][]{{1}}, 1));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length < 1 || matrix[0].length < 1) return false;
        int row = searchRow(matrix, target);
        if (row == -1) return false;
        int columns = searchColumn(matrix[row], target);
        if (columns == -1) return false;
        return true;
    }
    // 查找行，up只可能大于target，因为如果等于，则返回mid，如果小于则继续+
    public static int searchRow(int[][] matrix, int target) {
        int up = 0, down = matrix.length - 1, mid;
        while (up <= down) {
            mid = up + (down - up) / 2;
            if (matrix[mid][0] == target) return mid;
            if (matrix[mid][0] > target) down = mid - 1;
            else up = mid + 1;
        }
        if (up > 0 && up <= matrix.length) return up - 1;
        else return -1;
    }
    public static int searchColumn(int[] columns, int target) {
        int left = 0, right = columns.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (columns[mid] == target) return mid;
            if (columns[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}
