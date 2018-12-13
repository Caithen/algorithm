package search;

/**
 * Created by 15501 on 2018/12/10.
 */
public class PerfectSquares279 {
    public static void main(String[] args) {
        System.out.println(numSquares(12));
        System.out.println(numSquares(2));
        System.out.println(numSquares(7));
        System.out.println(numSquares(41));
    }

    // 这里利用了很神奇的四平方和定理
//    public static int numSquares(int n) {
//        while (n % 4 == 0) n /= 4;
//        if (n % 8 == 7) return 4;
//        for (int a = 0; a * a < n; a++) {
//            int b = (int) Math.sqrt(n - a * a);
//            if (a * a + b * b == n) {
//                return (a > 0 ? 1 : 0) + (b > 0 ? 1 : 0);
//            }
//        }
//        return 3;
//    }

    // 递归的解法，也用到小技巧，1，2，3返回值为其本身
    // for (m = 2; m * m <= n; m++)查找结果包含的数字。
//    public static int numSquares(int n) {
//        if (n < 4) return n;
//        int res = Integer.MAX_VALUE;
//        for (int m = 2; m * m <= n; m++) {
//            int a = n / (m * m), b = n % (m * m);
//            res = Math.min(res, a + numSquares(b));
//        }
//        return res;
//    }

    // 动态规划的方法
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 1; i + j * j <= n; j++) {
                dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
            }
        }
        return dp[n];
    }

}
