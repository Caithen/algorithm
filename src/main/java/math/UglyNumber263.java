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
    public static boolean isUgly(int num) {
        if (num < 1) return false;
        while (num % 2 == 0) num /= 2;
        while (num % 5 == 0) num /= 5;
        while (num % 3 == 0) num /= 3;
        return num == 1;
    }
}
