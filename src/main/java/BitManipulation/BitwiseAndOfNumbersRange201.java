package BitManipulation;

/**
 * Created by user on 2019/1/29.
 */
public class BitwiseAndOfNumbersRange201 {
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5, 7));
        System.out.println(rangeBitwiseAnd(0, 1));
    }

    public static int rangeBitwiseAnd(int m, int n) {
        int res = -1;
        while ((m & res) != (n & res)) res <<= 1;
        return res & m;
    }

}
