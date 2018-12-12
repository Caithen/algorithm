package sort;

import java.util.*;

/**
 * Created by 15501 on 2018/10/26.
 */
public class LongestWordInDictionary720 {
    public static void main(String[] args) {
        String[] words = {"w","wo","wor","worl", "world"};
//        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(longestWord(words));
    }

    // 这种解法反而慢一些，这中解法没有重复比较，需要遍历完数组中所有元素
    public static String longestWord(String[] words) {
        Set<String> wordsSet = new HashSet<String>();
        Arrays.sort(words);
        String res = "";
        for (String word : words) {
            if (wordsSet.contains(word.substring(0, word.length() - 1)) || word.length() == 1) {
                wordsSet.add(word);
                res = res.length() < word.length() ? word : res;
            }
        }
        return res;
    }

//    // 通过对字符串按长度和字母表顺序排序，然后挑选出第一个符合条件的字符串。
//    // 这种解法存在重复比较。
//    public static String longestWord(String[] words) {
//        List<String> wordsList = new ArrayList<String>();
//        Set<String> wordsSet = new HashSet<String>();
//        for (String word : words) {
//            wordsList.add(word);
//            wordsSet.add(word);
//        }
//        Collections.sort(wordsList, new Comparator<String>() {
//            public int compare(String s, String t1) {
//                if (s.length() == t1.length()) {
//                    return s.compareTo(t1);
//                } else {
//                    return s.length() < t1.length() ? 1 : -1;
//                }
//            }
//        });
//        for (String word : wordsList) {
////            System.out.println(word);
//            if (isValid(word, wordsSet) || word.length() == 1) return word;
//        }
//        return "";
//    }
//    private static boolean isValid(String word, Set<String> wordsSet) {
//        for (int i = word.length() - 1; i > 0; i--) {
//            if (!wordsSet.contains(word.substring(0, i))) return false;
//        }
//        return true;
//    }
}
