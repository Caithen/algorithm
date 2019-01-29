package tree;

/**
 * Created by user on 2019/1/9.
 */
public class ValidateBinarySearchTree98 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1); root.right = new TreeNode(3);
        System.out.println(isValidBST(root));
    }

    // 下面使用一个技巧，使用null表示目前节点的值没有限制
    // helper的两个界限的数据类型是Integer，因为int没有null
    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return helper(root, null, null);
    }
    private static boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
