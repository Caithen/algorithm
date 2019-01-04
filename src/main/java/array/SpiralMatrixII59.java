package array;

/**
 * Created by user on 2019/1/4.
 */
public class SpiralMatrixII59 {
    public static void main(String[] args) {
        for (int[] r : generateMatrix(4)) {
            for (int num : r) {
                System.out.print(num + ",");
            }
            System.out.println();
        }
        for (int[] r : generateMatrix(3)) {
            for (int num : r) {
                System.out.print(num + ",");
            }
            System.out.println();
        }
        for (int[] r : generateMatrix(0)) {
            for (int num : r) {
                System.out.print(num + ",");
            }
            System.out.println();
        }
        for (int[] r : generateMatrix(1)) {
            for (int num : r) {
                System.out.print(num + ",");
            }
            System.out.println();
        }
    }
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int num = 0;
        for (int k = 0; k < (n + 1) / 2; k++) {
            for (int j = k; j <= n - 1 - k; j++) res[k][j] = ++num;
            for (int i = k + 1; i <= n - 1 - k; i++) res[i][n - 1 - k] = ++num;
            for (int j = n - 2 - k; j >= k && k < n - 1 - k; j--) res[n - 1 - k][j] = ++num;
            for (int i = n - 2 - k; i > k && k < n - 1 - k; i--) res[i][k] = ++num;
        }
        return res;
    }
}
