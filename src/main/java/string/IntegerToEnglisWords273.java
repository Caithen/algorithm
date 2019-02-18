package string;

/**
 * Created by 15501 on 2019/2/7.
 */
public class IntegerToEnglisWords273 {
    public static void main(String[] args) {
        System.out.println(numberToWords(123));
        System.out.println(numberToWords(12345));
        System.out.println(numberToWords(1234567));
        System.out.println(numberToWords(1234567891));
    }
    public static String numberToWords(int num) {
        String res = convertHundred(num % 1000);
        String[] vec = {"Thousand", "Million", "Billion"};
        for (int i = 0; i < 3; i++) {
            num /= 1000;
            res = num % 1000 == 0 ? res : convertHundred(num % 1000) + " " + vec[i] + (res.isEmpty() ? "" : " " + res);
        }
        return res.isEmpty() ? "Zero" : res;
    }
    private static String convertHundred(int num) {
        String res = "";
        String[] unit = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
                "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
                "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] decade = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        int a = num / 100, b = num % 100, c = num % 10;
        if (b < 20) res = unit[b];
        else res = decade[b / 10] + (c == 0 ? "" : " " + unit[c]);
        if (a != 0) res = unit[a] + " Hundred" + (res.isEmpty() ? "" : " " + res);
        return res;
    }
}
