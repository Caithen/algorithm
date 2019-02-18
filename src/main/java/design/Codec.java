package design;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by 15501 on 2019/2/9.
 */
public class Codec {

    static String NN = "null";
    static String spliter = ",";

    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append(NN).append(spliter);
            return;
        }
        sb.append(root.val).append(spliter);
        buildString(root.left, sb);
        buildString(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals(NN)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root;
    }
}
class TreeNode {
    int val;
    TreeNode left, right;
    public TreeNode(int x) {
        val = x;
    }
}
