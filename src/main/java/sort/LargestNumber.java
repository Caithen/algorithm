package sort;

import java.util.*;

/**
 * Created by 15501 on 2018/10/25.
 */
public class LargestNumber {
    public static void main(String[] args) {
        // 下面是特例
//        int[] nums = {3,30,34,5,9}; // => 9534330
        int[] nums = {0, 0};
        System.out.println(largestNumber(nums));
    }

    // 这个题需要考虑上面两个特例，所以要重写字符串比较函数
    // -(s + t1).compareTo(t1 + s) 比 注释的一大堆 慢
    public static String largestNumber(int[] nums) {
        List<String> strNums = new ArrayList<String>();
        for (int n : nums)
            strNums.add(String.valueOf(n));
        Collections.sort(strNums, new Comparator<String>() {
            public int compare(String s, String t1) {
                return -(s + t1).compareTo(t1 + s);
//                if (s.length() == t1.length()) return t1.compareTo(s);
//                if (s.length() < t1.length()) {
//                    if (s.equals(t1.substring(0, s.length()))) {
//                        return compare(s, t1.substring(s.length()));
//                    } else return t1.compareTo(s);
//                } else {
//                    if (t1.equals(s.substring(0, t1.length()))) {
//                        return compare(s.substring(t1.length()), t1);
//                    } else return t1.compareTo(s);
//                }
            }
        });
        String res = "";
        for (String r : strNums) {
            if (res.equals("0") && r.equals("0")) continue;
            res += r;
        }
        return res;
    }
}
