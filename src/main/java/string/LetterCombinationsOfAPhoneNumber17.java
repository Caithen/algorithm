package string;

import java.util.*;

/**
 * Created by user on 2018/12/25.
 */
public class LetterCombinationsOfAPhoneNumber17 {
    public static void main(String[] args) {
        String digits = "23";
        for (String r : letterCombinations(digits)) System.out.print(r + "  ");
        System.out.println();
        for (String r : letterCombinations("11111")) System.out.print(r + "  ");
        System.out.println();
        for (String r : letterCombinations("2222")) System.out.print(r + "  ");
        System.out.println();
        for (String r : letterCombinations("")) System.out.print(r + "  ");
        System.out.println();
    }

    public static List<String> letterCombinations(String digits) {
        char[][] array = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        List<String> res = new ArrayList<String>();
        helper(digits, 0, "", res, array);
        return res;
    }
    private static void helper(String digits, int index, String combine, List<String> res, char[][] array) {
        if (index == digits.length()) {
            // 一定要有这一句啊
            if (combine == "") return;
            res.add(combine); return;
        }
        int num = digits.charAt(index) - '2';
        if (num >=0 && num <= 7) {
            for (char c : array[num])
                helper(digits, index+1, combine+c, res, array);
        }
    }

//    public static List<String> letterCombinations(String digits) {
//        Map<Character, List<Character>> m = new HashMap<Character, List<Character>>();
//        m.put('2', Arrays.asList('a', 'b', 'c')); m.put('3', Arrays.asList('d', 'e', 'f'));
//        m.put('4', Arrays.asList('g', 'h', 'i')); m.put('5', Arrays.asList('j', 'k', 'l'));
//        m.put('6', Arrays.asList('m', 'n', 'o')); m.put('7', Arrays.asList('p', 'q', 'r', 's'));
//        m.put('8', Arrays.asList('t', 'u', 'v')); m.put('9', Arrays.asList('w', 'x', 'y', 'z'));
//        List<String> res = new ArrayList<String>();
//        helper(digits, 0, "", res, m);
//        return res;
//    }
//    private static void helper(String digits, int index, String combine, List<String> res, Map<Character, List<Character>> m) {
//        if (index == digits.length()) {
//            // 注意：返回列表不能包含空字符串
//            if (combine == "") return;
//            res.add(combine); return;
//        }
//        for (char c : m.getOrDefault(digits.charAt(index), new ArrayList<Character>())) {
//            helper(digits, index + 1, combine + c, res, m);
//        }
//    }
}
