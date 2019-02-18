package math;

/**
 * Created by 15501 on 2019/2/5.
 */
public class PowOfTwo231 {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(128));
        System.out.println(isPowerOfTwo(218));
    }
    public static boolean isPowerOfTwo(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt += (n & 1);
            n >>= 1;
        }
        return cnt == 1;
    }
}
