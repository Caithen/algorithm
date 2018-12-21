package linkedList;


/**
 * Created by user on 2018/12/21.
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        int[] nums1 = {2, 4, 3}, nums2 = {5, 6, 4};
        ListNode l1 = ListNode.createListNode(nums1), l2 = ListNode.createListNode(nums2);
        ListNode res = addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }
        System.out.println();
        nums1 = new int[]{5}; nums2 = new int[]{5};
        l1 = ListNode.createListNode(nums1); l2 = ListNode.createListNode(nums2);
        res = addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }
        System.out.println();
        nums1 = new int[]{0}; nums2 = new int[]{0};
        l1 = ListNode.createListNode(nums1); l2 = ListNode.createListNode(nums2);
        res = addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }
        System.out.println();
        nums1 = new int[]{0}; nums2 = new int[]{};
        l1 = ListNode.createListNode(nums1); l2 = ListNode.createListNode(nums2);
        res = addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }
        System.out.println();
    }

    // 代码优化，可以在第一个while使用判断语句查看链表是否为空，如果为空，则将其值设为0
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1), cur = res;
        int carry = 0, val, val1, val2;
        while (l1 != null || l2 != null) {
            val =  (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = val / 10;
            cur.next = new ListNode(val % 10);
            cur = cur.next;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        if (carry != 0) cur.next = new ListNode(carry);
        return res.next;
    }

    // 使用carry计数进位，首先carry和两个链表同位置相加，然后carry和较长的链表相加，最后处理carry
//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode res = new ListNode(-1), cur = res;
//        int carray = 0, val;
//        while (l1 != null && l2 != null) {
//            val = l1.val + l2.val + carray;
//            carray = val / 10;
//            cur.next = new ListNode(val % 10);
//            cur = cur.next;
//            l1 = l1.next; l2 = l2.next;
//        }
//        if (l1 == null) l1 = l2;
//        while (l1 != null) {
//            val = l1.val + carray;
//            carray = val / 10;
//            cur.next = new ListNode(val % 10);
//            cur = cur.next; l1 = l1.next;
//        }
//        if (carray != 0) cur.next = new ListNode(carray);
//        return res.next;
//    }
}
