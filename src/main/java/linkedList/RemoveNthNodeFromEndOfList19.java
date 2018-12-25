package linkedList;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by user on 2018/12/25.
 */
public class RemoveNthNodeFromEndOfList19 {
    public static void main(String[] args) {
        ListNode head = ListNode.createListNode(new int[]{1, 2, 3, 4, 5});
        ListNode res = removeNthFromEnd(head, 2);
        while (res != null) {
            System.out.print(res.val + "    ");
            res = res.next;
        }
        System.out.println();
        head = ListNode.createListNode(new int[]{1, 2, 3, 4, 5});
        res = removeNthFromEnd(head, 1);
        while (res != null) {
            System.out.print(res.val + "    ");
            res = res.next;
        }
        System.out.println();
        head = ListNode.createListNode(new int[]{1, 2, 3, 4, 5});
        res = removeNthFromEnd(head, 0);
        while (res != null) {
            System.out.print(res.val + "    ");
            res = res.next;
        }
        System.out.println();
        head = ListNode.createListNode(new int[]{1, 2, 3, 4, 5});
        res = removeNthFromEnd(head, 6);
        while (res != null) {
            System.out.print(res.val + "    ");
            res = res.next;
        }
        System.out.println();
        head = ListNode.createListNode(new int[]{});
        res = removeNthFromEnd(head, 1);
        while (res != null) {
            System.out.print(res.val + "    ");
            res = res.next;
        }
        System.out.println();
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n < 1) return head;
        ListNode res = new ListNode(-1); res.next = head;
        ListNode left = res, right = res;
        for (int i = 0; i < n; i++) {
            if (right.next != null) right = right.next;
            else return head;
        }
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return res.next;
    }
}
