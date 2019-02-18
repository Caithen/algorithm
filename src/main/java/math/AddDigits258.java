package math;

/**
 * Created by 15501 on 2019/2/6.
 */
public class AddDigits258 {
    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }
    // 一个很普通的解法
    public static int addDigits(int num) {
        if (num < 0) return num;
        while (num > 9) {
            int n = num;
            num = 0;
            while (n > 0) {
                num += n % 10;
                n /= 10;
            }
        }
        return num;
    }
}
