package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 2019/1/3.
 */
public class GroupAnagrams49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        for (List<String> r : groupAnagrams(strs)) {
            for (String s : r) {
                System.out.print(s + ", ");
            }
            System.out.println();
        }
        double x = 0;
        System.out.println(x == 0.0D);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList();
        Map<String, List<String>> m = new HashMap();
        int[] nums = new int[26];
        for (String str : strs) {
            for (char c : str.toCharArray()) {
                nums[c - 'a']++;
            }
            String key = "";
            for (int num : nums) key += num;
            if (m.containsKey(key)) {
                m.get(key).add(str);
            } else {
                List<String> temp = new ArrayList();
                temp.add(str);
                m.put(key, temp);
            }
            for (int i = 0; i < nums.length; i++) nums[i] = 0;
        }
        for (String key : m.keySet()) {
            res.add(m.get(key));
        }
        return res;
    }
}
