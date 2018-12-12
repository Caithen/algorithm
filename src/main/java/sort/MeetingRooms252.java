package sort;

import java.util.*;

/**
 * Created by 15501 on 2018/10/31.
 */
public class MeetingRooms252 {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<Interval>(Arrays.asList(new Interval(0, 30), new Interval(5, 10), new Interval(15, 20)));
        System.out.println(canAttendMeetings(intervals));
    }
    public static boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() < 2) return true;
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval interval, Interval t1) {
                return interval.start - t1.start;
            }
        });
        for (int i = 0; i < intervals.size() - 1; i++) {
            System.out.print("(" + intervals.get(i).start + "," + intervals.get(i).end + ") ");
            if (intervals.get(i + 1).start >= intervals.get(i).end) return false;
        }
        return true;
    }
}


