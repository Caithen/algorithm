package array;

/**
 * Created by user on 2019/1/3.
 */
public class test {
    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 9, 0};
        String key = "";
        for (int num : nums) key += "#" + num;
        System.out.println(key);
        nums = new int[]{1, 2, 0, 9, 0};
        key = "";
        for (int num : nums) key += "#" + num;
        System.out.println(key);
    }
}
