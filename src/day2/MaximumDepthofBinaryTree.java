package day2;

import java.util.LinkedList;

public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return Math.max(left_height, right_height) + 1;
        }
    }

    public int maxDepth2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> depths = new LinkedList<>();

        if(root == null) {
            return 0;
        }

        stack.add(root);
        depths.add(1);

        int depth = 0, curr_depth = 0;
        while (!stack.isEmpty()) {
            root = stack.pollLast();
            curr_depth = depths.pollLast();

            if(root != null) {
                depth = Math.max(depth, curr_depth);
                stack.add(root.left);
                stack.add(root.right);
                depths.add(curr_depth + 1);
                depths.add(curr_depth + 1);
            }
        }
        return depth;
    }
}

