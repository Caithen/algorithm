package string;

/**
 * Created by user on 2019/1/23.
 */
public class ReverseWordsInAString151 {
    public static void main(String[] args) {
        System.out.println("\"" + reverseWords("the sky is blue") + "\"");
        System.out.println("\"" + reverseWords("1 ") + "\"");
        System.out.println("\"" + reverseWords(" ") + "\"");
    }

    public static String reverseWords(String s) {
        char[] array = s.toCharArray();
        int n = array.length;
        reverseArray(array, 0, n - 1);
        reverseWord(array, n);
        return clean(array, n);
    }

    public static String clean(char[] array, int n) {
        int i = 0, j = 0;
        while (j < n) {
            while (j < n && array[j] == ' ') j++;
            while (j < n && array[j] != ' ') array[i++] = array[j++];
            while (j < n && array[j] == ' ') j++;
            if(j < n) array[i++] = ' ';
        }
        return new String(array).substring(0, i);
    }

    public static void reverseWord(char[] array, int n) {
        int left, right, i = 0;
        while (i < n) {
            while (i < n && array[i] == ' ') i++;
            left = i;
            while (i < n && array[i] != ' ') i++;
            right = i - 1;
            if (right < n) reverseArray(array, left, right);
        }
    }

    public static void reverseArray(char[] array, int i, int j) {
        while (i < j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++; j--;
        }
    }
}
