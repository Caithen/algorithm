package array;

import java.util.*;

/**
 * Created by user on 2019/1/3.
 */
public class Permutations46 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        for (List<Integer> r : permute(nums)) {
            for (int num : r) {
                System.out.print(num + ", ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length < 1) return res;
        int[] visited = new int[nums.length];
        List<Integer> temp = new ArrayList<Integer>();
        permuteCore(nums, visited, temp, res);
        return res;
    }
    private static void permuteCore(int[] nums, int[] visited, List<Integer> temp, List<List<Integer>> res) {
        if (temp.size() == nums.length) {
            res.add(temp); return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                List<Integer> tmp = new ArrayList<Integer>(temp);
                tmp.add(nums[i]);
                permuteCore(nums, visited, tmp, res);
                visited[i] = 0;
            }
        }
    }
}
