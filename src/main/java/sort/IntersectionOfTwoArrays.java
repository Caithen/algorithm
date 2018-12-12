package sort;

import java.util.*;

/**
 * Created by 15501 on 2018/10/25.
 */
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 3, 4, 5, 6}, nums2 = {6, 1, 3};
        int[] res = intersect(nums1, nums2);
        for (int r : res)
            System.out.print(r + "  ");
    }

    // 直接对两个数组进行排序，然后取交集，这个方法简单，反而更快
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1); Arrays.sort(nums2);
        int i = 0, j = 0;
        List<Integer> res = new ArrayList();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++; j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        int[] ans = new int[res.size()];
        for (int k = 0; k < res.size(); k++) {
            ans[k] = res.get(k);
        }
        return ans;
    }

    // 使用map记录较短数组中数字及其对应个数
//    public static int[] intersect(int[] nums1, int[] nums2) {
//        List<Integer> ans = new ArrayList<Integer>();
//        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
//        if (nums1.length > nums2.length) {
//            int[] nums3 = nums2;
//            nums2 = nums1;
//            nums1 = nums3;
//        }
//        for (int n : nums1) {
//            if (m.containsKey(n)) {
//                m.put(n, m.get(n) + 1);
//            } else m.put(n, 1);
//        }
//        for (int n : nums2) {
//            if (m.containsKey(n) && m.get(n) > 0) {
//                ans.add(n);
//                m.put(n, m.get(n) - 1);
//            }
//        }
//        int[] res = new int[ans.size()];
//        for (int i = 0; i < ans.size(); i++)
//            res[i] = ans.get(i);
//        return res;
//    }
}
