package array;

/**
 * Created by user on 2019/1/7.
 */
public class RemoveDuplicatesFromSortedArrayII80 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
        nums = new int[]{0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums));
        nums = new int[]{1, 1, 1};
        System.out.println(removeDuplicates(nums));
        nums = new int[]{1, 1, 2};
        System.out.println(removeDuplicates(nums));
    }
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;
        int val = nums[0], cnt = 0, left = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == val) cnt++;
            else {
                val = nums[i];
                cnt = 1;
            }
            if (cnt <= 2) nums[left++] = nums[i];
        }
        return left;
    }
}
