package array;

import java.util.Arrays;

/**
 * Created by user on 2018/12/25.
 */
public class threeSumClosest16 {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));
    }

    // 这道题利用15题同样的思想
    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) return 0;
        int res = nums[0] + nums[1] + nums[2], sum = res, diff = Math.abs(sum - target), left, right;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            left = i + 1; right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < diff) {
                    diff = Math.abs(sum - target);
                    res = sum;
                }
                if (sum == target) return sum;
                else if (sum < target) left++;
                else right--;
            }
        }
        return res;
    }
}
