package array;

/**
 * Created by 15501 on 2019/1/26.
 * 下面的方法被称为 摩尔投票法
 * 摩尔投票法可以拓展到 Majority Element II
 */
public class MajorityElement169 {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(majorityElement(nums));
        nums = new int[]{2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int res = 0, cnt = 0;
        for (int num : nums) {
            if (num == res) cnt++;
            else cnt--;
            if (cnt == -1) {
                res = num;
                cnt = 1;
            }
        }
        return res;
    }
}
