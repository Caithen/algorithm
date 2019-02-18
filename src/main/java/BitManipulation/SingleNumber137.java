package BitManipulation;

/**
 * Created by 15501 on 2019/2/7.
 */
public class SingleNumber137 {
    public static void main(String[] args) {
        int[] nums = {2,2,3,2};
        System.out.println(singleNumber(nums));
        nums = new int[]{0,1,0,1,0,1,99};
        System.out.println(singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {
        int res = 0, temp = 1;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int num : nums) {
                cnt += (num & temp) == 0 ? 0 : 1;
            }
            if (cnt % 3 != 0) res |= temp;
            temp <<= 1;
        }
        return res;
    }
}
