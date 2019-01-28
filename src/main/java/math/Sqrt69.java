package math;

/**
 * Created by 15501 on 2018/11/11.
 */
public class Sqrt69 {
    public static void main(String[] args) {
        int x = 8;
        System.out.println(mySqrt(x));
        int x1 = 4;
        System.out.println(mySqrt(x1));
        int x2 = 17;
        System.out.println(mySqrt(x2));
        int x3 = 15;
        System.out.println(mySqrt(x3));
        int x4 = 9;
        System.out.println(mySqrt(x4));
        int x5 = 16;
        System.out.println(mySqrt(x5));
    }
    // 采用二分搜索法求平方根，这里一定要注意一件事儿啊，比较大小时候采用 x / mid 和 mid 比啊
    // 避免溢出啊
    public static int mySqrt(int x) {
        if (x <= 1) return x;
        int left = 1, right = x, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (x / mid >= mid) {
                left = mid + 1;
            } else right = mid - 1;
        }
        return right;
    }
    // 采用牛顿法求函数根，求f = x^2 - n的解，df = 2 * x
    // x(n + 1) = x(n) - f / df
    // while循环条件是对结果要求的精度，因为这里只要求输出整数，所以res - pre > 0.9即可
//    public static int mySqrt(int x) {
//        if (x <= 1) return x;
//        double res = 1, pre = 0;
//        while (Math.abs(res - pre) > 0.9) {
//            pre = res;
//            res = res - (res - x / res) / 2;
//        }
//        return (int) res;
//    }
}
