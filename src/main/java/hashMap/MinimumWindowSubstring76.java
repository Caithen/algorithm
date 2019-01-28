package hashMap;

import sort.Interval;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 15501 on 2019/1/6.
 */
public class MinimumWindowSubstring76 {
    public static void main(String[] args) {
        String S = "ADOBECODEBANC", T = "ABC";
        System.out.println(minWindow(S, T));
    }
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        Map<Character, Integer> map = constructMap(t);
        int slow = 0, fast = 0, index = 0, minLen = Integer.MAX_VALUE, mostCount = 0;
        for (; fast < s.length(); fast++) {
            Character c = s.charAt(fast);
            Integer count = map.get(c);
            if (count == null) {
                continue;
            }
            map.put(c, count - 1);
            if (count == 1) {
                // 1 -> 0
                mostCount++;
            }
            while (mostCount == map.size()) {
                if (fast - slow + 1 < minLen) {
                    minLen = fast - slow + 1;
                    index = slow;
                }
                char leftMost = s.charAt(slow++);
                Integer leftMostCount = map.get(leftMost);
                if (leftMostCount == null) {
                    continue;
                }
                map.put(leftMost, leftMostCount + 1);
                if (leftMostCount == 0) {
                    // 0 -> 1
                    mostCount--;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(index, index + minLen);
    }
    private static Map<Character, Integer> constructMap(String t) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : t.toCharArray()) {
            Integer count = map.get(c);
            if (count == null) {
                map.put(c, 1);
            } else {
                map.put(c, count + 1);
            }
        }
        return map;
    }
}
