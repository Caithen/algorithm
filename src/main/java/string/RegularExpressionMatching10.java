package string;

/**
 * Created by user on 2018/12/24.
 */
public class RegularExpressionMatching10 {
    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("mississippi", "mis*is*p*."));
        System.out.println(isMatch("", ".*"));
        System.out.println(isMatch("", ".**"));
    }

    // 分为两种情况：
    // 当前字符不为"*"
    // 当前字符为"*",又可分为两种情况，重复0次和重复1次以上
    // 注意'*'的前面必须有字符
    public static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j > 1 && p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || (i > 0 && dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
                } else {
                    dp[i][j] = i > 0 && dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                }
            }
        }
        return dp[m][n];
    }

//    public static boolean isMatch(String s, String p) {
//        if (p.length() == 0) return s.length() == 0;
//        if (p.length() == 1)
//            return (s.length() == 1 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));
//        if (p.charAt(1) != '*') {
//            if (s.length() == 0) return false;
//            return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
//        }
//        while (s.length() != 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
//            if (isMatch(s, p.substring(2))) return true;
//            s = s.substring(1);
//        }
//        return isMatch(s, p.substring(2));
//    }
}
