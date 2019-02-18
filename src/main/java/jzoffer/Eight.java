package jzoffer;

/**
 * Created by 15501 on 2019/2/10.
 */
public class Eight {
    public static void main(String[] args) {
        Eight eight = new Eight();
        System.out.println(eight.JumpFloor(3));
        System.out.println(eight.JumpFloor1(3));
        System.out.println(eight.JumpFloor(5));
        System.out.println(eight.JumpFloor1(5));
    }
    public int JumpFloor1(int target) {
        if (target < 1) return 0;
        if (target < 2) return 1;
        int a = 1, b = 1;
        for (int i = 2; i <= target; i++) {
            b = a + b;
            a = b - a;
        }
        return b;
    }

    public int JumpFloor(int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1; dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }
}
