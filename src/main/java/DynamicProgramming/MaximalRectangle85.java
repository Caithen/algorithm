package DynamicProgramming;

import java.util.Stack;

/**
 * Created by user on 2018/12/15.
 */
public class MaximalRectangle85 {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(maximalRectangle(matrix));
        matrix = new char[][]{};
        System.out.println(maximalRectangle(matrix));
        matrix = new char[][]{{}};
        System.out.println(maximalRectangle(matrix));
        matrix = new char[][]{{'1'}};
        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        int res = 0;
        if (matrix.length < 1 || matrix[0].length < 1) return res;
        int m = matrix.length, n = matrix[0].length;
        int[] heights = new int[n], left = new int[n], right = new int[n];
        for (int j = 0; j < n; j++) right[j] = n;
        for (int i = 0; i < m; i++) {
            int  cur_left = 0, cur_right = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') heights[j] = 0;
                else heights[j] += matrix[i][j] - '0';
            }
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') left[j] = Math.max(left[j], cur_left);
                else {
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') right[j] = Math.min(right[j], cur_right);
                else {
                    right[j] = n;
                    cur_right = j;
                }
            }
            for (int j = 0; j < n; j++) {
                res = Math.max(res, (right[j] - left[j]) * heights[j]);
            }
        }
        return res;
    }
//    public static int maximalRectangle(char[][] matrix) {
//        int res = 0;
//        if (matrix.length < 1 || matrix[0].length < 1) return res;
//        int m = matrix.length, n = matrix[0].length;
//        int[] heights = new int[n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (matrix[i][j] == '0') heights[j] = 0;
//                else heights[j] += matrix[i][j] - '0';
//            }
//            res = Math.max(res, largestRectangleArea(heights));
//        }
//        return res;
//    }

//    public static int largestRectangleArea(int[] heights) {
//        int res = 0;
//        for (int i = 0; i < heights.length; i++) {
//            if (i + 1 < heights.length && heights[i] < heights[i + 1]) continue;
//            int minH = heights[i];
//            for (int j = i; j >= 0; j--) {
//                minH = Math.min(minH, heights[j]);
//                res = Math.max(res, minH * (i - j + 1));
//            }
//        }
//        return res;
//    }
    public static int largestRectangleArea(int[] heights) {
        int res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int temp;
        for (int i = 0; i <= heights.length; i++) {
            if (i == heights.length) temp = 0;
            else temp = heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] > temp) {
                res = Math.max(res, heights[stack.pop()] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return res;
    }
}
