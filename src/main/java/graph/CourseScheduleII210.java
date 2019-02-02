package graph;

import java.util.*;

/**
 * Created by 15501 on 2019/2/2.
 *
 */
public class CourseScheduleII210 {
    public static void main(String[] args) {
        int[][] prerequisities = {{1, 0}};
        int numCourses = 2;
        for (int r : findOrder(numCourses, prerequisities)) System.out.print(r + ", ");
        System.out.println();
        prerequisities = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        numCourses = 4;
        for (int r : findOrder(numCourses, prerequisities)) System.out.print(r + ", ");
        System.out.println();
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        // construct graph
        Map<Integer, List<Integer>> graph = new HashMap();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<Integer>());
        }

        // record indegree
        int[] in = new int[numCourses];

        for (int[] pair : prerequisites) {
            int head = pair[1], tail = pair[0];
            graph.get(head).add(tail);
            in[tail]++;
        }

        List<Integer> res = new ArrayList();
        Queue<Integer> queue = new LinkedList();

        // add node which indegree equal 0
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) queue.offer(i);
        }

        // tuopu sort
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);
            for (int i : graph.get(node)) {
                in[i]--;
                if (in[i] == 0) queue.add(i);
            }
        }

        // detect circle
        for (int i : in) {
            if (i != 0)
                return new int[0];
        }

        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ans[i] = res.get(i);
        }


        return ans;
    }
}
