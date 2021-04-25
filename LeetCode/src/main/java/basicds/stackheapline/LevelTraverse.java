package basicds.stackheapline;


import java.util.LinkedList;

/**
 * @author rjjerry
 */
public class LevelTraverse {
    public static void main(String[] args) {

    }

    public static void levelTraverse(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode current = null;
        queue.offer(root);
        while (!queue.isEmpty()){
            current = queue.poll();
            System.out.println(current.val);
            if (current.left != null){
                queue.offer(current.left);
            }
            if (current.right != null){
                queue.offer(current.right);
            }
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }

    }
}
