package linkedList;

/**
 * Created by user on 2019/1/21.
 */
public class SortList148 {
    public static void main(String[] args) {

    }
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        head = sortList(head);
        fast = sortList(fast);
        return MergeTwoSortList(head, fast);
    }
    public static ListNode MergeTwoSortList(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1), cur = res;
        while (l1 != null && l2 != null) {
            int val1 = l1.val, val2 = l2.val;
            if (val1 <= val2) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) cur.next = l1;
        else cur.next = l2;
        return res.next;
    }
}
