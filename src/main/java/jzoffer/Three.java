package jzoffer;

/**
 * Created by 15501 on 2019/2/10.
 */
public class Three {
    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("We Are Happy")));
        System.out.println(replaceSpace(new StringBuffer("")));
        System.out.println(replaceSpace(new StringBuffer("  ")));
    }
    public static String replaceSpace(StringBuffer str) {
        String inplace = "%20";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') str.replace(i, i+1, inplace);
        }
        return str.toString();
    }
}
