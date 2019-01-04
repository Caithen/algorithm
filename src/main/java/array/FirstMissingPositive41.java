package array;

/**
 * Created by user on 2019/1/2.
 */
public class FirstMissingPositive41 {
    public static void main(String[] args) {
        int[] nums = {1,2,0};
        System.out.println(firstMissingPositive(nums));
        nums = new int[]{3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
        nums = new int[]{7,8,9,11,12};
        System.out.println(firstMissingPositive(nums));
        nums = new int[]{2};
        System.out.println(firstMissingPositive(nums));
        nums = new int[]{0,1,2};
        System.out.println(firstMissingPositive(nums));
    }

    // 还有一种交换数字的方法，把数字放到对应的位置
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length, temp;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) return i+1;
        }
        return n+1;
    }

    // 先过滤掉没用的数字
    // 处理有用数字时，要考虑处理位置数字的正负
//    public static int firstMissingPositive(int[] nums) {
//        int max = nums.length + 1;
//        for (int num : nums) max = Math.max(max, num);
//        for (int num : nums) {
//            if (num % max <= 0) continue;
//            else if (num % max > nums.length) continue;
//            else if (nums[num % max - 1] <= 0) nums[num % max - 1] -= (max + 1);
//            else nums[num % max - 1] += max;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (Math.abs(nums[i]) <= max) return i+1;
//        }
//        return nums.length+1;
//    }
}
