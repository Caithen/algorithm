package sort;

import java.util.*;

/**
 * Created by 15501 on 2018/10/24.
 */
public class MergeIntervals56 {

    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(new Interval(1,3),new Interval(2,6), new Interval(8,10),new Interval(15,18));
//        List<Interval> intervals = Arrays.asList(new Interval(1,4),new Interval(4,5));
//        List<Interval> intervals = Arrays.asList(new Interval(1, 4), new Interval(0, 4));
//        List<Interval> intervals = Arrays.asList(new Interval(1, 4), new Interval(0, 3));
//        List<Interval> intervals = Arrays.asList(new Interval(1, 4), new Interval(0, 0));
//        List<Interval> intervals = Arrays.asList(new Interval(1, 4), new Interval(0, 0), new Interval(5, 7), new Interval(4, 6), new Interval(0, 1));
        List<Interval> res = merge(intervals);
        System.out.print("[");
        for (Interval r : res) {
            System.out.print("[" + r.start + "," + r.end + "],");
        }
        System.out.println("]");
    }

    // 直接利用InsertInterval57中的insert函数，运行时间最短
    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        for (Interval interval : intervals) {
            res = InsertInterval57.insert(res, interval);
        }
        return res;
    }

    // starts:    1    2    8    15
    // ends:     3    6    10    18
    // 红色为i的位置，蓝色为j的位置，那么此时starts[i+1]为8，ends[i]为6，8大于6，所以此时不连续了，
    // 将区间[starts[j], ends[i]]，即 [1, 6] 加入结果res中，然后j赋值为i+1继续循环
    // 运行时间次之
//    public static List<Interval> merge(List<Interval> intervals) {
//        int n = intervals.size();
//        if (n < 2) return intervals;
//        List<Interval> res = new ArrayList<Interval>();
//        int[] starts = new int[n], ends = new int[n];
//        for (int i = 0; i < intervals.size(); i++) {
//            starts[i] = intervals.get(i).start;
//            ends[i] = intervals.get(i).end;
//        }
//        Arrays.sort(starts); Arrays.sort(ends);
//        for (int i = 0, j = 0; i < n; i++) {
//            if (i == n - 1 || starts[i + 1] > ends[i]) {
//                res.add(new Interval(starts[j], ends[i]));
//                j = i + 1;
//            }
//        }
//        return res;
//    }
      // 运行时间最长
//    public static List<Interval> merge(List<Interval> intervals) {
//        List<Interval> res = new ArrayList<Interval>();
//        if (intervals.size() < 1) return res;
//        Collections.sort(intervals, new Comparator<Interval>() {
//            public int compare(Interval t0, Interval t1) {
//                return t0.start - t1.start;
//            }
//        });
//        Interval newInterval = intervals.get(0);
//        for (int i = 1; i < intervals.size(); i++) {
//            if (intervals.get(i).start > newInterval.end) {
//                res.add(newInterval);
//                newInterval = intervals.get(i);
//            }
//            else {
//                newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
//            }
//        }
//        res.add(newInterval);
//        return res;
//    }
}

