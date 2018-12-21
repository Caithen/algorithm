package DynamicProgramming;

import java.util.*;

/**
 * Created by user on 2018/12/20.
 */
public class WordBreakII140 {
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        for (String sentence : wordBreak(s, wordDict))
            System.out.println(sentence);
        s = "pineapplepenapple";
        wordDict = new ArrayList<String>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
        for (String sentence : wordBreak(s, wordDict))
            System.out.println(sentence);
        s = "catsandog";
        wordDict = new ArrayList<String>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
        for (String sentence : wordBreak(s, wordDict))
            System.out.println(sentence);
        s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        wordDict = new ArrayList<String>(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));
        for (String sentence : wordBreak(s, wordDict))
            System.out.println(sentence);
    }

    // 使用记忆数组，避免重复计算，这里记忆数组其实是HashMap。
    // 逆向思维：遍历字典去匹配字符串
    // 难点是记忆数组怎么记，记什么
    // 记录后面字符串所有合法的拆分，所以很明显，必然是从左往右递归，递归后面的字符串。
    // 递归边界，如果HashMap中含有s，则直接返回m[s]，如果s为空，直接返回{""}
    public static List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        return helper(s, wordDict, map);
    }
    public static List<String> helper(String s, List<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) return map.get(s);
        if (s.length() == 0) return Arrays.asList("");
        List<String> res = new ArrayList<String>();
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> rem = helper(s.substring(word.length()), wordDict, map);
                for (String str : rem) {
                    res.add(word + (str.length() == 0 ? "" : " ") + str);
                }
            }
        }
        map.put(s, res);
        return res;
    }

    // 下面的方法超时
//    public static List<String> wordBreak(String s, List<String> wordDict) {
//        Set<String> dict = new HashSet<String>(wordDict);
//        List<String> res = new ArrayList<String>();
//        int maxLen = 0;
//        for (String str : wordDict) maxLen = Math.max(maxLen, str.length());
//        check(s, 0, dict, "", res, maxLen);
//        return res;
//    }
//    private static void check(String s, int start, Set<String> dict, String record, List<String> res, int maxLen) {
//        for (int i = start + 1; i <= s.length(); i++) {
//            if (i - start > maxLen) break;
//            if (dict.contains(s.substring(start, i))) {
//                if (i == s.length()) res.add(record + s.substring(start, i));
//                else check(s, i, dict, record + s.substring(start, i) + " ", res, maxLen);
//            }
//        }
//    }
}
