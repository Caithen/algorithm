package linkedList;

/**
 * Created by user on 2018/12/25.
 */
public class SwapNodesInPairs24 {
    public static void main(String[] args) {
        ListNode head = ListNode.createListNode(new int[]{1, 2, 3, 4});
        ListNode res = swapPairs(head);
        while (res != null) {
            System.out.print(res.val + "  ");
            res = res.next;
        }
    }

    // 递归写法
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = head.next;
        head.next = swapPairs(temp.next);
        temp.next = head;
        return temp;
    }

    // 这道题容易把head搞错了
//    public static ListNode swapPairs(ListNode head) {
//        ListNode res = new ListNode(-1), cur = res, temp;
//        res.next = head;
//        while (cur.next != null && cur.next.next != null) {
//            temp = cur.next.next;
//            cur.next.next = temp.next;
//            temp.next = cur.next;
//            cur.next = temp;
//            cur = temp.next;
//        }
//        return res.next;
//    }
}
