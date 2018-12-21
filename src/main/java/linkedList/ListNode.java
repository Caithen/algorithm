package linkedList;

/**
 * Created by user on 2018/12/21.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    public static ListNode createListNode(int[] nums) {
        ListNode res = new ListNode(-1), cur = res;
        for (int num : nums) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        return res.next;
    }
}
