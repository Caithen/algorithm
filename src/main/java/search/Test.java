package search;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by 15501 on 2018/11/3.
 */
public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; scan.hasNext(); i++) {
            String key = scan.next();
            if (key.equals("EXIT")) {
                scan.close();
                break;
            }
            map.put(key, i);
        }
        for (String s : map.keySet()) {
            System.out.println(s + " " + map.get(s));
        }
    }
}
