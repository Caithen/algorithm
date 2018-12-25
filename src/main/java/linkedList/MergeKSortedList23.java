package linkedList;

/**
 * Created by user on 2018/12/25.
 */
public class MergeKSortedList23 {
    public static void main(String[] args) {
        ListNode[] lists = {ListNode.createListNode(new int[]{1, 4, 5}),
                ListNode.createListNode(new int[]{1, 3, 4}), ListNode.createListNode(new int[]{2, 6})};
        ListNode res = mergeKLists(lists);
        while (res != null) {
            System.out.print(res.val + "  ");
            res = res.next;
        }
        System.out.println();
    }

    // 下面的方法很慢，实际上还有一种用优先队列实现的，但这种浪费空间复杂度
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1) return null;
        ListNode res = lists[0];
        for (int i = 1; i < lists.length; i++)
            res = mergeTwoLists(res, lists[i]);
        return res;
    }
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1), cur = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) cur.next = l2;
        else cur.next = l1;
        return res.next;
    }
}
