package jzoffer;

/**
 * Created by 15501 on 2019/2/10.
 */
public class Nine {
    public static void main(String[] args) {
        Nine nine = new Nine();
        System.out.println(nine.JumpFloorII(3));
    }
    public int JumpFloorII(int target) {
        return (int)Math.pow(2, target - 1);
    }
}
