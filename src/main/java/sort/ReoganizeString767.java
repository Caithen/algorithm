package sort;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by 15501 on 2018/10/30.
 */
public class ReoganizeString767 {
    public static void main(String[] args) {
        String[] tests = {"aab", "aaab", "vvvlo"};
        for (String test : tests) {
            System.out.println(reorganizeString(test));
        }
    }

    // 字符串中字母计数
    // 创建堆，并向堆中
    public static String reorganizeString(String S) {
        String res = "";
        if (S.length() < 2) return res;
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        for (char c : S.toCharArray()) {
            if (m.containsKey(c)) m.put(c, m.get(c) + 1);
            else m.put(c, 1);
        }
        Queue<Pair> queue = new PriorityQueue<Pair>();
        for (Map.Entry<Character, Integer> entry : m.entrySet()) {
            if (entry.getValue() > (S.length() + 1) / 2) return res;
            queue.offer(new Pair(entry.getKey(), entry.getValue()));
        }
//        while (!queue.isEmpty()) {
//            Pair pair = queue.poll();
//            System.out.println(pair.getKey() + "    " + pair.getValue());
//        }
        while (queue.size() > 1) {
            Pair pair1 = queue.poll(), pair2 = queue.poll();
            res += pair1.getKey() + "" + pair2.getKey();
            pair1.subsub(); pair2.subsub();
            if (pair1.getValue() > 0) queue.offer(pair1);
            if (pair2.getValue() > 0) queue.offer(pair2);
        }
        if (!queue.isEmpty()) res += queue.poll().getKey();
        return res;
    }
}
