package math;

/**
 * Created by 15501 on 2019/1/29.
 */
public class CountPrimes204 {
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
        System.out.println(countPrimes(11));
        System.out.println(countPrimes(12));
    }
    private static int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n];
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrimes[i]) {
                res++;
                for (int j = 2; j * i < n; j++) {
                    notPrimes[i * j] = true;
                }
            }
        }
        return res;
    }
}
