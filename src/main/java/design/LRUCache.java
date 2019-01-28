package design;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 15501 on 2019/1/22.
 * hashmap + 双链表
 */
public class LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);

        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);

        System.out.println(cache.get(2));
//        cache.put(4, 4);
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(3));
//        System.out.println(cache.get(4));

    }
    int count;
    int capacity;
    DLinkedNode head, tail;
    Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
        DLinkedNode(int k, int v) { key = k; value = v;}
    }

    public void add(DLinkedNode node) {

        head.post.pre = node;
        node.post = head.post;

        node.pre = head;
        head.post = node;

    }

    public void remove(DLinkedNode node) {

        node.pre.post = node.post;
        node.post.pre = node.pre;

    }

    public void moveToHead(DLinkedNode node) {

        remove(node);
        add(node);

    }

    public DLinkedNode pop(DLinkedNode tail) {
        DLinkedNode res = tail.pre;
        remove(res);
        return res;
    }

    public LRUCache(int capacity) {

        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode(-1, -1);
        head.pre = null;

        tail = new DLinkedNode(-1, -1);
        tail.post = null;

        head.post = tail;
        tail.pre = head;

    }

    public int get(int key) {

        DLinkedNode node = cache.get(key);

        if (node == null) return -1;

        moveToHead(node);
        return node.value;

    }

    public void put(int key, int value) {
        System.out.println(key + ": " + value);

        DLinkedNode node = cache.get(key);

        if (node == null) {

            DLinkedNode newNode = new DLinkedNode(key, value);

            cache.put(key, newNode);

            add(newNode);

            ++count;

            if (count > capacity) {
                DLinkedNode pop = pop(tail);
                cache.remove(pop.key);
                --count;
            }

        } else {

            node.value = value;
            moveToHead(node);

        }
    }
}
