package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2019/1/8.
 */
public class RestoreIPAddresses93 {
    public static void main(String[] args) {
        for (String r : restoreIpAddresses("25525511135")) {
            System.out.println(r);
        }
    }
    public static List<String> restoreIpAddresses(String s) {
        int level = 4;
        List<String> res = new ArrayList();
        if (s.length() < level) return res;
        String temp = "";
        restoreIpAddresses(s, level, temp, res);
        return res;
    }
    private static void restoreIpAddresses(String s, int level, String temp, List<String> res) {
        if (s.length() < level || level < 0) return;
        if (level == 0 && s.length() == 0) {
            res.add(temp.substring(0, temp.length() - 1));
            return;
        }
        for (int i = 1; i < 4 && i <= s.length(); i++) {
            String str = s.substring(0, i);
            if (isValid(str)) {
                restoreIpAddresses(s.substring(i), level - 1, temp + str + ".", res);
            }
        }
    }
    private static boolean isValid(String str) {
        if (str.length() > 1 && str.charAt(0) == '0') return false;
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i) - '0';
            num = num * 10 + c;
        }
        if (num >= 0 && num <= 255) return true;
        return false;
    }
}
