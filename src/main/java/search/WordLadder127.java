package search;

import java.util.*;

/**
 * Created by 15501 on 2018/12/3.
 */
public class WordLadder127 {
    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(ladderLength(beginWord, endWord, wordList));
        beginWord = "hit"; endWord = "cog";
        wordList = Arrays.asList("hot","dot","dog","lot","log");
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
    // 定义返回值level，定义HashSet装wordList，广度优先遍历所需的queue，
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int level = 1;
        Set<String> wordSet = new HashSet<String>(wordList);
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) return level;
                for (int j = 0; j < word.length(); j++) {
                    // 这句一定的在上面for循环的下面，注意单词只改变一个字母
                    char[] newWord = word.toCharArray();
                    for (int k = 0; k < 26; k++) {
                        newWord[j] = (char)('a' + k);
                        String temp = String.valueOf(newWord);
                        // 队列不能加入word本身，temp必须包含在wordSet，一旦temp加入queue，wordSet必须去除word
                        if (wordSet.contains(temp) && temp != word) {
                            queue.offer(temp);
                            wordSet.remove(temp);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
