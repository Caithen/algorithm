package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 15501 on 2019/2/6.
 */
public class BinaryTreePaths257 {
    public static void main(String[] args) {

    }
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        String temp = "";
        helper(root, temp, res);
        return res;
    }
    private static void helper(TreeNode root, String temp, List<String> res) {
        if (root == null) return;
        if (!temp.isEmpty()) temp += "->";
        temp += root.val;
        if (root.left == null && root.right == null) res.add(temp);
        helper(root.left, temp, res);
        helper(root.right, temp, res);
    }
}
