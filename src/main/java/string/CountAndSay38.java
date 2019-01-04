package string;

/**
 * Created by user on 2019/1/2.
 */
public class CountAndSay38 {
    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
    }
    public static String countAndSay(int n) {
        String res = "1";
        if (n == 1) return res;
        int count, i = 1;
        for (; i < n; i++) {
            String temp = "";
            char say = res.charAt(0);
            count = 0;
            for (int j = 0; j < res.length(); j++) {
                if (res.charAt(j) == say) count++;
                if (res.charAt(j) != say) {
                    temp += (char)(count + '0') + "" + say;
                    say = res.charAt(j);
                    count = 1;
                }
                if (j == res.length() - 1) {
                    temp += (char)(count + '0') + "" + say;
                }
            }
            res = temp;
        }
        return res;
    }
}
