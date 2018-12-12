package math;

import sort.InsertInterval57;

/**
 * Created by 15501 on 2018/11/11.
 */
public class SumOfSquareNumbers {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));
        System.out.println(judgeSquareSum(Integer.MAX_VALUE));
        System.out.println(judgeSquareSum(0));
        System.out.println(judgeSquareSum(1));
    }
    // 题意要求: 0 -> true, 1 -> true
    // 这里可是使用Math.sqrt
    public static boolean judgeSquareSum(int c) {
        if (c < 0) return false;
        int a = 0, b = (int)Math.sqrt(c);
        while (a <= b) {
            int temp = a * a + b * b;
            if (temp == c) return true;
            if (temp > c) b--;
            else a++;
        }
        return false;
    }
}
