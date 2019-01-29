package BitManipulation;

/**
 * Created by 15501 on 2019/1/28.
 */
public class ReverseBits190 {
    public static void main(String[] args) {
        System.out.println(Integer.parseInt("00000010100101000001111010011100", 2));
        System.out.println(reverseBits(Integer.parseInt("00000010100101000001111010011100", 2)));
    }

    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res |= ((n >> i) & 1) << (31 - i);
        }
        return res;
    }
//    public static int reverseBits(int n) {
//        int res = 0, temp = 1;
//        for (int i = 0; i < 32; i++) {
//            if ((temp & n) != 0) res |= (1 << (31 - i));
//            temp = temp << 1;
//        }
//        return res;
//    }
}
