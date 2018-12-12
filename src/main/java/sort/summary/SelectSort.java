package sort.summary;

/**
 * Created by 15501 on 2018/10/21.
 */
public class SelectSort {
    public static void main(String[] args) {
//        int[] arr = {1, 3, 2, 5, 4, 0, 100, 99, 80, 70, 83, 6, 5, 3, 4, 2, 1, 0, 98, 87, 76, 65, 45, 34, 21};
//        int[] arr = {1, 3, 2};
        int[] arr = {};
//        selectSort(arr);
        headSort(arr);
        for (int i : arr)
            System.out.print(i + "  ");
    }

    // 数组可分为前面的有序数组和后面的无需数组，从后面的无序数组查找最小值，如果比有序数组的最后一个元素小，
    // 则替换。有序数组长度+1，继续遍历。这里可以使用flag记录后面数组是否有序， 如果有序且最小值大于等于有序
    // 数组的最大值，则直接跳出循环。
    // 从头遍历数组
    // 从上层遍历的下一个元素开始寻找最小值的索引，
    // 找到最小值的索引之后，交换元素。
    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int k = i + 1;
            boolean flag = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[k] > arr[j]) {
                    k = j;
                    flag = true;
                }
            }
            if (!flag && arr[i] <= arr[k]) break;
            if (arr[i] > arr[k]) {
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
//            if ((flag && arr[i] > arr[k]) || (!flag && arr[i] > arr[k])) {
//                int temp = arr[i];
//                arr[i] = arr[k];
//                arr[k] = temp;
//            } else if (!flag) break;
        }
    }

    // 堆排序：https://blog.csdn.net/morewindows/article/details/6709644
    // 堆排序被归类为选择排序，是因为其总是选择最大的元素放在后面。
    // 这里只使用堆的建立和下沉操作，时间复杂度O(n*log(n))
    private static void headSort(int[] arr) {
        int n = arr.length;
        if (n < 1) return; // 特殊例子
        // 建立堆
        for (int i = n / 2; i >= 0; i--) {
            maxHeapFixDown(arr, i, n);
        }
        // 堆排序
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            maxHeapFixDown(arr, 0, i);
        }
    }
    // 堆下沉
    private static void maxHeapFixDown(int[] arr, int i, int n) {
        int temp = arr[i], j = 2 * i + 1;
        while (j < n) {
            if (j + 1 < n && arr[j + 1] > arr[j]) j++;
            if (arr[j] <= temp) break;
            arr[i] = arr[j];
            i = j; j = 2 * i + 1;
        }
        arr[i] = temp;
    }
}
