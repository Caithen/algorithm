package string;

import java.util.Stack;

/**
 * Created by user on 2018/12/29.
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        String s = "(()";
        System.out.println(longestValidParentheses(s));
        s = ")()())";
        System.out.println(longestValidParentheses(s));
        s = "";
        System.out.println(longestValidParentheses(s));
        s = "(";
        System.out.println(longestValidParentheses(s));
        s = ")";
        System.out.println(longestValidParentheses(s));
        s = "()(()";
        System.out.println(longestValidParentheses(s));
    }
    public static int longestValidParentheses(String s) {
        int res = 0, start = 0;
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else if (stack.isEmpty()) {
                start = i + 1;
            } else {
                stack.pop();
                res = stack.isEmpty() ? Math.max(res, i - start + 1) : Math.max(res, i - stack.peek());
            }
        }
        return res;
    }
}
