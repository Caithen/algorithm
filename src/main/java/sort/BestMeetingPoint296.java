package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by 15501 on 2018/11/1.
 */
public class BestMeetingPoint296 {
    public static void main(String[] args) {
        int[][] grid = {{1,0,0,0,1}, {0,0,0,0,0}, {0,0,1,0,0}};
        System.out.print(minTotalDistance(grid));
    }

    // 这里有一个规律：
    // 先探讨grid为一维式，最短总距离。
    // 然后一维扩展到二维，其实就是行列两个一维最短总距离的和。
    // 步骤：统计，排序，求和
    public static int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<Integer>(), cols = new ArrayList<Integer>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
//        Collections.sort(cols);
//        int res = 0, i = 0, j = rows.size() - 1;
//        while (i < j) res += rows.get(j) - rows.get(i) + cols.get(j--) - cols.get(i++);
        int res = minTotalDistance(rows) + minTotalDistance(cols);
        return res;
    }
    public static int minTotalDistance(List<Integer> list) {
        Collections.sort(list);
        int res = 0, i = 0, j = list.size() - 1;
        while (i < j) res += list.get(j--) - list.get(i++);
        return res;
    }
}
