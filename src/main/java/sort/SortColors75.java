package sort;

/**
 * Created by 15501 on 2018/10/28.
 */
public class SortColors75 {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        for (int num : nums) System.out.print(num + " ");
    }
    public static void sortColors(int[] nums) {
        int zero = 0, one = 0, two = 0;
        for (int num : nums) {
            if (num == 0) {
                zero++;
            } else if (num == 1) {
                one++;
            } else {
                two++;
            }
        }
        int i = 0;
        for (; i < zero; i++) nums[i] = 0;
        for (;i - zero < one; i++) nums[i] = 1;
        for (;i - zero - one < two; i++) nums[i] = 2;
    }
}
