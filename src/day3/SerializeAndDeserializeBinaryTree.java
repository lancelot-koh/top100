package day3;

import day2.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeAndDeserializeBinaryTree {

    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }

    public String rserialize(TreeNode root, String str) {
        if (root == null) {
            str += "null,";
        } else  {
            str += str.valueOf(root.val);
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

        // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_arr = data.split(",");
        List<String> data_list = new LinkedList<>(Arrays.asList(data_arr));
        return rdeserialize(data_list);
    }

    public TreeNode rdeserialize(List<String> l) {
        if (l.get(0).equals("null")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);

        return root;
    }
}
