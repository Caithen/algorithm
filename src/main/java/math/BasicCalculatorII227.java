package math;

import java.util.Stack;

/**
 * Created by 15501 on 2019/2/4.
 */
public class BasicCalculatorII227 {
    public static void main(String[] args) {
        System.out.println(calculator("3+2*2"));
        System.out.println(calculator(" 3/2 "));
        System.out.println(calculator(" 3+5 / 2 "));
    }
    public static int calculator(String s) {
        int res = 0;
        char operator = '+';
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') continue;
            if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                if (operator == '-') num = -num;
                else if (operator == '*') num = stack.pop() * num;
                else if (operator == '/') num = stack.pop() / num;
                stack.push(num);
            } else operator = s.charAt(i);
        }
        while (!stack.isEmpty()) res += stack.pop();
        return res;
    }
}
