package sort.summary;

/**
 * Created by 15501 on 2018/10/22.
 */
public class BucketSort {
    public static void main(String[] args) {
//        int[] arr = {1, 3, 2, 5, 4, 0, 100, 99, 80, 70, 83, 6, 5, 3, 4, 2, 1, 0, 98, 87, 76, 65, 45, 34, 21};
//        int[] arr = {1, 3, 2};
//        int[] arr = {3, 1, 2, 5};
        int[] arr = {};
        radixSort(arr);
        for (int i : arr)
            System.out.print(i + "  ");
    }

    // 获取数组最大值，计算最大值位数，
    // 从低位到高位进行桶排序
    private static void radixSort(int[] arr) {
        if (arr.length < 1) return;
        int n = arr.length, max = getMax(arr);
        int[] temp = new int[n]; // 每次桶排序需要临时数组存放结果
        for (int exp = 1; max / exp > 0; exp *= 10)
            bucketSort(arr, n, exp, temp);
    }
    // 桶排序四步骤：分桶计数，计数转索引（每个桶记录该桶最后一个变量在重排数组中的位置），
    // 临时数组记录重排数组，原数组复制重排后的数组
    private static void bucketSort(int[] arr, int n, int exp, int[] output) {
        int[] buckets = new int[10];
        for (int a : arr) buckets[a / exp % 10]++;
        for (int i = 1; i < 10; i++) buckets[i] += buckets[i - 1];
        for (int i = n - 1; i >= 0; i--) {
            output[buckets[arr[i] / exp % 10] - 1] = arr[i];
            buckets[arr[i] / exp % 10]--;
        }
        for (int i = 0; i < n; i++) arr[i] = output[i];
    }
    private static int getMax(int[] arr) {
        int i = 0, max = arr[0];
        for (i = 1; i < arr.length; i++)
            max = Math.max(max, arr[i]);
        return max;
    }
}
