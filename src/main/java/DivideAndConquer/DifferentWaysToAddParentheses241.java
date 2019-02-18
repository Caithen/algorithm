package DivideAndConquer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 15501 on 2019/2/6.
 */
public class DifferentWaysToAddParentheses241 {
    public static void main(String[] args) {
        String input = "2-1-1";
        for (int r : diffWaysToCompute(input)) System.out.print(r + ", ");
        System.out.println();
        input = "2*3-4*5";
        for (int r : diffWaysToCompute(input)) System.out.print(r + ", ");
        System.out.println();
    }
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if (input == null || input.length() == 0) return res;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        if (c == '+') res.add(l + r);
                        else if (c == '-') res.add(l - r);
                        else res.add(l * r);
                    }
                }
            }
        }
        if (res.size() == 0) res.add(Integer.valueOf(input));
        return res;
    }
}
