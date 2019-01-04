package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by user on 2019/1/2.
 */
public class CombinationSumII40 {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        List<List<Integer>> res = combinationSum2(candidates, 8);
        System.out.println("[");
        for (List<Integer> r : res) {
            System.out.print("  [");
            for (int num : r) {
                System.out.print(num + ",");
            }
            System.out.println("],");
        }
        System.out.println("]");
        candidates = new int[]{2,5,2,1,2};
        res = combinationSum2(candidates, 5);
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

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        if (candidates.length < 1) return res;
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList();
        comSumCore(candidates, target, 0, temp, res);
        return res;
    }
    // 下面注意去重
    private static void comSumCore(int[] candidates, int target, int index, List<Integer> temp, List<List<Integer>> res) {
        if (target < 0) return;
        if (target == 0) {
            res.add(temp); return;
        }
        for (int i = index; i < candidates.length; i++) {
            // 下面这一句很重要，用于去重
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            List<Integer> tmp = new ArrayList(temp);
            tmp.add(candidates[i]);
            comSumCore(candidates, target-candidates[i], i+1, tmp, res);
        }
    }
}
