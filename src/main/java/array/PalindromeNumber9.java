package array;

/**
 * Created by user on 2018/12/24.
 */
public class PalindromeNumber9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(0));
    }
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        int temp = x, res = 0;
        while (temp != 0) {
            res = 10 * res + temp % 10;
            temp /= 10;
        }
        return x == res;
    }
}
