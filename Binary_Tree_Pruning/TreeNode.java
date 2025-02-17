class Solution {
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

  public TreeNode pruneTree(TreeNode root) {
    pruneNode(root);
    if (root.left == null && root.right == null && root.val == 0) {
      root = null;
    }
    return root;
  }

  public boolean pruneNode(TreeNode node) {

    if (node.left != null && pruneNode(node.left)) {
      node.left = null;
    }
    if (node.right != null && pruneNode(node.right)) {
      node.right = null;
    }
    if (node.left == null && node.right == null && node.val == 0) {
      return true;
    }
    return false;
  }
}