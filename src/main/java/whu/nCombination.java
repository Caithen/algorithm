package whu;

/**
 * Created by 15501 on 2019/2/7.
 */
public class nCombination {
    public static void main(String[] args) {
        combination(6);
    }
    public static void combination(int n) {
        String temp = "";
        helper(n, n, temp);
    }
    private static void helper(int n, int start, String temp) {
        if (n == 0) {
            System.out.println(temp.substring(1));
            return;
        }
        for (int i = Math.min(n, start); i > 0; i--) {
            String tmp = temp +  "+" + i;
            helper(n - i, i, tmp);
        }
    }
}
