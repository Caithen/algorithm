package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by user on 2018/12/21.
 */
public class LongestSubstringWithoutRepeatingCharacters3 {
    public static void main(String[] args) {
//        String s = "abcabcbb";
//        System.out.println(lengthOfLongestSubstring(s));
//        s = "bbbbb";
//        System.out.println(lengthOfLongestSubstring(s));
//        s = "pwwkew";
//        System.out.println(lengthOfLongestSubstring(s));
//        s = "";
//        System.out.println(lengthOfLongestSubstring(s));
//        s = "tmmzuxt";
//        System.out.println(lengthOfLongestSubstring(s));
//        System.out.println(lengthOfLongestSubstring(" "));
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("aabaab!bb"));
    }

    // 使用数组的方法，记录不重复元素，下面的方法是最快的，说明数组的访问速度比Hash表快很多
    // s.charAt(i)访问速度是O(1)，和数组访问一样
    public static int lengthOfLongestSubstring(String s) {
        int[] nums = new int[256];
        for (int i = 0; i < nums.length; i++) nums[i] = -1;
        int left = -1, res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (nums[s.charAt(i)] != -1) left = Math.max(left, nums[s.charAt(i)]);
            nums[s.charAt(i)] = i;
            res = Math.max(res, i - left);
        }
        return res;
    }

    // 使用map的方法，记录不重复元素位置
    // 这里注意left值只能增，不能减
//    public static int lengthOfLongestSubstring(String s) {
//        Map<Character, Integer> m = new HashMap<Character, Integer>();
//        int left = -1, res = 0;
//        char[] charArray = s.toCharArray();
//        for (int i = 0; i < s.length(); i++) {
//            if (m.containsKey(charArray[i]))
//                left = Math.max(left, m.get(charArray[i]));
//            m.put(charArray[i], i);
//            res = Math.max(res, i - left);
//        }
//        return res;
//    }

    // 下面的方法是对以下代码的优化，res其实可以直接等于set的大小
    // 这里需要注意的是：left -> i 之间不能有重复元素
    // aabaab!bb
//    public static int lengthOfLongestSubstring(String s) {
//        Set<Character> set = new HashSet<Character>();
//        int left = 0, res = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (set.contains(s.charAt(i))){
//                while (s.charAt(left) != s.charAt(i))
//                    set.remove(s.charAt(left++));
//                if (left != i) left++;
//            } else {
//                set.add(s.charAt(i));
//                res = Math.max(res, set.size());
//            }
//        }
//        return res;
//    }

    // 下面是用set方法解决的，很容易想到，但不够优化
//    public static int lengthOfLongestSubstring(String s) {
//        if (s.length() == 0) return 0;
//        Set<Character> set = new HashSet<Character>();
//        char[] charArray = s.toCharArray();
//        int left = 0, right, res = 1;
//        set.add(charArray[0]);
//        for (right = 1; right < charArray.length; right++) {
//            if (set.contains(charArray[right])) {
//                while (charArray[left] != charArray[right])
//                    set.remove(charArray[left++]);
//                if (left != right) left++;
//            } else {
//                set.add(charArray[right]);
//                res = Math.max(res, right - left + 1);
//            }
//        }
//        return res;
//    }
}
