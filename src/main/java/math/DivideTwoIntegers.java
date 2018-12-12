package math;


import sort.Interval;
import sort.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 15501 on 2018/11/9.
 * 负数表示方法：全部取反再加1。
 */
public class DivideTwoIntegers {
    public static void main(String[] args) {
        List<Pair> list = Arrays.asList(new Pair(-2147483648, 1), new Pair(-2147483648, -1), new Pair(2147483647, 2147483647),
                new Pair(-2147483648, -2147483648), new Pair(70, 3));
        for (Pair pair : list)
            System.out.println(divide(pair.getKey(), pair.getValue()));
    }

    /**
     * @param dividend
     * @param divisor
     * @return
     * 思路：
     * 正数负数均转为正数处理，之后再处理符号问题。
     * 左移除数，直到最接近被除数，得到nst_div。记录除数左移时增大的倍数temp。
     * 被除数减去nst_div之后得到新的dividend。继续进行上一步操作，再次得到temp。直到dividend < divisor。
     * 使用res累计temp。
     * 特殊情况：
     * 除数为0，被除数为最小的负数而除数为-1，这两种情况均返回Integer.MAX_VALUE。
     * 被除数小于除数，返回0。
     * 注意：
     * 除了输入和输出和temp，其他变量均定义为long类型，不用考虑溢出问题，不要定义为int为难自己
     */
//    public static int divide(int dividend, int divisor) {
//        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;
//        long n = Math.abs((long) dividend), m = Math.abs((long) divisor), nst_div = m, temp = 1;
//        if (n < m) return 0;
//        while (n >= (nst_div << 1)) {
//            nst_div <<= 1;
//            temp <<= 1;
//        }
//        long res = temp + divide((int)(n - nst_div), (int)m);
//        return  ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) ? (int)res : (int)(-res);
//    }

    /**
     * @param dividend
     * @param divisor
     * @return
     * 思路：
     * 如果有不允许使用long类型的要求，则需要改变思路。
     * 所有的数都转成负数来处理。
     * 不同的是这里的while循环条件：
     * 要保证除数小于被除数，同时除数要小于0。
     */
    public static int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;
        int n = dividend > 0 ? -dividend : dividend, m = divisor > 0 ? -divisor : divisor, temp = 1, nst_den = m;
        if (n > m) return 0;
        while (n <= (nst_den << 1) && (nst_den << 1) < 0) {
            temp <<= 1;
            nst_den <<= 1;
        }
        int res = temp + divide(n - nst_den, m);
        return (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ? res : -res;
    }
}
