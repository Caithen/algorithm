package DynamicProgramming;

import java.util.Arrays;

/**
 * Created by user on 2019/1/16.
 */
public class PalindromePartitioningII {
    public static void main(String[] args) {
        System.out.println(minCut("aab"));
    }
    public static int minCut(String s) {
        if (s.length() < 2) return 0;
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(s, 0, dp);
    }
    private static int helper(String s, int start, int[] dp) {
        if (start == s.length() - 1) {
            dp[start] = 0;
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s.substring(start, i + 1))) {
                if (i == s.length() - 1) min = 0;
                else if (dp[i + 1] != -1) min = Math.min(min, 1 + dp[i + 1]);
                else min = Math.min(min, 1 + helper(s, i + 1, dp));
            }
        }
        dp[start] = min;
        return min;
    }
    private static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
}
