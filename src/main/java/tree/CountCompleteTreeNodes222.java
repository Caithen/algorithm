package tree;

/**
 * Created by 15501 on 2019/2/3.
 */
public class CountCompleteTreeNodes222 {
    public static void main(String[] args) {

    }

    // 查看右子树高度是否为h - 1，如果是，则左边是满树，递归右树
    // 否则，右树是高度小1的满树，递归左数。
    public static int countNodes(TreeNode root) {
        if (root == null) return 0;
        int h = height(root);
        if (height(root.right) == h - 1) return (1 << (h - 1)) + countNodes(root.right);
        else return (1 << (h - 2)) + countNodes(root.left);
    }
    private static int height(TreeNode root) {
        if (root == null) return 0;
        else return 1 + height(root.left);
    }
}
