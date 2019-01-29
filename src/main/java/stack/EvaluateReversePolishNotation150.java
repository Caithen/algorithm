package stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by user on 2019/1/23.
 * 此题的注意事项：判断字符串是否相等使用 equals
 */
public class EvaluateReversePolishNotation150 {
    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<String>();
        Set<String> set = new HashSet<String>();
        set.add("+"); set.add("-"); set.add("*"); set.add("/");
        for (String token : tokens) {
            if (set.contains(token)) {
                String b = stack.pop();
                String a = stack.pop();
                String c = compute(a, b, token);
                stack.push(c);
            } else stack.push(token);
        }
        String res = stack.pop();
        return Integer.parseInt(res);
    }

    private static String compute(String a, String b, String token) {
        int ai = Integer.parseInt(a), bi = Integer.parseInt(b);
        if (token.equals("+")) return String.valueOf(ai + bi);
        if (token.equals("-")) return String.valueOf(ai - bi);
        if (token.equals("*")) return String.valueOf(ai * bi);
        if (token.equals("/")) return String.valueOf(ai / bi);
        return "";
    }
}
