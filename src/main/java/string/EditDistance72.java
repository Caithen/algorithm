package string;

/**
 * Created by 15501 on 2019/1/6.
 */
public class EditDistance72 {
    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        System.out.println(minDistance(word1, word2));
        word1 = "intention"; word2 = "execution";
        System.out.println(minDistance(word1, word2));
    }

    public static int minDistance(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        int[][] dp = new int[l1 + 1][l2 + 1]; dp[0][0] = 0;
        for (int i = 1; i <= l1; i++) dp[i][0] = i;
        for (int j = 1; j <= l2; j++) dp[0][j] = j;
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[l1][l2];
    }

    // 下面的方法超时，可以使用动态规划解决
//    public static int minDistance(String word1, String word2) {
//        int l1 = word1.length(), l2 = word2.length();
//        if (l1 == 0) return l2;
//        if (l2 == 0) return l1;
//        if (word1.charAt(l1 - 1) == word2.charAt(l2 - 1))
//            return minDistance(word1.substring(0, l1 - 1), word2.substring(0, l2 - 1));
//        else
//            return 1 + Math.min(minDistance(word1, word2.substring(0, l2 - 1)),
//                    Math.min(minDistance(word1.substring(0, l1 - 1), word2),
//                            minDistance(word1.substring(0, l1 -1), word2.substring(0, l2 - 1))));
//    }
}
