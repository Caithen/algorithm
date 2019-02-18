package jzoffer;




import java.util.ArrayList;

/**
 * Created by 15501 on 2019/2/10.
 */
public class Four {
    public static void main(String[] args) {
    }
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode cur = listNode;
        ArrayList<Integer> res = new ArrayList<>();
        while (cur != null) {
            res.add(0, cur.val);
            cur = cur.next;
        }
        return res;
    }
}
