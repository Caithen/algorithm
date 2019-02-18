package DynamicProgramming;

import java.util.Arrays;

/**
 * Created by 15501 on 2019/2/10.
 */
public class LongestIncreasingSubsequence300 {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
        System.out.println(lengthOfLIS1(nums));
        nums = new int[]{};
        System.out.println(lengthOfLIS(nums));
        System.out.println(lengthOfLIS1(nums));
    }

    // 第二种解法：动态规划 + binary search，
    // 时间复杂度：O(nlog(n))
    public static int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < dp[0]) {
                dp[0] = nums[i];
            } else if (nums[i] > dp[len - 1]) {
                dp[len++] = nums[i];
            } else {
                int left = 0, right = len - 1, mid;
                while (left < right) {
                    mid = left + (right - left) / 2;
                    if (dp[mid] < nums[i]) left = mid + 1;
                    else right = mid;
                }
                dp[right] = nums[i];
            }
        }
        return len;
    }

    // 第一种方法：动态规划：O(n^2)
    // 因为当前元素与前面所有的数都相关，因此需要递推到前n个数，所以时间复杂度是O(n^2)
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int d : dp) res = Math.max(res, d);
        return res;
    }
}
