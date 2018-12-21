package DynamicProgramming;

import java.util.*;

/**
 * Created by user on 2018/12/20.
 */
public class WordBreak139 {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(wordBreak(s, wordDict));
        s = "applepenapple";
        wordDict = new ArrayList<String>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
        System.out.println(wordBreak(s, wordDict));
    }

    // 下面是动态规划的解法，时间复杂度是O(n^2)
    // 遍历字符串，i表示遍历到的位置
    // 将[0,i]字符串拆分成两段，判断[0,j)是否能由字典里的词组成，[j, i]是否在字典里
    // d[i]记录[0,i]是否能由字典里的词组成
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<String>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

    // 首先写递归，递归的思想很简单，遍历字符串s，使用i记录遍历到的位置，
    // 判断[0, i)组成的词是否在字典里；然后递归调用函数判断[i, n)是否能由字典的词组合而成。
    // 为了减少重复操作，这里可以使用一个记忆数组memo[i]记录[i,n)能否由字典的词组合而成。
    // memo[i] = 0表示还未遍历，memo[i] = 1/-1表示能否由字典中的词组合而成。
//    public static boolean wordBreak(String s, List<String> wordDict) {
//        Set<String> dict = new HashSet<String>(wordDict);
//        int[] memo = new int[s.length()];
//        return check(s, 0, dict, memo);
//    }
//    public static boolean check(String s, int start, Set<String> dict, int[] memo) {
//        if (start >= s.length()) return true;
//        if (memo[start] != 0) return memo[start] == 1;
//        for (int i = start + 1; i <= s.length(); i++) {
//            if (dict.contains(s.substring(start, i)) && check(s, i, dict, memo)) {
//                memo[start] = 1;
//                return true;
//            }
//        }
//        memo[start] = -1;
//        return false;
//    }
}
