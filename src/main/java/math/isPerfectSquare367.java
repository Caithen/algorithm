package math;

/**
 * Created by 15501 on 2018/11/11.
 */
public class isPerfectSquare367 {
    public static void main(String[] args) {
        int num = 16;
        System.out.println(isPerfectSquare(num));
        num = 14;
        System.out.println(isPerfectSquare(num));
        System.out.println(isPerfectSquare(2147483647));
        System.out.println(isPerfectSquare(5));
    }
    // left + (right - left) / 2 与 num / mid 均是防止mid移除
    // 同时要注意：需要要求num % mid == 0
    public static boolean isPerfectSquare(int num) {
        if (num < 1) return false;
        int left = 1, right = num, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (num % mid == 0 && mid == num / mid) return true;
            if (mid <= num / mid) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
