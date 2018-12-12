package sort;

import java.util.*;

/**
 * Created by 15501 on 2018/10/31.
 */
public class MeetingRoomsII253 {
    public static void main(String[] args) {
//        List<Interval> intervals = new ArrayList<Interval>(Arrays.asList(new Interval(0, 30), new Interval(5, 10), new Interval(15, 20)));
//        List<Interval> intervals = new ArrayList<Interval>();
//        List<Interval> intervals = new ArrayList<Interval>(Arrays.asList(new Interval(0, 30)));
        List<Interval> intervals = new ArrayList<Interval>(Arrays.asList(new Interval(20, 30), new Interval(5, 10), new Interval(15, 20)));
        System.out.println(minMeetingRooms(intervals));
    }

    // 安排会议真实过程：
    // 首先将会议按起始时间排序
    // 安排第一个会议，当下一个会议来了的时候，
    // 看一看之前已经开始的会议中结束时间最早的是否已经结束，
    // 如果没结束则新开个房间，如果结束了，则在原房间安排这个新会议。
    // 现在用最小堆来模拟这一过程：
    // 新开房间就是把会议结束时间加入最小堆，
    // 在原房间安排新会议就是删除堆顶元素，然后把新会议结束时间加入最小堆。
//    public static int minMeetingRooms(List<Interval> intervals) {
//        Collections.sort(intervals, new Comparator<Interval>() {
//            public int compare(Interval interval, Interval t1) {
//                return interval.start - t1.start;
//            }
//        });
//        Queue<Integer> queue = new PriorityQueue<Integer>();
//        for (Interval interval : intervals) {
//            if (queue.isEmpty() || interval.start < queue.peek())
//                queue.offer(interval.end);
//            else {
//                queue.poll();
//                queue.offer(interval.end);
//            }
//        }
//        return queue.size();
//    }

    // 使用两个数组start, end 分别记录intervals 的开始和结束
    // 这里有个知识点：
    // start, end经排序后形成的intervals，intervals的交集数量不变
//    public static int minMeetingRooms(List<Interval> intervals) {
//        int n = intervals.size();
//        if (n < 2) return n;
//        int[] starts = new int[n], ends = new int[n];
//        for (int i = 0; i < n; i++) {
//            Interval interval = intervals.get(i);
//            starts[i] = interval.start;
//            ends[i] = interval.end;
//        }
////        Arrays.sort(starts); Arrays.sort(ends);
////        printArray(starts); printArray(ends);
//        int res = 0, endpos = 0;
//        for (int i = 0; i < n; i++) {
//            if (starts[i] < ends[endpos]) res++;
//            else endpos++;
//        }
//        return res;
//    }

    // 下面的解法和使用双指针解法的思想是类似的，
    // 这里将会议的开始时间和结束时间混合排序，
    // 寻找排序数组中连续开始点的最大个数。
    public static int minMeetingRooms(List<Interval> intervals) {
        Map<Integer, Integer> m = new TreeMap<Integer, Integer>();
        for (Interval interval : intervals) {
            if (m.containsKey(interval.start)) m.put(interval.start, m.get(interval.start) + 1);
            else m.put(interval.start, 1);
            if (m.containsKey(interval.end)) m.put(interval.end, m.get(interval.end) - 1);
            else m.put(interval.end, -1);
        }
        int res = 0, rooms = 0;
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            res = Math.max(res, rooms += entry.getValue());
        }
        return res;
    }
    public static void printArray(int[] arr) {
        for (int a : arr)
            System.out.print(a + "  ");
        System.out.println();
    }
}
