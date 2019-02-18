package hashMap;

/**
 * Created by 15501 on 2019/2/9.
 */
public class BullsAndCows299 {
    public static void main(String[] args) {
        String secret = "1807", guess = "7810";
        System.out.println(getHint(secret, guess));
        secret = "1123"; guess = "0111";
        System.out.println(getHint(secret, guess));
    }
    public static String getHint(String secret, String guess) {
        int bull = 0, cow = 0;
        int[] record = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bull++;
            else {
                if (++record[secret.charAt(i) - '0'] <= 0) cow++;
                if (--record[guess.charAt(i) - '0'] >= 0) cow++;
            }
        }
        return bull + "A" + cow + "B";
    }
}
