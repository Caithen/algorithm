package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 15501 on 2018/10/24.
 */
public class InsertInterval57 {
    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(new Interval(1,2),new Interval(3, 5),
                new Interval(6,7),new Interval(8,10),new Interval(12,16));
        Interval newInterval = new Interval(4,8);
        List<Interval> res = insert(intervals, newInterval);
        System.out.print("[");
        for (Interval r : res) {
            System.out.print("[" + r.start + "," + r.end + "],");
        }
        System.out.println("]");
    }

    // 涉及interval数据结构的有四道题：insert interval, merge intervals, meeting rooms, meeting rooms II
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        int cur = 0;
        while (cur < intervals.size() && intervals.get(cur).end < newInterval.start)
            res.add(intervals.get(cur++));
        while (cur < intervals.size() && intervals.get(cur).start <= newInterval.end) {
            newInterval.start = Math.min(intervals.get(cur).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(cur).end, newInterval.end);
            cur++;
        }
        res.add(newInterval);
        while (cur < intervals.size()) res.add(intervals.get(cur++));
        return res;
    }
}
