package hashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 15501 on 2019/2/8.
 */
public class WordPattern290 {
    public static void main(String[] args) {
        String pattern = "abba", str = "dog cat cat dog";
        System.out.println(wordPattern(pattern, str));
        pattern = "abba"; str = "dog cat cat fish";
        System.out.println(wordPattern(pattern, str));
        pattern = "aaaa"; str = "dog cat cat dog";
        System.out.println(wordPattern(pattern, str));
        pattern = "abba"; str = "dog dog dog dog";
        System.out.println(wordPattern(pattern, str));
        System.out.println(wordPattern("hello", "hello"));

    }
    public static boolean wordPattern(String pattern, String str) {
        String[] fileds = str.split(" ");
        if (pattern.length() != fileds.length) return false;
        int cnt = 0;
        String p1 = "";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                map.put(pattern.charAt(i), cnt++);
            }
            p1 += map.get(pattern.charAt(i));
        }
//        System.out.println(p1);
        cnt = 0;
        String p2 = "";
        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < fileds.length; i++) {
            if (!map1.containsKey(fileds[i])) {
                map1.put(fileds[i], cnt++);
            }
            p2 += map1.get(fileds[i]);
        }
//        System.out.println(p2);
        return p1.equals(p2);
    }

}
