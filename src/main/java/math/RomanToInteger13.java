package math;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 2018/12/24.
 */
public class RomanToInteger13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt(""));
    }
    public static int romanToInt(String s) {
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        m.put('I', 1); m.put('V', 5); m.put('X', 10); m.put('L', 50);
        m.put('C', 100); m.put('D', 500); m.put('M', 1000);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1 || m.get(s.charAt(i)) >= m.get(s.charAt(i + 1)))
                res += m.get(s.charAt(i));
            else
                res -= m.get(s.charAt(i));
        }
        return res;
    }
}
