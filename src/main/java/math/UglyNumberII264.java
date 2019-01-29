package math;

/**
 * Created by 15501 on 2019/1/29.
 */
public class UglyNumberII264 {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }

    public static int nthUglyNumber(int n) {
        if (n < 1) return 0;
        int[] nums = new int[n]; nums[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0, m2, m3, m5;
        for (int i = 1; i < n; i++) {
            m2 = 2 * nums[i2];
            m3 = 3 * nums[i3];
            m5 = 5 * nums[i5];
            nums[i] = Math.min(m2, Math.min(m3, m5));
            if (nums[i] == m2) i2++;
            if (nums[i] == m3) i3++;
            if (nums[i] == m5) i5++;
        }
        return nums[n - 1];
    }
}
