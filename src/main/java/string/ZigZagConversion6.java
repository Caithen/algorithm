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
        ZigZagConversion6 zzc = new ZigZagConversion6();
        for (List<String> test : tests) {
            String res = zzc.convert(test.get(0), Integer.valueOf(test.get(1)));
            if (res.equals(test.get(2)))
                System.out.println(true);
            else
                System.out.println(false);
        }

    }

    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        String res = "";
        int step = 2 * (numRows - 1);
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += step) {
                res += s.charAt(j);
                int tmp = j + step - 2 * i;
                if (i != 0 && i != numRows - 1 && tmp < s.length()) res += s.charAt(tmp);
            }
        }
        return res;
    }
}
