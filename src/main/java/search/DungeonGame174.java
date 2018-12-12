package search;

/**
 * Created by 15501 on 2018/12/8.
 */
public class DungeonGame174 {
    public static void main(String[] args) {
        int[][] dungeon = {{-2,-3,3}, {-5,-10,1}, {10,30,-5}};
        System.out.println(calculateMinimumHP(dungeon));
        dungeon = new int[][] {{0,0}};
        System.out.println(calculateMinimumHP(dungeon));
        dungeon = new int[][] {{2},{1}};
        System.out.println(calculateMinimumHP(dungeon));
        dungeon = new int[][] {{0,0,0},{1,1,-1}};
        System.out.println(calculateMinimumHP(dungeon));
        dungeon = new int[][] {{1,-3,3},{0,-2,0},{-3,-3,-3}};
        System.out.println(calculateMinimumHP(dungeon));
    }

    // 逆向思维，边界值确定准
    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        if (m < 1) return 1;
        int n = dungeon[0].length;
        int[] nums = new int[n + 1];
        for (int i = 0; i < n + 1; i++) nums[i] = Integer.MAX_VALUE;
        nums[n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                nums[j] = Math.max(1, Math.min(nums[j], nums[j + 1]) - dungeon[i][j]);
            }
        }
        return nums[0];
    }
    public static void printArray(int[] array) {
        for (int a : array) System.out.print(a + ", ");
        System.out.println();
    }
}
