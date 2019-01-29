package math;

/**
 * Created by user on 2018/12/21.
 */
public class UglyNumber263 {
    public static void main(String[] args) {
        System.out.println(isUgly(6));
        System.out.println(isUgly(8));
        System.out.println(isUgly(14));
        System.out.println(isUgly(0));
    }

    // 完美的解法
    public static boolean isUgly(int num) {
        if (num < 1) return false;
        while (num % 2 == 0) num /= 2;
        while (num % 5 == 0) num /= 5;
        while (num % 3 == 0) num /= 3;
        return num == 1;
    }

    // 下面这种想法是非常直接的，但不完美
//    public static boolean isUgly(int num) {
//        if (num < 1) return false;
//        while (num != 1) {
//            if (num % 2 == 0) num /= 2;
//            else if (num % 3 == 0) num /= 3;
//            else if (num % 5 == 0) num /= 5;
//            else return false;
//        }
//        return true;
//    }

}
