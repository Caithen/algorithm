package sort.summary;

/**
 * Created by 15501 on 2018/10/21.
 */
public class SwapSort {
    public static void main(String[] args) {
//        int[] arr = {1, 3, 2, 5, 4, 0, 100, 99, 80, 70, 83, 6, 5, 3, 4, 2, 1, 0, 98, 87, 76, 65, 45, 34, 21};
//        int[] arr = {1, 3, 2};
//        int[] arr = {3, 1, 2, 5};
        int[] arr = {};
        bubbleSort(arr);
//        QuickSort(arr);
        for (int i : arr)
            System.out.print(i + "  ");
    }

    // 小数上浮，大数下沉。从后往前遍历，倒序交换元素。
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    // 选择基准元素，选择开始或结尾，通过一次扫描，将待排序列分成两部分，一部分比基准元素小，一部分大于等于基准元素
    // 如果比基准大则需要位于右边，如果比基准小则需要位于左边。
    // 快排比较特殊，需要三个输入参数。
    private static void QuickSort(int[] arr) {
        int start = 0, end = arr.length - 1;
        quickSort(arr, start, end);
    }
    private static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = partition(arr, start, end);
            quickSort(arr, start, mid - 1);
            quickSort(arr, mid + 1, end);
        }
    }
    // right移动，则表明left位置元素已被搬运成为坑；
    // left移动，则表明right位置已被搬运成为坑。
    private static int partition(int[] arr, int start, int end) {
        int left = start, right = end, temp = arr[start];
        // 为确保left和right不超出数组范围，则需保证left < right。
        while (left < right) {
            // arr[right] = temp时， 为减少搬运次数，则继续移动right指针
            while (left < right && arr[right] >= temp) right--;
            if(left < right) arr[left++] = arr[right];
            while (left < right && arr[left] < temp) left++;
            if (left < right) arr[right--] = arr[left];
        }
        arr[left] = temp;
        return left;
    }
}
