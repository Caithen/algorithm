package string;

/**
 * Created by user on 2019/1/8.
 */
public class DecodeWays91 {
    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
        System.out.println(numDecodings("226"));
        System.out.println(numDecodings("0"));
        System.out.println(numDecodings("10"));
        System.out.println(numDecodings("22011"));
        System.out.println(numDecodings("220011"));
        System.out.println(numDecodings("230"));
    }
    public static int numDecodings(String s) {
        int n = s.length();
        if (n < 1 || s.charAt(0) == '0') return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1; dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            char c1 = s.charAt(i - 2), c2 = s.charAt(i - 1);
            if (c2 == '0') {
                System.out.println(c1);
                if (c1 == '1' || c1 == '2') dp[i] = dp[i - 2];
                else return 0;
            } else if (c1 == '1' || (c1 == '2' && (c2 > '0' && c2 < '7'))) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else dp[i] = dp[i - 1];
        }
        return dp[n];
    }
}
