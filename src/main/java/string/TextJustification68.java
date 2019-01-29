package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 15501 on 2019/1/5.
 */
public class TextJustification68 {
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        for (String r : fullJustify(words, 16)) System.out.println(r);
        words = new String[]{"What","must","be","acknowledgment","shall","be"};
        for (String r : fullJustify(words, 16)) System.out.println(r);
        words = new String[]{"Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do"};
        for (String r : fullJustify(words, 20)) System.out.println(r);
    }
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        if (words.length < 1) return res;
        List<String> wordList = new ArrayList<String>();
        int len = 0;
        for (String word : words) {
            len += word.length() + 1;
            if (len > maxWidth + 1) {
                res.add(concatenate(wordList, maxWidth));
                wordList.clear();
                len = word.length() + 1;
            }
            wordList.add(word);
        }
        if (len == maxWidth + 1) res.add(concatenate(wordList, maxWidth));
        else {
            String temp = "";
            for (String word : wordList) {
                temp += word + " ";
            }
            for (int j = 0; j < maxWidth - len; j++) temp += " ";
            res.add(temp);
        }
        return res;
    }
    private static String concatenate(List<String> wordList, int maxWidth) {
        int n = wordList.size(), len = 0;
        String res = "";
        if (n < 1) return res;
        if (n == 1) {
            res += wordList.get(0);
            for (int j = 0; j < maxWidth - wordList.get(0).length(); j++) res += " ";
            return res;
        }
        for (String word : wordList) len += word.length();
        int div = (maxWidth - len) / (n - 1), mod = (maxWidth - len) % (n - 1);
        int i = 0;
        while (mod-- > 0 && i < n - 1) {
            res += wordList.get(i++);
            for (int j = 0; j < div + 1; j++) res += " ";
        }
        while (i < n - 1) {
            res += wordList.get(i++);
            for (int j = 0; j < div; j++) res += " ";
        }
        res += wordList.get(i);
        return res;
    }
}
