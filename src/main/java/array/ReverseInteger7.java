package array;

/**
 * Created by user on 2018/12/24.
 */
public class ReverseInteger7 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE + "    " + Integer.MIN_VALUE);
        System.out.println(reverse(Integer.MAX_VALUE));
        System.out.println(reverse(Integer.MIN_VALUE));
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
    }

    // 将正数转成负数处理，同时在最后输出时判断一个特殊情况：正数取负反转之后正好等于最小负数，实际上对于正数是溢出。事实上这种情况不会出现
    // 注意：负数 % 10 = 负数 / 0
    public static int reverse(int x) {
        int sign = x > 0 ? -1 : 1;
        x = x > 0 ? -x : x;
        int res = 0;
        while (x != 0) {
            if ((Integer.MIN_VALUE - x % 10) / 10  > res)
                return 0;
            res = 10 * res + x % 10;
            x /= 10;
        }
        if (sign == -1 && res == Integer.MAX_VALUE) return 0;
        return sign * res;
    }
}
