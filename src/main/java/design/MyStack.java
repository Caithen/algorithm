package design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by 15501 on 2019/2/3.
 */
class MyStack {

    Queue<Integer> left, right;
    int top;

    public MyStack() {
        left = new LinkedList<Integer>();
        right = new LinkedList<Integer>();
    }

    public void push(int x) {
        left.offer(x);
        top = x;
    }

    public int pop() {
        while (left.size() > 1) {
            top = left.poll();
            right.offer(top);
        }
        Queue<Integer> temp = right;
        right = left;
        left = temp;
        return right.poll();
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return left.isEmpty() && right.isEmpty();
    }

}
