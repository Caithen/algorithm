package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by user on 2018/12/25.
 */
public class ThreeSum15 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
//        for (List<Integer> r : threeSum(nums)) {
//            for (int num : r) {
//                System.out.print(num + "  ");
//            }
//            System.out.println();
//        }
        System.out.println();
        nums = new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        for (List<Integer> r : threeSum(nums)) {
            for (int num : r) {
                System.out.print(num + "  ");
            }
            System.out.println();
        }
    }

    // 我想到了数组排序之后，先固定两个数，然后在两个数中间查找另一个数，但这种思路太麻烦
    // 实际上可以先固定一个数，然后使用双指针的方法在这个数的后面查找另两个数
    // 注意避免重复答案，凡是相同数字就跳过。
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length < 3) return res;
        int target, left, right;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) return res;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
//            for (int show_i = i; show_i < nums.length; show_i++) System.out.print(nums[show_i] + "    ");
//            System.out.println();
            target = -nums[i]; left = i + 1; right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
//                    System.out.println("i:" + i + ",num:" + nums[i] + "; left:" + left + ",num: " + nums[left] + "; right:" + right + ",num:" + nums[right]);
                    // 这两句为了避免重复答案，答案只有在if语句类出现，所以需要写在if语句内
                    // 如果写在外面会错过nums[left]和nums[right]相等的情况
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++; right--;
                } else if (nums[left] + nums[right] > target) right--;
                else left++;
            }
        }
        return res;
    }
}
