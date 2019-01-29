package string;

/**
 * Created by user on 2019/1/8.
 */
public class ScambleString87 {
    public static void main(String[] args) {
        String s1 = "great", s2 = "rgeat";
        System.out.println(isScramble(s1, s2));
        s1 = "great"; s2 = "rgtae";
        System.out.println(isScramble(s1, s2));
    }
    public static boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        int[] letters = new int[128];
        for (char c : s1.toCharArray()) letters[c]++;
        for (char c : s2.toCharArray()) if (--letters[c] < 0) return false;
        int n = s1.length();
        for (int i = 1; i < n; i++) {
            String s11 = s1.substring(0, i), s12 = s1.substring(i);
            String s21 = s2.substring(0, i), s22 = s2.substring(i);
            if (isScramble(s11, s21) && isScramble(s12, s22)) return true;
            s21 = s2.substring(n - i); s22 = s2.substring(0, n - i);
            if (isScramble(s11, s21) && isScramble(s12, s22)) return true;
        }
        return false;
    }
}
