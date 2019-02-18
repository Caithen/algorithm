package math;

/**
 * Created by 15501 on 2019/2/8.
 */
public class PerfectSquares279 {
    public static void main(String[] args) {
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
    }


    // 下面这种方法是比较好想的方法
    static int res = Integer.MAX_VALUE;
    public static int numSquares(int n) {
        helper(n, 1);
        return res;
    }
    private static void helper(int n, int cnt) {
        if (cnt >= res) return;
        if (Math.sqrt(n) % 1 == 0) {
            res = Math.min(res, cnt);
            return;
        }
        for (int i = (int) Math.sqrt(n); i > 0; i--) {
            helper(n - i * i, cnt + 1);
        }
    }
}
