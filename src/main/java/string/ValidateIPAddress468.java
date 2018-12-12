package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 15501 on 2018/10/18.
 */
public class ValidateIPAddress468 {
    public static void main(String[] args) {
        List<String> tests = new ArrayList<String>();
        tests.add("172.16.254.1");
        tests.add("2001:0db8:85a3:0:0:8A2E:0370:7334");
        tests.add("256.256.256.256");
        tests.add("02001:0db8:85a3:0000:0000:8a2e:0370:7334");
        tests.add("1e1.4.5.6");
        tests.add("2001:0db8:85a3:0:0:8A2E:0370:7334:");
        for (String test : tests)
            System.out.println(validIPAddress(test));
    }

    public static String validIPAddress(String IP) {
        if (IP.length() < 7) return "Neither";
        Boolean hasDot = false;
        for (int i = 0; i < 4 && !hasDot; i++) {
            if (IP.charAt(i) == '.') {;
                hasDot = true;
            }
        }

        if (hasDot) return validIPv4(IP);
        else return validIPv6(IP);
    }

    private static String validIPv4(String IP) {
//        String funcName2 = Thread.currentThread().getStackTrace()[1].getMethodName();
//        System.out.print(funcName2 + " " + IP + " ");
        int fields = 0, n = IP.length(), j = 0;
        for (int i = 0; i < n; i = j) {
            j = i;
            while (j < n && IP.charAt(j) != '.') j++;
            String temp = IP.substring(i, j++);
            if (validIPv4String(temp))
                fields++;
            else return "Neither";
        }
        if (fields == 4 && IP.charAt(IP.length() - 1) != '.') return "IPv4";
        else return "Neither";
    }

    private static Boolean validIPv4String(String str) {
        int n = str.length(), digit = 0;
        if (n == 0 || n > 3) return false;
        for (char c : str.toCharArray()) {
            if (c >= '0' && c <= '9') digit = digit * 10 + c - '0';
            else return false;
        }
        if (digit >= 0 && digit <= 255 && n == String.valueOf(digit).length())
            return true;
        return false;
    }

    private static String validIPv6(String IP) {
//        String funcName2 = Thread.currentThread().getStackTrace()[1].getMethodName();
//        System.out.print(funcName2 + " " + IP + " ");
        int fields = 0, n = IP.length(), j = 0;
        for (int i = 0; i < n; i = j) {
            j = i;
            while (j < n && IP.charAt(j) != ':') j++;
            String temp = IP.substring(i, j++);
            if (validIPv6String(temp))
                fields++;
            else return "Neither";
        }
        if (fields == 8 && IP.charAt(IP.length() - 1) != ':') return "IPv6";
        else return "Neither";
    }

    private static Boolean validIPv6String(String str) {
//        System.out.println(str);
        if (str.equals("") || str.length() > 4) return false;
        for (char c : str.toCharArray()) {
            if ((c >= '0' && c <= '9') ||
                    (c >= 'a' && c <= 'f') ||
                    (c >= 'A' && c <= 'F')) continue;
            else return false;
        }
        return true;
    }
}
