package math;

import java.util.HashMap;

/**
 * Created by 15501 on 2019/1/26.
 * 注意事项：
 * 分母为 0，
 * 分子为 0，
 * 分子或分母为负数
 * 如果题意允许使用long类型，尽量使用long类型，不然全部转化为负数
 */
public class FractionToRecurringDecimal166 {
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 2));
        System.out.println(fractionToDecimal(2, 1));
        System.out.println(fractionToDecimal(2, 3));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) return "";
        if (numerator == 0) return "0";

        StringBuffer res = new StringBuffer();
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        res.append( num / den );
        num %= den;
        if (num == 0) {
            return res.toString();
        }
        res.append(".");

        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, res.length());

        while (num % den != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            } else map.put(num, res.length());
        }

        return res.toString();
    }
}
