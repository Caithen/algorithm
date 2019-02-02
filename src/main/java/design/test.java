package design;

/**
 * Created by 15501 on 2019/2/1.
 */
public class test {
    public static void main(String[] args) {
//        Trie trie = new Trie();
//        trie.insert("apple");
//        System.out.println(trie.search("apple"));
//        System.out.println(trie.search("app"));
//        System.out.println(trie.startsWith("app"));
//        trie.insert("app");
//        System.out.println(trie.search("app"));

        WordDictionary wordDict = new WordDictionary();
        wordDict.addWord("bad");
        wordDict.addWord("dad");
        wordDict.addWord("mad");
        System.out.println(wordDict.search("pad"));
        System.out.println(wordDict.search("bad"));
        System.out.println(wordDict.search(".ad"));
        System.out.println(wordDict.search("b.."));
    }
}
