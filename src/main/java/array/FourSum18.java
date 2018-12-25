package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by user on 2018/12/25.
 */
public class FourSum18 {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        for (List<Integer> r : fourSum(nums, 0)) {
            for (int num : r) {
                System.out.print(num + "    ");
            }
            System.out.println();
        }
        System.out.println("******************************************");
        nums = new int[]{-5,-4,-3,-2,-1,0,0,1,2,3,4,5};
        for (List<Integer> r : fourSum(nums, 0)) {
            for (int num : r) {
                System.out.print(num + "    ");
            }
            System.out.println();
        }
        System.out.println("******************************************");
        nums = new int[]{1,-2,-5,-4,-3,3,3,5};
        for (List<Integer> r : fourSum(nums, -11)) {
            for (int num : r) {
                System.out.print(num + "    ");
            }
            System.out.println();
        }
    }

    // 3sum中的for循环中的直接返回语句不能加，因为target可能为负，
    // 虽然前面两个数大于target，但第三个数还是可能为负的，仍然可能存在答案
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++; right--;
                    } else if (sum > target) right--;
                    else left++;
                }
            }
        }
        return res;
    }
}
