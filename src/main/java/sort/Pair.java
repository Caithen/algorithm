package sort;

/**
 * Created by 15501 on 2018/10/30.
 */
public class Pair implements Comparable<Pair> {
    private int key;
    private int value;
    public Pair() {
    }
    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
    public int getKey() {
        return this.key;
    }
    public int getValue() {
        return this.value;
    }
    public void subsub() {
        this.value--;
    }
    public int compareTo(Pair pair) {
        return pair.getValue() - this.value;
    }
}
