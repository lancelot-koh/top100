package day2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();

        if(root == null) return levels;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;
        while (!queue.isEmpty()) {
            levels.add(new ArrayList<Integer>());

            int level_len = queue.size();
            for(int i = 0; i < level_len; i++) {
                TreeNode node = queue.remove();

                levels.get(level).add(node.val);

                if(node.left !=null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
        }
        return levels;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if(root == null) {
            return levels;
        }
        helper(root, 0, levels);
        return levels;
    }

    void helper(TreeNode root, int level, List<List<Integer>> levels) {
        if(levels.size() == level) {
            levels.add(new ArrayList<Integer>());
        }

        levels.get(level).add(root.val);

        if(root.left != null) {
            helper(root.left, level + 1, levels);
        }
        if(root.right != null) {
            helper(root.right, level + 1, levels);
        }
    }
}
