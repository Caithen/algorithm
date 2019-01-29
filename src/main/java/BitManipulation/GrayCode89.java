package BitManipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2019/1/8.
 * 维基百科中格雷码与二进制之间的转换是解此题最简单的方法
 */
public class GrayCode89 {
    public static void main(String[] args) {
        for (int num : grayCode(2)) System.out.println(num);
    }
    public static List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < Math.pow(2, n); i++) {
            res.add(i ^ (i >> 1));
        }
        return res;
    }
}
