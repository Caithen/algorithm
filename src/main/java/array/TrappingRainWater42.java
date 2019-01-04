package array;

import java.util.Stack;

/**
 * Created by user on 2019/1/2.
 */
public class TrappingRainWater42 {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1}; // 6
        System.out.println(trap(height));
    }

    // 下面使用栈的方法，这种记录水量的方法和动态规划方法不同
    // 动态规划直到左边和右边的全局最大值，可以将每个位置所能承载的水全部计算出
    // 而使用栈的方法是遇到高点之后，则弹出栈顶元素，然后计算高点和现在的栈顶元素中间所能承载的水量
    // 等于 高点与现在栈顶最小值减去弹出去的值，乘以高点和栈顶之间的差值
    public static int trap(int[] height) {
        int n = height.length, i = 0, res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        while (i < n) {
            if (stack.isEmpty() || height[i] <= height[stack.peek()]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                res += stack.isEmpty() ? 0 : (Math.min(height[stack.peek()], height[i]) - height[top]) * (i - stack.peek() - 1);
            }
        }
        return res;
    }

    // 下面使用动态规划的解法
    // 使用left记录左边最高的柱体，right记录右边最高的柱体
//    public static int trap(int[] height) {
//        int n = height.length, res = 0;
//        int[] left = new int[n], right = new int[n];
//        for (int i = 1; i < n; i++) {
//            left[i] = Math.max(left[i - 1], height[i - 1]);
//            right[n - i - 1] = Math.max(right[n - i], height[n - i]);
//        }
//        for (int i = 1; i < n - 1; i++) {
//            int temp = Math.min(left[i], right[i]);
//            if (height[i] < temp) res += temp - height[i];
//        }
//        return res;
//    }
}
