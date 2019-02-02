package design;

/**
 * Created by 15501 on 2019/2/1.
 * 需要先定义 字典树的节点类
 */

class TrieNode {
    TrieNode[] children;
    boolean isWord;
    String word;
    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
        word = "";
    }
}

public class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
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

    public boolean search(String word) {
        TrieNode node = find(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String word) {
        return find(word) != null;
    }

    private TrieNode find(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int j = c - 'a';
            if (node.children[j] == null) return null;
            node = node.children[j];
        }
        return node;
    }
}
