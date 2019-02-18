package design;

import java.util.PriorityQueue;

/**
 * Created by 15501 on 2019/2/9.
 */
class MedianFinder {

    PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> right = new PriorityQueue<>();

    public MedianFinder() {}

    public void addNum(int x) {
        // insert
        if (left.isEmpty() || x <= left.peek()) {
            left.offer(x);
        } else {
            right.offer(x);
        }
        // balancing
        if (left.size() < right.size()) {
            left.offer(right.poll());
        } else if (left.size() - right.size() == 2) {
            right.offer(left.poll());
        }
    }

    public double findMedian() {
        if (left.size() > right.size()) {
            return left.peek();
        } else {
            return ((double) (left.peek() + right.peek())) / 2;
        }
    }
}
