package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2019/1/2.
 */
public class CombinationSum39 {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        List<List<Integer>> res = combinationSum(candidates, 7);
        System.out.println("[");
        for (List<Integer> r : res) {
            System.out.print("  [");
            for (int num : r) {
                System.out.print(num + ",");
            }
            System.out.println("],");
        }
        System.out.println("]");
        candidates = new int[]{2,3,5};
        res = combinationSum(candidates, 8);
        System.out.println("[");
        for (List<Integer> r : res) {
            System.out.print("  [");
            for (int num : r) {
                System.out.print(num + ",");
            }
            System.out.println("],");
        }
        System.out.println("]");
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        if (candidates.length < 1) return res;
        List<Integer> temp = new ArrayList();
        comSumCore(candidates, 0, target, temp, res);
        return res;
    }
    private static void comSumCore(int[] candidates, int index, int target, List<Integer> temp, List<List<Integer>> res) {
        if (target < 0) return;
        if (target == 0) {
            res.add(temp); return;
        }
        for (int i = index; i < candidates.length; i++) {
            List<Integer> tmp = new ArrayList<Integer>(temp);
            tmp.add(candidates[i]);
            comSumCore(candidates, i, target - candidates[i], tmp, res);
        }
    }
}
