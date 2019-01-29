package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2019/1/7.
 */
public class Subsets78 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        for (List<Integer> r : subsets(nums)) {
            for (int num : r) System.out.print(num + ", ");
            System.out.println();
        }
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> temp = new ArrayList();
        res.add(temp);
        int n = nums.length;
        if (n < 1) return res;
        int[] visited = new int[n];
        helper(nums, visited, 0, temp, res);
        return res;
    }
    private static void helper(int[] nums, int[] visited, int start, List<Integer> temp, List<List<Integer>> res) {
        for (int i = start; i < nums.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                List<Integer> tmp = new ArrayList(temp);
                tmp.add(nums[i]);
                res.add(tmp);
                helper(nums, visited, i, tmp, res);
                visited[i] = 0;
            }
        }
    }
}
