package string;

import java.util.Stack;

/**
 * Created by 15501 on 2019/1/6.
 */
public class SimplifyPath71 {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/./b/../../c/"));
    }
    public static String simplifyPath(String path) {
        String[] words = path.split("/");
        Stack<String> stack = new Stack();
        for (String word : words) {
            if (word.equals("") || word.equals(".")) continue;
            if (word.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else stack.push(word);
        }
        String res = "";
        while (!stack.isEmpty()) res = "/" + stack.pop() + res;
        if (res.equals("")) return "/";
        else return res;
    }
}
