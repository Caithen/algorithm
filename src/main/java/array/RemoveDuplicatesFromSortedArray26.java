package array;

/**
 * Created by user on 2018/12/27.
 */
public class RemoveDuplicatesFromSortedArray26 {
    public static void main(String[] args) {
        int[] nums = new int[]{};
        System.out.println(removeDuplicates(nums));
        for (int num : nums) System.out.print(num+",");
        System.out.println();
        nums = new int[]{1};
        System.out.println(removeDuplicates(nums));
        for (int num : nums) System.out.print(num+",");
        System.out.println();
        nums = new int[]{1, 3};
        System.out.println(removeDuplicates(nums));
        for (int num : nums) System.out.print(num+",");
        System.out.println();
        nums = new int[]{1, 1, 2};
        System.out.println(removeDuplicates(nums));
        for (int num : nums) System.out.print(num+",");
        System.out.println();
        nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        for (int num : nums) System.out.print(num+",");
        System.out.println();
    }
    public static int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) nums[++i] = nums[j];
        }
        return i+1;
    }
}
