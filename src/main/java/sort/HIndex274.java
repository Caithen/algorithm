package sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by 15501 on 2018/10/23.
 */
public class HIndex274 {
    public static void main(String[] args) {
//        int[] citations = {3,0,6,1,5};
//        int[] citations = {100};
//        int[] citations = {4,4,0,0};
//        int[] citations = {};
        int[] citations = {1, 1, 0};
        System.out.println(hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        int n = citations.length - 1;
        Arrays.sort(citations);
        for (int i = n; i >= 0; i--)
            if (n - i >= citations[i]) return n - i;
        return citations.length;
    }


//    public static int hIndex(int[] citations) {
//        int length = citations.length;
//        int[] counts = new int[length + 1];
//        for (int c : citations) {
//            if (c >= length) counts[length]++;
//            else counts[c]++;
//        }
//        int count = 0;
//        for (int i = length; i >= 0; i--) {
//            count += counts[i];
//            if (count >= i) return i;
//        }
//        return 0;
//    }

    private static void printArray(int[] arr) {
        for (int a : arr)
            System.out.print(a + "  ");
        System.out.println();
    }
}
