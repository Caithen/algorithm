package tree;

<<<<<<< HEAD
/**
 * Created by user on 2019/1/9.
 */
public class TreeNode {
    Integer val;
    TreeNode left, right;
    TreeNode(int x) {
        this.val = x;
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int preL = 0, preR = preorder.length - 1, inL = 0, inR = inorder.length - 1;
        return buildTreeCore(preorder, preL, preR, inorder, inL, inR);
    }
    private static TreeNode buildTreeCore(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR) {
        if (preL > preR || inL > inR) return null;
        int val = preorder[preL], cur = inL;
        while (cur <= inR && inorder[cur] != val) cur++;
        TreeNode root = new TreeNode(val);
        root.left = buildTreeCore(preorder, preL + 1, preL + cur - inL, inorder, inL, cur - 1);
        root.right = buildTreeCore(preorder, preL + cur - inL + 1, preR, inorder, cur + 1, inR);
        return root;
    }

//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//        // if (inorder.length != postorder.length) return null;
//        int inL = 0, inR = inorder.length - 1, postL = 0, postR = postorder.length - 1;
//        return buildTreeCore(inorder, inL, inR, postorder, postL, postR);
//    }
//    private TreeNode buildTreeCore(int[] inorder, int inL, int inR, int[] postorder, int postL, int postR) {
//        if (inL > inR || postL > postR) return null;
//        int val = postorder[postR], cur = inR;
//        while (cur >= inL && inorder[cur] != val) cur--;
//        TreeNode root = new TreeNode(val);
//        root.left = buildTreeCore(inorder, inL, cur - 1, postorder, postL, postR - (inR - cur) - 1);
//        root.right = buildTreeCore(inorder, cur + 1, inR, postorder, postR - (inR - cur), postR - 1);
//        return root;
//    }
=======
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
>>>>>>> 0805e201baa510a9ff51d08aa99b2f50f95c143f
}
