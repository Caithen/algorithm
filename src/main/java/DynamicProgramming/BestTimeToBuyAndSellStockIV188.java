package DynamicProgramming;

/**
 * Created by user on 2018/12/20.
 */
public class BestTimeToBuyAndSellStockIV188 {
    public static void main(String[] args) {
        int[] prices = {2,4,1};
        System.out.println(maxProfit(2, prices));
        prices = new int[]{3,2,6,5,0,3};
        System.out.println(maxProfit(2, prices));
        prices = new int[]{};
        System.out.println(maxProfit(0, prices));
        prices = new int[]{1};
        System.out.println(maxProfit(0, prices));
        System.out.println(maxProfit(1, prices));
        System.out.println(maxProfit(200000000, prices));
    }

    // 使用两个动态规划数组，
    // 局部最优值local记录今天卖第k次股票获得的最大利润，
    // 计算方法：昨天卖了k-1次股票获取的最大利润是global[j-1] 和 昨天卖了的第k次股票留到今天卖 比较大小，取大者，然后+price[i] - price[i - 1]
    // 这里最难的是为什么是直接加上price[i] - price[i - 1]
    // 全局最优值global记录今天所能获取的最大利润
    // 计算方法：global[k]与local[k]取大者
    public static int maxProfit(int k, int[] prices) {
        if (k >= prices.length) return helper(prices);
        int[] local = new int[k + 1], global = new int[k + 1];
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = k; j > 0; j--) {
                local[j] = Math.max(global[j - 1], local[j]) + diff;
                global[j] = Math.max(global[j], local[j]);
            }
        }
        return global[k];
    }
    private static int helper(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) res += prices[i] - prices[i - 1];
        }
        return res;
    }
}
