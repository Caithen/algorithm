package linkedList;

/**
 * Created by user on 2019/1/8.
 */
public class PartitionList86 {
    public static void main(String[] args) {
        ListNode head = ListNode.createListNode(new int[]{1, 4, 3, 2, 5, 2});
        ListNode res = partition(head, 3);
        while (res != null) {
            System.out.print(res.val + "  ");
            res = res.next;
        }
        System.out.println();
    }
    public static ListNode partition(ListNode head, int x) {
        ListNode res = new ListNode(-1), pre = res, cur, temp;
        res.next = head;
        while (pre.next != null && pre.next.val < x) pre = pre.next;
        cur = pre;
        while (cur.next != null) {
            if (cur.next.val >= x) cur = cur.next;
            else {
                temp = cur.next;
                cur.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
                pre = pre.next;
            }
        }
        return res.next;
    }
}
