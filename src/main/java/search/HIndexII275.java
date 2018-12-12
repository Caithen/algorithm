package search;

/**
 * Created by 15501 on 2018/12/10.
 */
public class HIndexII275 {
    public static void main(String[] args) {
        int[] citations = {0,1,3,5,6};
        System.out.println(hIndex(citations));
        citations = new int[] {5, 6};
        System.out.println(hIndex(citations));
        citations = new int[] {1, 1};
        System.out.println(hIndex(citations));
        citations = new int[] {0,0,4,4};
        System.out.println(hIndex(citations));
    }
    public static int hIndex(int[] citations) {
        if (citations.length < 1) return 0;
        int left = 0, right = citations.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (citations[mid] == citations.length - mid) return citations[mid];
            if (citations[mid] < citations.length - mid) left = mid + 1;
            else right = mid - 1;
        }
        return citations.length - left;
    }
}
