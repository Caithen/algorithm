package math;

/**
 * Created by user on 2019/1/2.
 */
public class MultiplyStrings43 {
    public static void main(String[] args) {
        String num1 = "2", num2 = "3";
        System.out.println(multiply(num1, num2));
        num1 = "123"; num2 = "456";
        System.out.println(multiply(num1, num2));
        System.out.println(multiply("0", "0"));
    }
    public static String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        int[] dp = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            int c = num1.charAt(i) - '0';
            int carry = 0;
            for (int j = n2 - 1; j >= 0; j--) {
                int temp = c * (num2.charAt(j) - '0');
                temp += dp[i + j + 1] + carry;
                carry = temp / 10;
                dp[i + j + 1] = temp % 10;
            }
            dp[i] = carry;
        }
        int i = 0;
        for (; i < n1 + n2 - 1; i++) if (dp[i] != 0) break;
        String res = "";
        for (; i < n1 + n2; i++) res += String.valueOf(dp[i]);
        return res;
    }
}
