package search;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 15501 on 2018/12/13.
 */
public class RemoveInvalidParentheses301 {
    public static void main(String[] args) {
        String s = "()())()";
        for (String r : removeInvalidParentheses(s))
            System.out.println(r);
        s = "(a)())()";
        for (String r : removeInvalidParentheses(s))
            System.out.println(r);
    }
    public static List<String> removeInvalidParentheses(String s) {
        int l = 0, r = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') l++;
            else if (l == 0) {
                if (c == ')') r++;
            } else if (c == ')') l--;
        }
        List<String> res = new ArrayList<String>();
        dfs(res, s, 0, l, r);
        return res;
    }
    public static void dfs(List<String> res, String s, int start, int l, int r) {
        if (l == 0 && r == 0) {
            if (isValid(s)) res.add(s);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (i != start && s.charAt(i) == s.charAt(i - 1)) continue;
            if (r > 0 && s.charAt(i) == ')') {
                dfs(res, s.substring(0, i) + s.substring(i + 1), i, l, r - 1);
            } else if (l > 0 && s.charAt(i) == '(') {
                dfs(res, s.substring(0, i) + s.substring(i + 1), i, l - 1, r);
            }
        }
    }
    public static boolean isValid(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') cnt++;
            else if (c == ')') cnt--;
            if (cnt < 0) return false;
        }
        return cnt == 0;
    }

}
