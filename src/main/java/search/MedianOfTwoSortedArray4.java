package search;

/**
 * Created by 15501 on 2018/11/8.
 */
public class MedianOfTwoSortedArray4 {
    public static void main(String[] args) {
//        int[] nums1 = {1, 3}, nums2 = {2};
//        int[] nums1 = {1, 2}, nums2 = {3, 4};
//        int[] nums1 = {1}, nums2 = {1};
//        int[] nums1 = {1}, nums2 = {1};
        int[] nums1 = {2,3,4,5,6}, nums2 = {1};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        return (findKthNumFromDoubleSortedArrays(nums1,0, nums2,0,(n + m + 1) / 2) +
                findKthNumFromDoubleSortedArrays(nums1, 0, nums2, 0,(n + m + 2) / 2)) / 2;
    }
    // 因为两个数组不能为空，所以当一个数组超出范围，可以直接返回另一个数组对应的值
//    public static double findKthNumFromDoubleSortedArrays(int[] nums1, int start1, int[] nums2, int start2, int k) {
//        // 第一种返回情况
//        if (start1 >= nums1.length) return nums2[start2 + k - 1];
//        if (start2 >= nums2.length) return nums1[start1 + k - 1];
//        // 第二种返回情况
//        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
//        // 第三种返回情况
//        if (start1 + k / 2 - 1 >= nums1.length)
//            return findKthNumFromDoubleSortedArrays(nums1, start1, nums2, start2 + k / 2, k - k / 2);
//        if (start2 + k / 2 - 1 >= nums2.length)
//            return findKthNumFromDoubleSortedArrays(nums1, start1 + k / 2, nums2, start2, k - k / 2);
//        // 第四种返回情况
//        if (nums1[start1 + k / 2 - 1] > nums2[start2 + k / 2 -1])
//            return findKthNumFromDoubleSortedArrays(nums1, start1, nums2, start2 + k / 2, k - k / 2);
//        else
//            return findKthNumFromDoubleSortedArrays(nums1, start1 + k / 2, nums2, start2, k - k / 2);
//    }
    // 另一种写法，注意递归调用时需要从未比较的数字 start + k / 2 开始
    private static double findKthNumFromDoubleSortedArrays(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if (start1 >= nums1.length) return nums2[start2 + k - 1];
        if (start2 >= nums2.length) return nums1[start1 + k - 1];
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
        int value1 = nums1.length > start1 + k / 2 - 1 ? nums1[start1 + k / 2 - 1] : Integer.MAX_VALUE;
        int value2 = nums2.length > start2 + k / 2 - 1 ? nums2[start2 + k / 2 - 1] : Integer.MAX_VALUE;
        if (value1 < value2)
            return findKthNumFromDoubleSortedArrays(nums1, start1 + k / 2 , nums2, start2, k - k / 2);
        else
            return findKthNumFromDoubleSortedArrays(nums1, start1, nums2, start2 + k / 2, k - k / 2);
    }

}
