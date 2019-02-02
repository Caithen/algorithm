package design;

/**
 * Created by 15501 on 2019/2/2.
 * 211
 */
class WordDictionary {

    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int j = c - 'a';
            if (node.children[j] == null) {
                node.children[j] = new TrieNode();
            }
            node = node.children[j];
        }
        node.isWord = true;
        node.word = word;
    }

    private boolean check(String word, int index, TrieNode node) {
        if (index == word.length()) return node.isWord;
        char c = word.charAt(index);
        if (c != '.') {
            return node.children[c - 'a'] != null && check(word, index + 1, node.children[c - 'a']);
        } else {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    if (check(word, index + 1, node.children[i])) return true;
                }
            }
        }
        return false;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word.length() < 1) return true;
        return check(word, 0, root);
    }
}
