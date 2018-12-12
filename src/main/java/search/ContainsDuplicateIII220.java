package search;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 15501 on 2018/12/10.
 */
public class ContainsDuplicateIII220 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k = 3, t= 0;
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
        nums = new int[]{1,0,1,1}; k = 1; t = 2;
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
        nums = new int[]{1,5,9,1,5,9}; k = 2; t = 3;
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
        nums = new int[]{0}; k = 0; t = 0;
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
        nums = new int[]{-1,2147483647}; k = 1; t = 2147483647;
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
    }

    // 一定的注意带long
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k , int t) {
        if (nums.length < 2 || k <= 0 || t < 0) return false;
        Map<Long, Long> map = new HashMap<Long, Long>();
        for (int i = 0; i < nums.length; i++) {
            long newValue = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = newValue / ((long) t + 1);
            if (map.containsKey(bucket) ||
                    (map.containsKey(bucket - 1) && newValue - map.get(bucket - 1) <= t) ||
                    (map.containsKey(bucket + 1) && map.get(bucket + 1) - newValue <= t)) {
                return true;
            }
            if (map.size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, newValue);
        }
        return false;
    }

    // 太慢
//    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//        if (nums.length < 2 || k == 0) return false;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length && j <= i + k; j++) {
//                if (Math.abs((double) nums[j] - (double)nums[i]) <= t) return true;
//            }
//        }
//        return false;
//    }

}
