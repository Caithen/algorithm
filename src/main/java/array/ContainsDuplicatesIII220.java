package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 15501 on 2019/2/3.
 */
public class ContainsDuplicatesIII220 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1}; int k = 3, t = 0; // true;
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
        nums = new int[]{1,0,1,1}; k = 1; t = 2; // true
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
        nums = new int[]{1,5,9,1,5,9}; k = 2; t = 3; // false
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
        nums = new int[]{-3, 3}; k = 2; t = 4; // false
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
    }

    // 第三中方法：使用桶结构，注意负数除法上取整， 整数除法下取整
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k < 1 || t < 0) return false;
        Map<Long, Long> buckets = new HashMap<Long, Long>();
        for (int i = 0; i < nums.length; i++) {
            long num = (long)nums[i] - Integer.MIN_VALUE;
            long bucket = num  / ((long) t + 1);
            if (buckets.containsKey(bucket)) return true;
            if (buckets.containsKey(bucket - 1) && num - buckets.get(bucket - 1) <= t) return true;
            if (buckets.containsKey(bucket + 1) && buckets.get(bucket + 1) - num <= t) return true;
            buckets.put(bucket, num);
            if (i >= k) buckets.remove(((long)nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1));
        }
        return false;
    }

    // 第二种解法：使用平衡二叉搜索树
//    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//        if (nums == null || nums.length < 2 || k < 1 || t < 0) return false;
//        TreeSet<Long> set = new TreeSet<Long>();
//        for (int i = 0; i < nums.length; i++) {
//            long num = nums[i];
//            Long floor = set.floor(num), ceil = set.ceiling(num);
//            if (floor != null && Math.abs(num - floor) <= t) return true;
//            if (ceil != null && Math.abs(num - ceil) <= t) return true;
//            set.add(num);
//            if (i >= k) set.remove((long)nums[i - k]);
//        }
//        return false;
//    }

    // 第一种解法：暴力解，注意取差值是先将int转为long
//    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//        if (nums == null || nums.length < 2 || k < 1 || t < 0) return false;
//
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
//                if (Math.abs(Long.valueOf(nums[i]) - Long.valueOf(nums[j])) <= t) return true;
//            }
//        }
//
//        return false;
//    }
}
