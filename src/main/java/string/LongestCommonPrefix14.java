package string;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by user on 2018/12/24.
 */
public class LongestCommonPrefix14 {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
        strs = new String[]{"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(strs));
        strs = new String[]{"aa", "a"};
        System.out.println(longestCommonPrefix(strs));
    }

    // 下面这个方法对字符串数组进行排序，之后比较首尾字符串的公共前缀
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        Arrays.sort(strs);
        String res = "";
        for (int i = 0; i < strs[0].length() && i < strs[strs.length - 1].length(); i++) {
            if (strs[0].charAt(i) == strs[strs.length - 1].charAt(i)) res += strs[0].charAt(i);
            else break;
        }
        return res;
    }

//    public static String longestCommonPrefix(String[] strs) {
//        if (strs.length == 0) return "";
//        StringBuffer res = new StringBuffer();
//        res.append(strs[0]);
//        for (int i = 1; i < strs.length; i++) {
//            int j = 0;
//            for (j = 0; j < res.length() && j < strs[i].length(); j++) {
//                if (res.charAt(j) != strs[i].charAt(j)) break;
//            }
//            res.delete(j, res.length());
//        }
//        return res.toString();
//    }
}
