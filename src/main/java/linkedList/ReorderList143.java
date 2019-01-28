package linkedList;

/**
 * Created by 15501 on 2019/1/18.
 */
public class ReorderList143 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ListNode head = ListNode.createListNode(nums);
        reorderList(head);
        ListNode.printList(head);
    }
    public static void reorderList(ListNode head) {
        if (head == null) return;
        ListNode slow = head, fast = head, temp;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        ListNode.printList(fast);
        slow.next = null;
        slow = head;
        fast = reverse(fast);
        ListNode.printList(fast);
        while (slow != null && fast != null) {
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    private static ListNode reverse(ListNode head) {
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
