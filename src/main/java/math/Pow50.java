package math;

/**
 * Created by 15501 on 2018/11/11.
 */
public class Pow50 {
    public static void main(String[] args) {
        double x = 0; int n = 0;
        System.out.println(myPow(99, 222222220));
        System.out.println(myPow(x, n));
        double x1 = 1; int n1 = 100;
        System.out.println(myPow(x1, n1));
        double x2 = 1; int n2 = -1000000001;
        System.out.println(myPow(x2, n2));
        double x3 = -1.0; int n3 = -100000000;
        System.out.println(myPow(x3, n3));
        double x4 = -1.0; int n4 = -1000000001;
        System.out.println(myPow(x4, n4));
        double x5 = -1.0; int n5 = 0;
        System.out.println(myPow(x5, n5));
        double x6 = -1.0; int n6 = -1;
        System.out.println(myPow(x6, n6));
        double x7 = 0.00001; int n7 = 2147483647;
        System.out.println(myPow(x7, n7));
    }

    // 这里需要注意的是递归是myPow(x * x, n >> 1)，速度远快于myPow(x, n >> 1) * myPow(x, n >> 1)
//    public static double myPow(double x, int n) {
//        if (x == 0) return 0;
//        if (x == 1) return 1;
//        if (n == 0) return 1;
//        if (n == 1) return x;
//        if (x == -1 && n > 0) return (n & 1) == 0 ? 1 : -1;
//        if (n > 0) {
//            if ((n & 1) == 0) return myPow(x * x, n >> 1);
//            else return  x * myPow(x * x, n >> 1);
//        } else return 1 / (x * myPow(x, -(n + 1)));
//    }
    // 负数转正数，注意最小值
    public static double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n > 0) return (n & 1) == 0 ? myPow(x * x, n >> 1) : x * myPow(x * x, n >> 1);
        else return 1 / (x * myPow(x, -(n + 1)));
    }
}
