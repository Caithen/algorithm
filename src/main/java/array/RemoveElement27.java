package array;

/**
 * Created by user on 2018/12/27.
 */
public class RemoveElement27 {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int length = removeElement(nums, 3);
        for (int i = 0; i < length; i++) System.out.print(nums[i] + ", ");
        System.out.println();
        nums = new int[]{0,1,2,2,3,0,4,2};
        length = removeElement(nums, 2);
        for (int i = 0; i < length; i++) System.out.print(nums[i] + ", ");
        System.out.println();
        nums = new int[]{1};
        length = removeElement(nums, 1);
        for (int i = 0; i < length; i++) System.out.print(nums[i] + ", ");
        System.out.println();
    }

    public static int removeElement(int[] nums, int val) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) nums[res++] = nums[i];
        }
        return res;
    }

//    public static int removeElement(int[] nums, int val) {
//        if (nums.length < 1) return nums.length;
//        int i = 0, j =  nums.length - 1, tmp;
//        while (i <= j) {
//            while (i <= j && nums[j] == val) j--;
//            if (i < j && nums[i] == val) {
//                tmp = nums[j];
//                nums[j--] = nums[i];
//                nums[i++] = tmp;
//            } else i++;
//        }
//        return j + 1;
//    }
}
