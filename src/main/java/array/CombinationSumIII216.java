package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 15501 on 2019/2/3.
 */
public class CombinationSumIII216 {
    public static void main(String[] args) {
        for (List<Integer> r : combinationSum3(3, 7)) {
            for (int num : r) {
                System.out.print(num + ", ");
            }
            System.out.println();
        }

        for (List<Integer> r : combinationSum3(3, 9)) {
            for (int num : r) {
                System.out.print(num + ", ");
            }
            System.out.println();
        }

    }

    public static List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (k < 0 || k > 9 || n > (9 + 9 - k + 1) * k / 2) return res;

        List<Integer> temp = new ArrayList<Integer>();

        helper(k, n, 1, temp, res);

        return res;
    }

    private static void helper(int k, int n, int start, List<Integer> temp, List<List<Integer>> res) {

        if (n < 0) return;

        if (k == 0 && n == 0) {
            if (temp.size() != 0) res.add(temp);
            return;
        }

        for (int i = start; i < 10; i++) {
            List<Integer> tmp = new ArrayList<Integer>(temp);
            tmp.add(i);
            helper(k - 1, n - i, i + 1, tmp, res);
        }

    }
}
