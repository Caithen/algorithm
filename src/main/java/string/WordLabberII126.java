package string;

import java.util.*;

/**
 * Created by user on 2019/1/11.
 */
public class WordLabberII126 {

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        for (List<String> r : findLadders(beginWord, endWord, wordList)) {
            for (String s : r) System.out.print(s + ", ");
            System.out.println();
        }
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> res = new ArrayList();

        Set<String> wordDict = new HashSet(wordList);
        wordDict.remove(beginWord);

        Queue<List<String>> queue = new LinkedList();
        List<String> path = new ArrayList();
        path.add(beginWord);
        queue.offer(path);

        int minLevel = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {

            int size = queue.size();

            Set<String> used = new HashSet();

            for (int i = 0; i < size; i++) {

                path = queue.poll();

                if (path.size() == minLevel) break;

                String s = path.get(path.size() - 1);


                for (int j = 0; j < s.length(); j++) {

                    char[] array = s.toCharArray();

                    for (int k = 0; k < 26; k++) {

                        if (array[j] == (char)(k + 'a')) continue;

                        array[j] = (char)(k + 'a');

                        String snext = String.valueOf(array);

                        if (wordDict.contains(snext)) {

                            List<String> pathTemp = new ArrayList(path);
                            pathTemp.add(snext);
                            used.add(snext);

                            if (snext.equals(endWord)) {

                                minLevel = pathTemp.size();
                                res.add(pathTemp);

                            } else queue.add(pathTemp);

                        }

                    }
                }

            }

            for (String word : used) wordDict.remove(word);

        }


        return res;


    }
}
