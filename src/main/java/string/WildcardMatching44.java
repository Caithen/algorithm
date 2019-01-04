package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 15501 on 2018/10/18.
 */
public class WildcardMatching44 {
    public static void main(String[] args) {
        List<List> stringPair = new ArrayList<List>();
        stringPair.add(Arrays.asList("aa", "a"));
        stringPair.add(Arrays.asList("aa", "*"));
        stringPair.add(Arrays.asList("cb", "?a"));
        stringPair.add(Arrays.asList("adceb", "*a*b"));
        stringPair.add(Arrays.asList("acdcb", "a*c?b"));
        stringPair.add(Arrays.asList("babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab", "***bba**a*bbba**aab**b"));
        for (List<String> pair : stringPair) {
            String s = pair.get(0), p = pair.get(1);
            System.out.println(isMatch(s, p));
        }
    }

    public static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') dp[i][j] = (i > 0) ? dp[i - 1][j - 1] || dp[i - 1][j] || dp[i][j - 1] : dp[i][j - 1];
                else if (i > 0) {
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?');
                }
            }
        }
        return dp[m][n];
    }

    // 这种解法超时
//    public static boolean isMatch(String s, String p) {
//        if (s.equals("")) {
//            if (p.equals("")) return true;
//            for (char c : p.toCharArray()) if (c != '*') return false;
//            return true;
//        }
//        if (p.equals("")) return false;
//        if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?')
//            return isMatch(s.substring(1), p.substring(1));
//        else if (p.charAt(0) == '*')
//            // p.charAt(0) == '*'，因为s.substring(1)与p匹配，则必有s.substring(1)和p.substring(1)匹配，所以不用计算。
//            return isMatch(s, p.substring(1)) || isMatch(s.substring(1), p);
//        else return false;
//    }
}
