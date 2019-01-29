package greedy;

/**
 * Created by user on 2019/1/16.
 */
public class GasStation134 {
    public static void main(String[] args) {
        int[] gas  = {1,2,3,4,5}, cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    // 这里start必须等于0
    private static int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, total = 0, sum = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        return total < 0 ? -1 : start;
    }
}
