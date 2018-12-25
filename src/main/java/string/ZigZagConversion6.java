package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 15501 on 2018/10/19.
 */
public class ZigZagConversion6 {
    public static void main(String[] args) {
        List<List<String>> tests = new ArrayList<List<String>>();
        tests.add(Arrays.asList("PAYPALISHIRING", "3", "PAHNAPLSIIGYIR"));
        tests.add(Arrays.asList("PAYPALISHIRING", "4", "PINALSIGYAHRPI"));
        tests.add(Arrays.asList("A", "1", "A"));
        tests.add(Arrays.asList("AB", "1", "AB"));
        ZigZagConversion6 zzc = new ZigZagConversion6();
        for (List<String> test : tests) {
            String res = zzc.convert(test.get(0), Integer.valueOf(test.get(1)));
            if (res.equals(test.get(2))) {
                System.out.println(test.get(2));
                System.out.println(res);
                System.out.println(true);
            } else {
                System.out.println(test.get(2));
                System.out.println(res);
                System.out.println(false);
            }
        }

    }

    // 下面这种写法更容易想到，直接观察字符排列的规律
    // 首位两行字符之间的间隔都是一样的
    // 中间行字符之间的间隔分两种情况讨论
    // 注意边界条件，当numRows=1的时候，直接输出s
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        String res = "";
        int m, n, j, t;
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                m = (numRows - 1) * 2;
                n = m;
            } else {
                m = (numRows - 1 - i) * 2;
                n = i * 2;
            }
            j = i; t = 0;
            while (j < s.length() && res.length() < s.length()) {
                res += s.charAt(j);
                j += (t++ % 2 == 0 ? m : n);
            }
        }
        return res;
    }

//    public String convert(String s, int numRows) {
//        if (numRows <= 1) return s;
//        String res = "";
//        int step = 2 * (numRows - 1);
//        for (int i = 0; i < numRows; i++) {
//            for (int j = i; j < s.length(); j += step) {
//                res += s.charAt(j);
//                int tmp = j + step - 2 * i;
//                if (i != 0 && i != numRows - 1 && tmp < s.length()) res += s.charAt(tmp);
//            }
//        }
//        return res;
//    }
}
