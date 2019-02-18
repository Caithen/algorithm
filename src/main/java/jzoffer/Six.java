package jzoffer;

/**
 * Created by 15501 on 2019/2/10.
 */
public class Six {
    public static void main(String[] args) {
        int[] array = {3,4,5,1,2};
        Six six = new Six();
        System.out.println(six.minNumberInRotateArray(array));
    }
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) return 0;
        int left = 0, right = array.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (array[mid] > array[right]) left = mid + 1;
            else right--;
            System.out.println(mid);
        }
        return array[left];
    }
}
