package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by 15501 on 2019/1/8.
 */
public class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int x) { this.val = x; }
    public void printTree(TreeNode root) {
        if (root == null) System.out.print("null, ");
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode cur;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur == null) System.out.print("null, ");
            else if (cur.left == null && cur.right == null) {
                System.out.print(cur.val + ", ");
            } else if (cur.right == null) {
                System.out.print(cur.val + ", ");
                queue.offer(cur.left);
                queue.offer(null);
            } else if (cur.left == null) {
                System.out.print(cur.val + ", ");
                queue.offer(cur.right);
                queue.offer(null);
            } else {
                System.out.print(cur.val + ", ");
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
    }
}
