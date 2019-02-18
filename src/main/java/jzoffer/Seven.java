package jzoffer;

/**
 * Created by 15501 on 2019/2/10.
 */
public class Seven {
    public static void main(String[] args) {
        Seven seven = new Seven();
        System.out.println(seven.Fibonacci(3));
        System.out.println(seven.Fibonacci(5));
    }
    public int Fibonacci(int n) {
        if (n < 0) return -1;
        if (n < 1) return 0;
        if (n < 3) return 1;
        int a = 1, b = 1;
        for (int i = 3; i <= n; i++) {
            b = a + b;
            a = b - a;
        }
        return b;
    }
}
