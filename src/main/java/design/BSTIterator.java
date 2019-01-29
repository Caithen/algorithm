package design;

import tree.TreeNode;
import java.util.Stack;

/**
 * Created by 15501 on 2019/1/26.
 * while 循环 实现 中序遍历
 */
public class BSTIterator {

    public Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode cur = stack.pop();
        int res = cur.val;
        cur = cur.right;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        return res;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

}
