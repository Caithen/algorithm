package string;

/**
 * Created by 15501 on 2019/2/2.
 */
public class ShortestPalindrome214 {
    public static void main(String[] args) {
        System.out.println(shortestPalindrome("aacecaaa"));
        System.out.println(shortestPalindrome("abcd"));
    }

    // 先找到前面最长的回文串
    public static String shortestPalindrome(String s) {
        int i = 0, j = s.length() - 1, end = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++; j--;
            } else {
                i = 0;
                end--;
                j = end;
            }
        }

        return new StringBuffer(s.substring(end + 1)).reverse().toString() + s;
    }
}
