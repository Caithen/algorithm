package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 15501 on 2019/1/26.
 * 这道题使用 摩尔投票法，注意使用的技巧
 * 先找到两个众数，然后统计两个众数出现的次数，最后将出现次数大于 nums.length / 3 的数加入 res
 */
public class MajorityElementII229 {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        for (int num : majorityElement(nums))
            System.out.print(num + ", ");
        System.out.println();
        nums = new int[]{1,1,1,3,3,2,2,2};
        for (int num : majorityElement(nums))
            System.out.print(num + ", ");
        System.out.println();
    }

    public static List<Integer> majorityElement(int[] nums) {

        List<Integer> res = new ArrayList<Integer>();
        int m = 0, n = 0, mcnt = 0, ncnt = 0;
        for (int num : nums) {
            if (num == m) mcnt++;
            else if (num == n) ncnt--;
            else if (mcnt == 0) {m = num; mcnt++;}
            else if (ncnt == 0) {n = num; ncnt++;}
            else {
                mcnt--; ncnt--;
            }
        }

        mcnt = ncnt = 0;
        for (int num : nums) {
            if (num == m) mcnt++;
            else if (num == n) ncnt++;
        }

        // 这里不用判断 m != n，是因为上一步计数时，
        // 如果两个数相等，则只有一个数能被计数
        if (mcnt > nums.length / 3) res.add(m);
        if (ncnt > nums.length / 3) res.add(n);

        return res;

    }
}
