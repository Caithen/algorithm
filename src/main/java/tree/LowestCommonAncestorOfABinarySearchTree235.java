package tree;

/**
 * Created by 15501 on 2019/2/5.
 */
public class LowestCommonAncestorOfABinarySearchTree235 {
    public static void main(String[] args) {

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        int min = Math.min(p.val, q.val), max = Math.max(p.val, q.val);
        if (root.val < min) return lowestCommonAncestor(root.right, p, q);
        else if (root.val > max) return lowestCommonAncestor(root.left, p, q);
        else return root;
    }
}
