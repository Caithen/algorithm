package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 15501 on 2019/2/4.
 */
public class SummaryRanges228 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        for (String r : summaryRanges(nums)) System.out.print(r + ", ");
        System.out.println();
        nums = new int[]{0,2,3,4,6,8,9};
        for (String r : summaryRanges(nums)) System.out.print(r + ", ");
        System.out.println();
    }
    public static List<String>  summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if (nums.length < 1) return res;
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            while (i + 1 < nums.length && nums[i + 1] - nums[i] == 1) i++;
            if (start == nums[i]) {
                res.add(start + "");
            } else {
                res.add(start + "->" + nums[i]);
            }
        }
        return res;
    }
}
