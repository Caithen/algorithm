package math;

/**
 * Created by 15501 on 2019/1/26.
 * 5, 25, 125, 625
 */
public class FactorialTrailingZeroes172 {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(5));
    }

    public static int trailingZeroes(int n) {
        int res = 0;
        while (n != 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
}
