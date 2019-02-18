package math;

import java.util.Stack;

/**
 * Created by 15501 on 2019/2/3.
 */
public class BasicCalculator224 {
    public static void main(String[] args) {
        System.out.println(calculate("1 + 1")); // 2
        System.out.println(calculate(" 2-1 + 2 ")); // 3
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)")); // 23
    }
    public static int calculate(String s) {
        int res = 0, sign = 1, len = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                res += sign * num;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                res = res * stack.pop() + stack.pop();
            }
        }
        return res;
    }
}
