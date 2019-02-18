package jzoffer;

/**
 * Created by 15501 on 2019/2/10.
 */
public class Five {
    public static void main(String[] args) {

    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0 || in.length == 0) return null;
        return helper(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }
    private TreeNode helper(int[] pre, int pleft, int pright, int[] in, int ileft, int iright) {
        if (pleft > pright) return null;
        TreeNode root = new TreeNode(pre[pleft]);
        int len = 0;
        while (in[ileft + len] != pre[pleft]) len++;
        root.left = helper(pre, pleft + 1, pleft + len, in, ileft, ileft + len - 1);
        root.right = helper(pre, pleft + len + 1, pright, in, ileft + len + 1, iright);
        return root;
    }
}
