package basicds.tree;

import java.util.ArrayList;
import java.util.List;

//中序遍历二叉树
public class LeetCode0094 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        LeetCode0094 leetCode0094 = new LeetCode0094();
        System.out.println(leetCode0094.inorderTraversal(root));
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        LeetCode0094 leetCode0094 = new LeetCode0094();
        leetCode0094.traveNode(list, root);
        return list;
    }
    public void traveNode(List<Integer> list, TreeNode node){
        if (node == null) {
            return;
        }
        traveNode(list, node.left);
        list.add(node.val);
        traveNode(list, node.right);
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int x) {
        val = x;
    }
}


