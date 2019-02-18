package design;

import java.util.Stack;

/**
 * Created by 15501 on 2019/2/5.
 * 232
 */
class MyQueue {

    Stack<Integer> left, right;

    public MyQueue() {
        left = new Stack<Integer>();
        right = new Stack<Integer>();
    }

    public void push(int x) {
        left.push(x);
    }

    public int pop() {
        if (right.isEmpty()) {
            while (!left.isEmpty()) right.push(left.pop());
        }
        return right.pop();
    }

    public int peek() {
        if (right.isEmpty()) {
            while (!left.isEmpty()) right.push(left.pop());
        }
        return right.peek();
    }

    public boolean empty() {
        return left.isEmpty() && right.isEmpty();
    }
}
