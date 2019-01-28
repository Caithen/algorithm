package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 15501 on 2019/1/8.
 */
public class UniqueBinarySearchTreesII95 {
    public static void main(String[] args) {
        for (TreeNode r : generateTrees(3)) {
            TreeNode.printTree(r);
            System.out.println();
        }
    }

    // 递归解法
    public static List<TreeNode> generateTrees(int n) {
        if (n < 1) return new ArrayList<TreeNode>();
        return helper(1, n);
    }
    private static List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (start > end) res.add(null);
        else {
            for (int i = start; i <= end; i++) {
                for (TreeNode left : helper(start, i - 1)) {
                    for (TreeNode right : helper(i + 1, end)) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        res.add(root);
                    }
                }
            }
        }
        return res;
    }

    // 下面是动态规划
//    public static List<TreeNode> generateTrees(int n) {
//        List<List<TreeNode>> dp = new ArrayList();
//        List<TreeNode> temp = new ArrayList();
//        temp.add(null);
//        dp.add(temp);
//        for (int i = 1; i <= n; i++) {
//            temp = new ArrayList();
//            for (int j = 1; j <= i; j++) {
//                for (TreeNode left : dp.get(j - 1)) {
//                    for (TreeNode right : dp.get(i - j)) {
//                        TreeNode root = new TreeNode(j);
//                        root.left = left;
//                        root.right = helper(right, j);
//                        temp.add(root);
//                    }
//                }
//            }
//            dp.add(temp);
//        }
//        return dp.get(n);
//    }
//    private static TreeNode helper(TreeNode root, int i) {
//        if (root == null) return null;
//        TreeNode r = new TreeNode(root.val + i);
//        r.left = helper(root.left, i);
//        r.right = helper(root.right, i);
//        return r;
//    }
}
