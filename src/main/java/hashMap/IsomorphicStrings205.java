package hashMap;

/**
 * Created by 15501 on 2019/1/29.
 */
public class IsomorphicStrings205 {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
    }
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] sIndex = new int[128], tIndex = new int[128];
        for (int i = 0; i < s.length(); i++) {
            int sc = s.charAt(i), tc = t.charAt(i);
            if (sIndex[sc] != tIndex[tc]) return false;
            sIndex[sc] = i + 1;
            tIndex[tc] = i + 1;
        }
        return true;
    }
}
