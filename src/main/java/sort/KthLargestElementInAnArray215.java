package sort;

/**
 * Created by 15501 on 2018/10/29.
 */
public class KthLargestElementInAnArray215 {
    public static void main(String[] args) {
//        int[] nums = {3,2,1,5,6,4};
//        int k = 2;
//        int[] nums = {3,2,3,1,2,4,5,5,6};
//        int k = 4;
//        int[] nums = {5,2,4,1,3,6,0};
//        int k = 4;
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 9;
        System.out.println(findKthLargest(nums, k));
    }

    // 不要忘记先建一个容量为k的最小堆，
    // 然后再从数组中第k + 1个数字往后逐渐加入比堆顶大的数
    private static int findKthLargest(int[] nums, int k) {
        for (int i = k / 2; i >= 0; i--) {
            smallUp(nums, i, k);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > nums[0]) {
                nums[0] = nums[i];
                smallUp(nums, 0, k);
            }
        }
        return nums[0];
    }

    // 此函数的功能只是为了把小数往上提
    private static void smallUp(int[] nums, int i, int n) {
        int temp = nums[i], j = 2 * i + 1;
        while (j < n) {
            if (j + 1 < n && nums[j + 1] < nums[j]) j++;
            if (nums[j] >= temp) break;
            nums[i] = nums[j];
            i = j; j = 2 * i + 1;
        }
        nums[i] = temp;
    }
}
