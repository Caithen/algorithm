package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by user on 2018/12/17.
 */
public class Triangle120 {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));
        System.out.println(minimumTotal(triangle));
        triangle.clear();
        System.out.println(minimumTotal(triangle));
        triangle.add(new ArrayList<Integer>());
        System.out.println(minimumTotal(triangle));
        triangle.clear();
        triangle.add(Arrays.asList(1));
        System.out.println(minimumTotal(triangle));
    }

    // 递归下一行的元素时，需要用到上一层递归的结果。这里需要一个变量记录左上角元素的值。
    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty() || triangle.get(0).isEmpty()) return 0;
        int m = triangle.size(), n = triangle.get(m - 1).size(), i = 0, j;
        int[] dp = new int[n + 1];
        for (int k = 0; k <= n; k++) dp[k] = Integer.MAX_VALUE;
        for (List<Integer> row : triangle) {
            j = 0;
            int lefttop = Integer.MAX_VALUE;
            for (int element : row) {
                int temp = dp[j];
                if (i == 0) dp[j] = element;
                else dp[j] = Math.min(lefttop, dp[j]) + element;
                lefttop = temp;
                j++;
            }
            i++;
        }
        int res = Integer.MAX_VALUE;
        for (int d : dp) res = Math.min(res, d);
        return res;
    }
}
