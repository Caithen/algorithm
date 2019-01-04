package linkedList;

/**
 * Created by user on 2018/12/26.
 */
public class ReverseLinkedList206 {
    public static void main(String[] args) {
        ListNode head = ListNode.createListNode(new int[]{1, 2, 3, 4});
        ListNode res = reverseList(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
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

//    public static ListNode reverseList(ListNode head) {
//        ListNode res = new ListNode(-1), cur = head, temp;
//        res.next = head;
//        while (cur != null && cur.next != null) {
//            temp = cur.next;
//            cur.next = temp.next;
//            temp.next = res.next;
//            res.next = temp;
//        }
//        return res.next;
//    }
}
