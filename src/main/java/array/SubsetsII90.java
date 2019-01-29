package array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by user on 2019/1/8.
 */
public class SubsetsII90 {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        for (List<Integer> r : subsetsWithDup(nums)) {
            for (int num : r) System.out.print(num + ", ");
            System.out.println();
        }
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        res.add(temp);
        if (nums.length < 1) return res;
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        helper(nums, visited, 0, temp, res);
        return res;
    }
    private static void helper(int[] nums, int[] visited, int start, List<Integer> temp, List<List<Integer>> res) {
        for (int i = start; i < nums.length; i++) {
            if (visited[i] == 0) {
                if (i > start && visited[i - 1] == 0 && nums[i] == nums[i - 1]) continue;
                visited[i] = 1;
                List<Integer> tmp = new ArrayList<Integer>(temp);
                tmp.add(nums[i]);
                res.add(tmp);
                helper(nums, visited, i, tmp, res);
                visited[i] = 0;
            }
        }
    }
}
