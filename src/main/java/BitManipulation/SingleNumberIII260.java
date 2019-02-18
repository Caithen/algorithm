package BitManipulation;

/**
 * Created by 15501 on 2019/2/6.
 */
public class SingleNumberIII260 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        for (int num : singleNumber(nums)) System.out.print(num + ", ");
        System.out.println();
    }
    public static int[] singleNumber(int[] nums) {
        int x = 0;
        for (int num : nums) x ^= num;
        x &= -x;

        int[] res = new int[2];
        for (int num : nums) {
            if ((x & num) != 0) res[0] ^= num;
            else res[1] ^= num;
        }
        return res;
    }
}
