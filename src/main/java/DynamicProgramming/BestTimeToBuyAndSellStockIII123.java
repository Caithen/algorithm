package DynamicProgramming;

/**
 * Created by user on 2018/12/18.
 */
public class BestTimeToBuyAndSellStockIII123 {
    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(prices));
        prices = new int[]{1,2,3,4,5};
        System.out.println(maxProfit(prices));
        prices = new int[]{7,6,4,3,1};
        System.out.println(maxProfit(prices));
        prices = new int[]{};
        System.out.println(maxProfit(prices));
        prices = new int[]{1};
        System.out.println(maxProfit(prices));
    }

    // 局部最优值表示，今天卖第j次股票，那么今天的最大利润是：max(前些天卖了j-1次股票获取的最大利润，
    // 昨天卖了第j次股票留到今天卖) + prices[j] - prices[j - 1]
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        int[] global = new int[3], local = new int[3];
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 2; j > 0; j--) {
                local[j] = Math.max(global[j - 1], local[j]) + diff;
                global[j] = Math.max(local[j], global[j]);
            }
        }
        return global[2];
    }
//    public static int maxProfit(int[] prices) {
//        int res = 0, n = prices.length;
//        if (n < 2) return res;
//        int min = prices[0];
//        for (int i = 1; i < n; i++) {
//            if (prices[i] > min)
//                res = Math.max(res, prices[i] - min + maxProfitNext(prices, i + 1, n));
//            else min = prices[i];
//        }
//        return res;
//    }
//    private static int maxProfitNext(int[] prices, int left, int right) {
//        if (left >= right - 1) return 0;
//        int min = prices[left], res = 0;
//        for (int i = left + 1; i < right; i++) {
//            if (prices[i] > min)
//                res = Math.max(res, prices[i] - min);
//            else min = prices[i];
//        }
//        return res;
//    }
}
