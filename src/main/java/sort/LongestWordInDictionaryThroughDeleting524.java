package sort;

import java.util.*;

/**
 * Created by 15501 on 2018/10/26.
 */
public class LongestWordInDictionaryThroughDeleting524 {
    public static void main (String[] args) {
        String s = "abpcplea";
        List<String> d = new ArrayList<String>(Arrays.asList("ale","apple","monkey","plea"));
//        String s = "abpcplea";
//        List<String> d = new ArrayList<String>(Arrays.asList("a","b","c"));
//        String s = "aaa";
//        List<String> d = new ArrayList<String>(Arrays.asList("aaa","aa","a"));
        System.out.println(findLongestWord(s, d));
    }
    // 如果d.size()小，但里面的字符串长度大，那么先排序，再找合法字符串，反而快
    public static String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>() {
            public int compare(String s, String t1) {
                if (s.length() == t1.length()) {
                    return s.compareTo(t1);
                } else {
                    return s.length() < t1.length() ? 1 : -1;
                }
            }
        });
        for (String str : d) {
            if (isValid(s, str)) return str;
        }
        return "";
    }
//    public static String findLongestWord(String s, List<String> d) {
//        String res = "";
//        for (String str : d) {
//            if (isValid(s, str)) {
//                System.out.println(str);
//                if (str.length() == res.length()) {
//                    if (res.compareTo(str) > 0) {
//                        res = str;
//                    }
//                } else if (str.length() > res.length()) {
//                    res = str;
//                }
//            }
//        }
//        return res;
//    }
    private static boolean isValid(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++; j++;
            } else {
                i++;
            }
        }
        if (j == t.length()) return true;
        else return false;
    }
}
