package search.binarysearch;

/**
 * Created by 15501 on 2018/11/2.
 */
public class SequenceSearch {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(sequenceSearch(nums, 4));
    }
    public static int sequenceSearch(int[] nums, int val) {
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] == val) return i;
        }
        return -1;
    }
}
