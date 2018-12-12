package sort.summary;

/**
 * Created by 15501 on 2018/10/22.
 */
public class MergeSort {
    public static void main(String[] args) {
//        int[] arr = {1, 3, 2, 5, 4, 0, 100, 99, 80, 70, 83, 6, 5, 3, 4, 2, 1, 0, 98, 87, 76, 65, 45, 34, 21};
//        int[] arr = {1, 3, 2};
//        int[] arr = {3, 1, 2, 5};
        int[] arr = {};
        MergeSort(arr);
        for (int i : arr)
            System.out.print(i + "  ");
    }

    private static void MergeSort(int[] arr) {
        int start = 0, end = arr.length - 1;
        int[] temp = new int[arr.length];
        mergeSort(arr, start, end, temp);
    }
    private static void mergeSort(int[] arr, int start, int end, int[] temp) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid, temp);
            mergeSort(arr, mid + 1, end, temp);
            mergeArray(arr, start, mid, end, temp);
        }
    }
    // 这里需要注意一点：mergeArray融合的数组总是相邻的数组
    private static void mergeArray(int[] arr, int start, int mid, int end, int[] temp) {
        int left = start, right = mid + 1, cur = left;
        while (left <= mid && right <= end) {
            while (left <= mid && arr[left] <= arr[right]) temp[cur++] = arr[left++];
            while (right <= end && arr[right] < arr[left]) temp[cur++] = arr[right++];
        }
        while (left <= mid) temp[cur++] = arr[left++];
        while (right <= end) temp[cur++] = arr[right++];
        for (cur = start; cur <= end; cur++)
            arr[cur] = temp[cur];
    }
}
