package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2018/12/25.
 */
public class GenerateParentheses22 {
    public static void main(String[] args) {
        for (String s : generateParenthesis(3))
            System.out.println(s);
        for (String s : generateParenthesis(0))
            System.out.println(s);
        for (String s : generateParenthesis(1))
            System.out.println(s);
    }
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        helper(res, "", n, n);
        return res;
    }
    public static void helper(List<String> res, String str, int left, int right) {
        if (left == 0) {
            while (right-- > 0) str += ')';
            if (str == "") return;
            res.add(str); return;
        } else if (left < right) {
            helper(res, str + '(', left - 1, right);
            helper(res, str + ')', left, right - 1);
        } else helper(res, str + '(', left - 1, right);
    }
}
