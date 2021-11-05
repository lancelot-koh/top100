package day2;

import java.util.Stack;

public class ValidateBinarySearchTree {
    boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Integer prev = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null && prev >= root.val) {
                return false;
            }
            prev = root.val;
            root = root.right;
        }
        return true;
    }
}
