package array;

/**
 * Created by 15501 on 2018/10/30.
 */
public class TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 0;
        System.out.println(leastInterval(tasks, n));
    }

    public static int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        int max = 0, count = 0;
        for (char t : tasks) counts[t - 'A']++;
        for (int c : counts) {
            if (c > max) {
                max = c;
                count = 1;
            } else if (c == max) {
                count++;
            }
        }
        int len = (max - 1) * (n + 1) + count;
        return Math.max(len, tasks.length);
    }
}
