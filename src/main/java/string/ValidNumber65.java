package string;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by 15501 on 2019/1/5.
 */
public class ValidNumber65 {
    public static void main(String[] args) {
        System.out.println("0" + " :        " + isNumber("0"));
        System.out.println(" 0.1 " + " :    " + isNumber(" 0.1 "));
        System.out.println("abc" + " :      " + isNumber("abc"));
        System.out.println("1 a" + " :      " + isNumber("1 a"));
        System.out.println("2e10" + " :     " + isNumber("2e10"));
        System.out.println(" -90e3   " + ": " + isNumber(" -90e3   "));
        System.out.println(" 1e" + " :      " + isNumber(" 1e"));
        System.out.println("e3" + " :       " + isNumber("e3"));
        System.out.println(" 6e-1" + " :    " + isNumber(" 6e-1"));
        System.out.println(" 99e2.5 " + " : " + isNumber(" 99e2.5 "));
        System.out.println("53.5e93" + " :  " + isNumber("53.5e93"));
        System.out.println(" --6 " + " :    " + isNumber(" --6 "));
        System.out.println("-+3" + " :      " + isNumber("-+3"));
        System.out.println("95a54e53" + " : " + isNumber("95a54e53"));
        System.out.println(" " + " :        " + isNumber(" "));
        System.out.println(".1" + " :       " + isNumber(".1")); // 答案竟然是true，所以要问清楚面试官啊
        System.out.println("..2" + " :      " + isNumber("..2")); // 答案是false
        System.out.println("46.e3" + " :    " + isNumber("46.e3")); // 答案竟然是true，所以也要问清楚面试官啊
        System.out.println(". 1" + " :      " + isNumber(". 1")); // 答案是false
    }

    // 如果另写一个函数专门处理'e'之后得字符，这道题其实并不难啊，
    // 主要是得问清楚面试官一些特殊字符串算不算通过
    public static boolean isNumber(String s) {
        if (s.length() < 1) return false;
        HashSet<Character> validChar = new HashSet<Character>(Arrays.asList(' ', '+', '-', '.', 'e'));
        for (int i = 0; i < 10; i++) validChar.add((char)(i + '0'));
        boolean haveNum = false, haveEmpty = false, haveDot = false, haveSign = false;
        for (int i = 0; i < s.length(); i++) {
            if (validChar.contains(s.charAt(i))) {
                if (s.charAt(i) == ' ') {
                    if (haveNum || haveDot || haveSign) haveEmpty = true;
                } else {
                    if (haveEmpty) return false;
                    else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                        if (haveSign || haveDot || haveNum) return false;
                        else haveSign = true;
                    } else if (s.charAt(i) == '.') {
                        if (haveDot) return false;
                        haveDot = true;
                    } else if (s.charAt(i) == 'e') {
                        if (!haveNum) return false;
                        else return isInteger(s.substring(i + 1));
                    } else haveNum = true;
                }
            } else return false;
        }
        return haveNum;
    }
    private static boolean isInteger(String s) {
        if (s.length() < 1) return false;
        boolean haveNumber = false, haveSign = false, haveEmpty = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (haveNumber) haveEmpty = true;
                else return false;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (haveEmpty || haveSign || haveNumber) return false;
                else haveSign = true;
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                if (haveEmpty) return false;
                else haveNumber = true;
            } else return false;
        }
        return haveNumber;
    }
}
