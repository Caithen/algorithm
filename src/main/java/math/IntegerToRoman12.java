package math;

/**
 * Created by user on 2018/12/24.
 */
public class IntegerToRoman12 {
    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
        System.out.println(intToRoman(3099));
    }
    public static String intToRoman(int num) {
        String[] units = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] decades = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundreds = {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thousands = {"M", "MM", "MMM"};
        int i = 0;
        String res = "";
        while (num != 0) {
            int remainder = num % 10;
            num /= 10; i++;
            if (remainder == 0) continue;
            if (i == 1) res = units[remainder - 1] + res;
            else if (i == 2) res = decades[remainder - 1] + res;
            else if (i == 3) res = hundreds[remainder - 1] + res;
            else if (i == 4) res = thousands[remainder - 1] + res;
        }
        return res;
    }
}
