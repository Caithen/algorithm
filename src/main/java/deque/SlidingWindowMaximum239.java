package deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by 15501 on 2019/2/6.
 */
public class SlidingWindowMaximum239 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7}; // 3, 3, 5, 5, 6, 7
        int k = 3;
        for (int num : maxSlidingWindow(nums, k)) System.out.print(num + ", ");
        System.out.println();
        nums = new int[]{1,3,1,2,0,5}; // 3, 3, 2, 5
        for (int num : maxSlidingWindow(nums, k)) System.out.print(num + ", ");
        System.out.println();
    }

    // 还有一种O(n)的解法，使用deque，记录目前窗口内的最大值
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;
        int[] res = new int[nums.length + 1 - k];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) deque.removeLast();
            deque.offer(i);
            if (i + 1 >= k) res[i + 1 - k] = nums[deque.peek()];
        }
        return res;
    }

    // 下面是非常常规的一种解法，使用最大堆
//    public static int[] maxSlidingWindow(int[] nums, int k) {
//        if (nums == null || nums.length == 0) return nums;
//        int[] res = new int[nums.length + 1 - k];
//        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> b - a);
//        for (int i = 0; i < nums.length; i++) {
//            queue.offer(nums[i]);
//            if (queue.size() == k) {
//                res[i - k + 1] = queue.peek();
//                queue.remove(nums[i - k + 1]);
//            }
//        }
//        return res;
//    }
}
