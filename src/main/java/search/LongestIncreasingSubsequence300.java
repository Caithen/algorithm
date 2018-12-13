package search;

/**
 * Created by 15501 on 2018/12/13.
 */
public class LongestIncreasingSubsequence300 {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
        nums = new int[]{10,9,2,5,3,4};
        System.out.println(lengthOfLIS(nums));
        nums = new int[0];
        System.out.println(lengthOfLIS(nums));
        nums = new int[]{1};
        System.out.println(lengthOfLIS(nums));
        nums = new int[]{4,10,4,3,8,9};
        System.out.println(lengthOfLIS(nums));
    }

    // 这个dp的思想：计算包含nums[j]时最大子序列
    // 最后返回dp数组的最大值
    // 时间复杂度O(n^2)，空间复杂度O(n)
//    public static int lengthOfLIS(int[] nums) {
//        int[] dp = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) dp[i] = 1;
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = 0; j <= i; j++) {
//                if (nums[i] > nums[j]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//        }
//        int res = 0;
//        for (int p : dp) res = Math.max(res, p);
//        return res;
//    }
    // 下面是一种O(nlog(n))的解法，利用二分搜索算法
    // 新建一个dp数组，使用len记录目前放入dp递增序列的长度，把首元素放进去，然后比较后面的元素，如果遍历到的元素比
    // end数组中首元素小，则替换首元素，如果遍历到元素比目前加入dp中最大的元素还大，
    // 则元素放在其后，否则二分法遍历dp数组中第一个大于或等于新元素的位置，替换。
    // 这里需要注意
    public static int lengthOfLIS(int[] nums) {
        if (nums.length < 1) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int len = 1;
        for (int j = 1; j < nums.length; j++) {
            // 前两个边界一定得加，不然二分法会出错
            if (nums[j] < dp[0]) dp[0] = nums[j];
            else if (nums[j] > nums[len - 1]) {
                dp[len] = nums[j];
                len++;
            } else {
                int left = 0, right = len - 1, mid;
                while (left < right) {
                    mid = left + (right - left) / 2;
                    if (nums[mid] < nums[j]) left = mid + 1;
                    else right = mid;
                }
                nums[right] = nums[j];
            }
        }
        return len;
    }
}
