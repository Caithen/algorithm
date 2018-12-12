package search;

import java.util.*;

/**
 * Created by 15501 on 2018/12/5.
 */
public class WordLadder126 {
    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        List<List<String>> res = findLadders(beginWord, endWord, wordList);
        for (List<String> r : res) {
            for (String w : r) {
                System.out.print(w + "    ");
            }
            System.out.println();
        }
    }
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<List<String>>();
        Queue<LinkedList<String>> paths = new LinkedList<LinkedList<String>>();
        Set<String> dict = new HashSet<String>(wordList);
        Set<String> words = new HashSet<String>();
        int level = 1, minLevel = Integer.MAX_VALUE;
        LinkedList<String> p = new LinkedList<String>();
        p.add(beginWord); paths.offer(p);
        while (!paths.isEmpty()) {
            LinkedList<String> t = paths.poll();
            if (level < t.size()) {
                for (String word : words) dict.remove(word);
                level = t.size();
                if (level > minLevel) break;
            }
            String last = t.getLast();
            for (int i = 0; i < last.length(); i++) {
                char[] newLast = last.toCharArray();
                for (int j = 0; j < 26; j++) {
                    newLast[i] = (char)('a' + j);
                    String lastTemp = String.valueOf(newLast);
                    if (dict.contains(lastTemp)) {
                        words.add(lastTemp);
                        LinkedList<String> newPath = new LinkedList<String>(t);
                        newPath.add(lastTemp);
                        if (lastTemp.equals(endWord)) {
                            res.add(newPath);
                            minLevel = level;
                        } else paths.add(newPath);
                    }
                }
            }
        }
        return res;
    }
}
