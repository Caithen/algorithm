package sort.summary;

/**
 * Created by 15501 on 2018/10/21.
 */
public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = {1, 3, 2, 5, 4, 0, 100, 99, 80, 70, 83, 6, 5, 3, 4, 2, 1, 0, 98, 87, 76, 65, 45, 34, 21};
//        int[] arr = {1, 3, 2};
        int[] arr = {};
        straightInsertSort(arr);
        binarySearchInsertSort(arr);
        shellSort(arr);
        for (int i : arr)
            System.out.print(i + "  ");
    }

    // 假设数组第一个位置是有序的
    // 从第二个位置开始遍历数组中的元素temp = arr[i]
    // 从i - 1位置开始往前遍历有序数组寻找temp应该在的位置，同时后移元素
    // 找到之后，将此位置元素设为temp
    private static void straightInsertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) arr[j + 1] = arr[j--];
            arr[j + 1] = temp; // 此赋值必须在for循环之外，因为j有可能等于-1
        }
    }

    // 二分插入排序是指使用二分法查找temp应该在的位置，但找到之后依旧需要移动元素，
    // 所以时间复杂度并没有减少，反而多了查找操作。
    private static void binarySearchInsertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i], left = 0, right = i - 1, mid = right / 2;
            // 因为arr[i]可能大于前面所有的值时， 所以需要left跳出比较范围，即循环条件需要带等号，left <= right
            // 如果left < right，那么left最大只能到达right，不能跳出比较范围。
            // 因为left <= right，所以不能出现left = mid或者right = mid，否则陷入死循环。
            // 综上所述二分查找的循环条件时left <= right。
            while (left <= right) {
                if (arr[mid] < temp) left = mid + 1;
                else right = mid - 1;
                mid = (left + right) / 2;
            }
            int j = i;
            for (; j > left; j--)
                arr[j] = arr[j - 1];
            arr[j] = temp;
        }
    }

    // 希尔排序，实质上发现一种排序的规律。
    // 对数组进行分组，相距为distance的数字为一组，对每组进行插入排序。
    // 之后distance减半，继续进行分组插入排序。
    private static void shellSort(int[] arr) {
        for (int distance = arr.length / 2; distance > 0; distance /= 2) {
            for (int i = distance; i < arr.length; i++) {
                int temp = arr[i], j = i - distance;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + distance] = arr[j];
                    j -= distance;
                }
                arr[j + distance] = temp;
            }
        }
    }
}
