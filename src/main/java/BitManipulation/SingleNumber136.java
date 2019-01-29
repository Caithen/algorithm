package BitManipulation;

/**
 * Created by user on 2019/1/16.
 */
public class SingleNumber136 {
    public static void main(String[] args) {
        int[] nums = {2,2,1};
        System.out.println(singleNumber(nums));
        nums = new int[]{4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {
        if (nums.length < 1) return -1;
        int res = 0;
        for (int num : nums) res ^= num;
        return res;
    }
}
