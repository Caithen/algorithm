package math;

/**
 * Created by 15501 on 2019/2/5.
 */
public class PowerOfThree326 {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
        System.out.println(isPowerOfThree(0));
        System.out.println(isPowerOfThree(9));
        System.out.println(isPowerOfThree(25));
    }

//    public static boolean isPowerOfThree(int n) {
//        return Math.log10(n) / Math.log10(3) % 1 == 0;
////        return n > 0 && Math.log10(n) / Math.log10(3) % 1 == 0;
//    }
    public static boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
