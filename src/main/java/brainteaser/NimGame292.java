package brainteaser;

/**
 * Created by 15501 on 2019/2/9.
 */
public class NimGame292 {
    public static void main(String[] args) {
        System.out.println(canWinNim(4));
        System.out.println(canWinNim1(4));
    }

    // 下面是找规律
    private static boolean canWinNim1(int n) {
        return n % 4 != 0;
    }

    // 下面是空间优化后的动态规划，提交会超时
    private static boolean canWinNim(int n) {
        if (n < 4) return true;
        boolean one = true, two = true, three = true, temp;
        for (int i = 4; i <= n; i++) {
            temp = three;
            three = !one || !two || !three;
            one = two;
            two = temp;
        }
        return three;
    }
}
