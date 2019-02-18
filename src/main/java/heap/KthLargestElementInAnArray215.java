package heap;

/**
 * Created by 15501 on 2019/2/3.
 */
public class KthLargestElementInAnArray215 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
        nums = new int[]{1}; k = 1;
        System.out.println(findKthLargest(nums, k));
        nums = new int[]{3,2,3,1,2,4,5,5,6}; k = 4;
        System.out.println(findKthLargest(nums, k));
    }

    // 快排的思想
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = nums.length - 1, pos;
        while (true) {
            pos = partition(nums, left, right);
            if (pos + 1 == k) return nums[pos];
            else if (pos + 1 > k) {
                right = pos - 1;
            } else {
                left = pos + 1;
            }
        }
    }

    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
           while (left < right && nums[right] < pivot) right--;
           if (left < right) nums[left++] = nums[right];
           while (left < right && nums[left] >= pivot) left++;
           if (left < right) nums[right--] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    // 优先队列
//    public static int findKthLargest(int[] nums, int k) {
//        if (nums == null || nums.length == 0) return 0;
//        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
//        for (int num : nums) {
//            queue.offer(num);
//            if (queue.size() > k) queue.poll();
//        }
//        return queue.poll();
//    }
}
