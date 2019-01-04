package linkedList;

/**
 * Created by user on 2018/12/26.
 */
public class ReverLinkedListII92 {
    public static void main(String[] args) {
        ListNode head = ListNode.createListNode(new int[]{1, 2, 3, 4, 5});
        ListNode res = reverseBetween(head, 2, 4);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode res = new ListNode(-1), mcur = res, ncur = res, temp;
        res.next = head;
        while (--m > 0 && mcur.next != null) mcur = mcur.next;
        if (mcur.next == null) return head;
        while (n-- > 0 && ncur.next != null) ncur = ncur.next;
        if (ncur.next == null) {
            mcur.next = reverseList(mcur.next);
            return res.next;
        }
        temp = ncur.next; ncur.next = null;
        mcur.next = reverseList(mcur.next);
        while (mcur.next != null) mcur = mcur.next;
        mcur.next = temp;
        return res.next;
    }
    public static ListNode reverseList(ListNode head) {
        ListNode cur = head, temp;
        while (cur != null && cur.next != null) {
            temp = cur.next;
            cur.next = temp.next;
            temp.next = head;
            head = temp;
        }
        return head;
    }
}
