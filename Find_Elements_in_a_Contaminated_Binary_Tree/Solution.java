// source: https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/description/?envType=daily-question&envId=2025-02-21

import java.util.HashSet;

class FindElements {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public HashSet<Integer> set;

    public FindElements(TreeNode root) {
        set = new HashSet<>();
        root.val = 0;
        set.add(root.val);
        setValue(root.left, 2 * root.val + 1);
        setValue(root.right, 2 * root.val + 2);
    }

    public void setValue(TreeNode node, int v) {
        if (node == null) {
            return;
        }
        node.val = v;
        set.add(node.val);
        setValue(node.left, 2 * v + 1);
        setValue(node.right, 2 * v + 2);
    }

    public boolean find(int target) {
        if (set.contains(target)) {
            return true;
        }
        return false;
    }
}