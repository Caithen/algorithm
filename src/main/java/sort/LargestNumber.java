package sort;

import java.util.*;

/**
 * Created by 15501 on 2018/10/25.
 * 这里需要注意数组里可能包含多个0 ：{0，0}
 */
public class LargestNumber {
    public static void main(String[] args) {
        // 下面是特例
        int[] nums = {3,30,34,5,9}; // => 9534330
//        int[] nums = {0, 0};
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
