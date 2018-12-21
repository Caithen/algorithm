package DynamicProgramming;

/**
 * Created by user on 2018/12/21.
 */
public class UglyNumberII264 {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
        System.out.println(nthUglyNumber(0));
        System.out.println(nthUglyNumber(1));
    }

    // 这个题虽然想到后面的丑数可以由前面的丑数相乘得到，但没有发现具体的规律
    // http://www.cnblogs.com/grandyang/p/4743837.html
    // 注意下面 m2, m3, m5有可能由多个和dp[i]相等，因此均需要对相应的i加1
    public static int nthUglyNumber(int n) {
        if (n < 1) return 0;
        int[] dp = new int[n]; dp[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0, m2, m3, m5;
        for (int i = 1; i < n; i++) {
            m2 = dp[i2] * 2; m3 = dp[i3] * 3; m5 = dp[i5] * 5;
            dp[i] = Math.min(m2, Math.min(m3, m5));
            if (dp[i] == m2) i2++;
            if (dp[i] == m3) i3++;
            if (dp[i] == m5) i5++;
        }
        return dp[n - 1];
    }

}
