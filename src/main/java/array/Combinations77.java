package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2019/1/7.
 */
public class Combinations77 {
    public static void main(String[] args) {
        for (List<Integer> r : combine(4, 2)) {
            for (int num : r) System.out.print(num + ", ");
            System.out.println();
        }
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList();
        if (n < k || n == 0) return res;
        List<Integer> temp = new ArrayList();
        int[] visited = new int[n];
        helper(visited, temp, res, 1, k);
        return res;
    }
    // 挑选了一个数之后，为避免重复，只能往后选数字，不能往前选
    private static void helper(int[] visited, List<Integer> temp, List<List<Integer>> res, int start, int k) {
        if (k == 0) {
            if (temp.size() > 0) res.add(temp);
            return;
        }
        for (int i = start; i <= visited.length - k + 1; i++) {
            if (visited[i - 1] == 0) {
                visited[i - 1] = 1;
                List<Integer> tmp = new ArrayList(temp);
                tmp.add(i);
                helper(visited, tmp, res, i + 1, k - 1);
                visited[i - 1] = 0;
            }
        }
    }
}
