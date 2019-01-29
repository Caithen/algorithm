package math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2019/1/4.
 */
public class PermutationSequence60 {
    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));
        System.out.println(getPermutation(4, 9));
    }

    // 一定要注意 --k 因为第k个数，转化成数组索引是 k - 1 啊
    public static String getPermutation(int n, int k) {
        if (n < 1) return "";
        int[] nums = new int[n], dp = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
            if (i == 0) dp[i] = 1;
            else dp[i] = (i + 1) * dp[i - 1];
        }
        if (k > dp[n - 1]) return "";
        String res = "";
        int i = n - 2, div;
        --k;
        while (k > 0) {
            div = k / dp[i];
            k = k % dp[i--];
            int j = -1;
            while (div >= 0 && j < n) {
                j++;
                if (nums[j] != -1) div--;
            }
            res += nums[j];
            nums[j] = -1;
        }
        for (int num : nums) if (num != -1) res += num;
        return res;
    }
}
