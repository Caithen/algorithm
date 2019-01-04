package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by user on 2019/1/3.
 */
public class PermutationsII47 {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        for (List<Integer> r : permuteUnique(nums)) {
            for (int num : r) {
                System.out.print(num + "  ");
            }
            System.out.println();
        }
        nums = new int[]{3,3,0,3};
        for (List<Integer> r : permuteUnique(nums)) {
            for (int num : r) {
                System.out.print(num + "  ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        if (nums.length < 1) return res;
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        List<Integer> temp = new ArrayList();
        helper(nums, visited, temp, res);
        return res;
    }
    private static void helper(int[] nums, int[] visited, List<Integer> temp, List<List<Integer>> res) {
        if (temp.size() == nums.length) {
            res.add(temp); return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 0) {
                if (i > 0 && visited[i - 1] == 0 && nums[i] == nums[i - 1]) continue;
                visited[i] = 1;
                List<Integer> tmp = new ArrayList(temp);
                tmp.add(nums[i]);
                helper(nums, visited, tmp, res);
                visited[i] = 0;
            }
        }
    }
}
