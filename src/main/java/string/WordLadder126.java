package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 15501 on 2018/10/19.
 */
public class WordLadder126 {

    public static void main(String[] args) {
//        String beginWord = "hit", endWord = "cog";
//        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
//        String beginWord = "hot", endWord = "dog";
//        List<String> wordList = Arrays.asList("hot","dog","dot");
        String beginWord = "qa";
        String endWord = "sq";
        List<String> wordList = Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye");
        WordLadder126 wl = new WordLadder126();
        List<List<String>> res = wl.findLadders(beginWord, endWord, wordList);
        for (List<String> r : res) {
            for (String str : r) {
                System.out.print(str + "    ");
            }
            System.out.println(wl.minPath);
        }
    }

    // 下面的方法超时
    int minPath = Integer.MAX_VALUE;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList();
        List<String> out = new ArrayList<String>();
        out.add(beginWord);
        List<String> temp = new ArrayList(wordList);
        temp.remove(beginWord);
        findCore(beginWord, endWord, temp, out, res);
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i).size() > minPath) {
                res.remove(i);
                i--;
            }
        }
        return res;
    }
    private void findCore(String beginWord, String endWord, List<String> wordList, List<String> out, List<List<String>> res) {
        if (out.size() == minPath) return;
        for (String word : wordList) {
            if (isTransformation(beginWord, word)) {
                out.add(word);
                if (word.equals(endWord)) {
                    if (out.size() <= minPath) {
                        minPath = out.size();
                    } else break;
                    res.add(new ArrayList<String>(out));
                } else {
                    List<String> temp = new ArrayList(wordList);
                    temp.remove(word);
                    findCore(word, endWord, temp, new ArrayList<String>(out), res);
                }
                out.remove(word);
            }
        }
    }
    private boolean isTransformation(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int cnt = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) cnt++;
        }
        if (cnt == 1) return true;
        else return false;
    }
}
