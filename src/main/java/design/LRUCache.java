package design;

import java.util.HashMap;
<<<<<<< HEAD
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by user on 2019/1/21.
 */
public class LRUCache {
    public static void main(String[] args) {

    }
=======
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
>>>>>>> 0805e201baa510a9ff51d08aa99b2f50f95c143f

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
<<<<<<< HEAD
    }

    /**
     * Always add the new node right after head;
     */
    private void addNode(DLinkedNode node){
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(DLinkedNode node){
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(DLinkedNode node){
        this.removeNode(node);
        this.addNode(node);
    }

    // pop the current tail.
    private DLinkedNode popTail(){
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    private Hashtable<Integer, DLinkedNode>
            cache = new Hashtable<Integer, DLinkedNode>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
=======
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
>>>>>>> 0805e201baa510a9ff51d08aa99b2f50f95c143f
        tail.post = null;

        head.post = tail;
        tail.pre = head;
<<<<<<< HEAD
=======

>>>>>>> 0805e201baa510a9ff51d08aa99b2f50f95c143f
    }

    public int get(int key) {

        DLinkedNode node = cache.get(key);
<<<<<<< HEAD
        if(node == null){
            return -1; // should raise exception here.
        }

        // move the accessed node to the head;
        this.moveToHead(node);

        return node.value;
    }


    public void set(int key, int value) {
        DLinkedNode node = cache.get(key);

        if(node == null){

            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);

            ++count;

            if(count > capacity){
                // pop the tail
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        }else{
            // update the value.
            node.value = value;
            this.moveToHead(node);
        }

    }

=======

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
>>>>>>> 0805e201baa510a9ff51d08aa99b2f50f95c143f
}
