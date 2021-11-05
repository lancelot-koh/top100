package day3;

import day2.TreeNode;

import java.util.HashMap;

public class PathSumIII {
    int count = 0;
    int k;
    HashMap<Integer, Integer> map = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        k = targetSum;
        preorder(root, 0);
        return count;
    }

    public void preorder(TreeNode node, int currSum) {
        if(node == null) {
            return;
        }

        currSum += node.val;

        if(currSum == k) {
            count++;
        }
        count += map.getOrDefault(currSum - k, 0);
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        preorder(node.left, currSum);
        preorder(node.right, currSum);

        map.put(currSum, map.get(currSum) - 1);
    }
}
