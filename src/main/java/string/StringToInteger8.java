package string;

/**
 * Created by user on 2018/12/24.
 */
public class StringToInteger8 {
    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("-   234")); // 0
        System.out.println(myAtoi("   +0 123")); // 0
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("91283472332"));
        System.out.println(myAtoi(""));
        System.out.println(myAtoi("0"));
        System.out.println(myAtoi("                                                                                                                "));
    }

    // 为了避免正负数越界的不同，使用sign记录正负号，所有数组按负数处理，最后需要对正数单独检查一下
    // 使用两个变量判断是否已出现正负号和数字
    // 处理顺序：空格、正负号、数字，最后break
    public static int myAtoi(String str) {
        int res = 0, sign = 1;
        boolean haveNumber = false, haveSign = false;
        for (char c : str.toCharArray()) {
            if (c == ' ' && !haveNumber && !haveSign) continue;
            if (c == '+' && !haveNumber && !haveSign) {
                haveSign = true;
                continue;
            }
            if (c == '-' && !haveNumber && !haveSign) {
                sign = -1;
                haveSign = true;
                continue;
            }
            if (c >= '0' && c <= '9') {
                haveNumber = true;
                int num = c - '0';
                if ((Integer.MIN_VALUE + num) / 10 > res) {
                    res = Integer.MIN_VALUE;
                    break;
                }
                res = 10 * res - num;
                continue;
            }
            break;
        }
        if (sign == 1 && res == Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return -sign * res;
    }
}
