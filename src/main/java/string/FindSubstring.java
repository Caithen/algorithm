package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 2018/12/29.
 */
public class FindSubstring {
    public static void main(String[] args) {
        String s = s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        for (int num : findSubstring(s, words)) System.out.println(num);
        s = "wordgoodgoodgoodbestword";
        words = new String[]{"word","good","best","word"};
        for (int num : findSubstring(s, words)) System.out.println(num);
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList();
        if (s.length() == 0 || words.length == 0) return res;
        int n = s.length(), m = words.length, l = words[0].length();
        Map<String, Integer> m1 = new HashMap();
        for (String w : words) {
            if (m1.containsKey(w)) m1.put(w, m1.get(w) + 1);
            else m1.put(w, 1);
        }
        for (int i = 0; i <= n - m * l; i++) {
            Map<String, Integer> m2 = new HashMap();
            int j = 0;
            for (; j < m; j++) {
                String wd = s.substring(i + j * l, i + (j + 1) * l);
                if (!m1.containsKey(wd)) break;
                if (m2.containsKey(wd)) m2.put(wd, m2.get(wd) + 1);
                else m2.put(wd, 1);
                if (m2.get(wd) > m1.get(wd)) break;
            }
            if (j == m) res.add(i);
        }
        return res;
    }
}
