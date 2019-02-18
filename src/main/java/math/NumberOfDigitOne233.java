package math;

/**
 * Created by 15501 on 2019/2/5.
 */
public class NumberOfDigitOne233 {
    public static void main(String[] args) {
        System.out.println(countDigitOne(1));
        System.out.println(countDigitOne(13));
        System.out.println(countDigitOne(123));
    }
    public static int countDigitOne(int n) {
        int res = 0;
        for (long i = 1; i <= n; i *= 10) {
            long divider = i * 10;
            res += (n / divider) * i + Math.min(Math.max(n % divider - i + 1, 0), i);
        }
        return res;
    }
}
