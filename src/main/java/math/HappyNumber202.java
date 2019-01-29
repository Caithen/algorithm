package math;

/**
 * Created by 15501 on 2019/1/29.
 */
public class HappyNumber202 {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        int slow = n, fast = sumOfSquare(n);
        while (slow != fast) {
            slow = sumOfSquare(slow);
            fast = sumOfSquare(fast);
            fast = sumOfSquare(fast);
        }
        return slow == 1;
    }
    private static int sumOfSquare(int n) {
        int res = 0;
        while (n != 0) {
            res += (n % 10) * (n % 10);
            n /= 10;
        }
        return res;
    }
}
