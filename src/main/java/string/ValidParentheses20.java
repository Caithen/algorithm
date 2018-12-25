package string;

import javax.security.auth.callback.CallbackHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by user on 2018/12/25.
 */
public class ValidParentheses20 {
    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
        s = "()[]{}";
        System.out.println(isValid(s));
        s = "(]";
        System.out.println(isValid(s));
        s = "([)]";
        System.out.println(isValid(s));
        s = "{[]}";
        System.out.println(isValid(s));
    }

    // 下面这种方法快一点，事实上两种方法的时间复杂度一样
    public static boolean isValid(String s) {
        Map<Character, Character> m = new HashMap<Character, Character>();
        m.put(')', '('); m.put(']', '['); m.put('}', '{');
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;
                if (stack.pop() != m.get(c)) return false;
            } else stack.push(c);
        }
        return stack.isEmpty();
    }

//    public static boolean isValid(String s) {
//        Stack<Character> stack = new Stack();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == ')') {
//                if (stack.isEmpty()) return false;
//                if (stack.pop() != '(') return false;
//            } else if (c == ']') {
//                if (stack.isEmpty()) return false;
//                if (stack.pop() != '[') return false;
//            } else if (c == '}') {
//                if (stack.isEmpty()) return false;
//                if (stack.pop() != '{') return false;
//            } else stack.push(c);
//        }
//        return stack.isEmpty();
//    }
}
