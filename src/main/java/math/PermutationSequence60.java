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
    public static String getPermutation(int n, int k) {
        String res = "";
        if (n < 1) return res;
        int[] dp = new int[n];
        for (int i = 1; i <= n; i++) dp[i - 1] = i;
        for (int i = 1; i < n; i++) dp[i] *= dp[i - 1];
        if (k > dp[n - 1]) return res;
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) nums[i - 1] = i;
        int i = n - 2, div;
        while (k != 0) {
            div = k / dp[i];
            k = k % dp[i--];
            int num = div + (k == 0 ? 0 : 1);
            res += num;
            nums[num] = -1;
        }
        for (int num : nums) if (num != -1) res += num;
        return res;
    }
}
