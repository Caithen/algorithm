package DynamicProgramming;

/**
 * Created by user on 2018/12/21.
 */
public class BestTimeToBuyAndSellStockWithCoolDown309 {
    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        System.out.println(maxProfit(prices));
        prices = new int[]{};
        System.out.println(maxProfit(prices));
        prices = new int[]{1};
        System.out.println(maxProfit(prices));
        prices = new int[]{1, 100, 0, 0, 0};
        System.out.println(maxProfit(prices));
    }
    // 维持两个动态数组，买和卖
    // buy[i] = Math.max(sell[i-2] - prices[i], buy[i-1])
    // 今天手里还有没卖的股票所获得的最大利润只有两种可能：要不是以前买的，要不是今天买的股票（要保证昨天没有卖股票），
    // sell[i] = Math.max(buy[i-1] + prices[i], sell[i-1])
    // 今天卖股票所获得的最大利润也是两种可能：要不是以前卖的，要不是以前买的今天卖
    public static int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE, sell = 0, preBuy = 0, preSell = 0;
        for (int i = 0; i < prices.length; i++) {
            preBuy = buy;
            buy = Math.max(preSell - prices[i], preBuy);
            preSell = sell;
            sell = Math.max(preBuy + prices[i], preSell);
        }
        return sell;
    }
}
