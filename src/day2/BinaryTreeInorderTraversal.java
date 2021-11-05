package day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                System.out.println("push "+ curr.val);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.println("pop "+ curr.val);
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;

    }

    void helper(TreeNode root, List<Integer> res) {
        if(root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if(root.right != null) {
                helper(root.right, res);
            }
        }
    }
}

