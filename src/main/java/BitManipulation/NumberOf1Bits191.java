package BitManipulation;

/**
 * Created by 15501 on 2019/1/29.
 */
public class NumberOf1Bits191 {
    public static void main(String[] args) {
        System.out.println(hammingWeight(Integer.parseInt("00000000000000000000000000001011", 2)));
        System.out.println(hammingWeight(Integer.parseInt("00000000000000000000000010000000", 2)));
        System.out.println(hammingWeight((int)Long.parseLong("11111111111111111111111111111101", 2)));
    }

    public static int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += (n & 1) == 0 ? 0 : 1;
            n >>= 1;
        }
        return res;
    }
}
