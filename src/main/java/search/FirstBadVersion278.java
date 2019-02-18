package search;

/**
 * Created by 15501 on 2019/2/8.
 */
public class FirstBadVersion278 {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }
    public static int firstBadVersion(int n) {
        int left = 0, right = n, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (isBadVersion(mid)) right = mid - 1;
            else left = mid + 1;
        }
        return right + 1;
    }

    static int badVersion = 4;
    private static boolean isBadVersion(int n) {
        if (n >= badVersion) return true;
        else return false;
    }
}
