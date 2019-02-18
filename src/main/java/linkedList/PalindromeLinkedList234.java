package linkedList;

/**
 * Created by 15501 on 2019/2/5.
 */
public class PalindromeLinkedList234 {
    public static void main(String[] args) {
        ListNode head = ListNode.createListNode(new int[]{1, 2});
        System.out.println(isPalindrome(head));
        head = ListNode.createListNode(new int[]{1, 2, 2, 1});
        System.out.println(isPalindrome(head));
        head = ListNode.createListNode(new int[]{});
        System.out.println(isPalindrome(head));
    }
    public static boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        fast = reverse(fast);
        slow = head;
        while (fast != null) {
            if (slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
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
