package array;

/**
 * Created by user on 2019/1/3.
 */
public class JumpGameII45 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
//        System.out.println(jump(nums));
        nums = new int[]{34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,1,0};
        System.out.println(jump(nums));
    }
    public static int jump(int[] nums) {
        int preRight = Integer.MAX_VALUE, right = nums.length - 1, res = 0;
        while (right < preRight) {
            preRight = right;
            for (int i = preRight - 1; i >= 0; i--) {
                if (nums[i] >= preRight - i) right = i;
            }
            res++;
            System.out.println(preRight);
        }
        if (preRight == 0) return res - 1;
        else return Integer.MAX_VALUE;
    }
}
