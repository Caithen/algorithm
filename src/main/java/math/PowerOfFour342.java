package math;

/**
 * Created by 15501 on 2019/2/5.
 */
public class PowerOfFour342 {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(5));
    }
    public static boolean isPowerOfFour(int num) {
        return Math.log10(num) / Math.log10(4) % 1 == 0;
    }
}
