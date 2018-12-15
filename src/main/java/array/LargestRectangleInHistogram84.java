package array;

import java.util.Stack;

/**
 * Created by user on 2018/12/15.
 */
public class LargestRectangleInHistogram84 {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
        heights = new int[]{1,2,3,4,5,6,7,8};
        System.out.println(largestRectangleArea(heights));
        heights = new int[]{};
        System.out.println(largestRectangleArea(heights));
        heights = new int[]{1};
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (i + 1 < heights.length && heights[i] <= heights[i + 1]) continue;
            int minH = heights[i];
            for (int j = i; j >= 0; j--) {
                minH = Math.min(minH, heights[j]);
                int area = minH * (i - j + 1);
                res = Math.max(res, area);
            }
        }
        return res;
    }

//    public static int largestRectangleArea(int[] heights) {
//        int res = 0;
//        Stack<Integer> stack = new Stack<Integer>();
//        int temp;
//        for (int i = 0; i <= heights.length; i++) {
//            if (i == heights.length) temp = 0;
//            else temp = heights[i];
//            while (!stack.isEmpty() && heights[stack.peek()] >= temp) {
//                res = Math.max(res, heights[stack.pop()] * (stack.isEmpty() ? i : (i - stack.peek() - 1)));
//            }
//            stack.push(i);
//        }
//        return res;
//    }
//    public static int largestRectangleArea(int[] heights) {
//        int len = heights.length;
//        Stack<Integer> s = new Stack<Integer>();
//        int maxArea = 0;
//        for(int i = 0; i <= len; i++){
//            int h = (i == len ? 0 : heights[i]);
//            if(s.isEmpty() || h >= heights[s.peek()]){
//                s.push(i);
//            }else{
//                int tp = s.pop();
//                maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
//                i--;
//            }
//        }
//        return maxArea;
//    }



}
