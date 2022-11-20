class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        return traverse(root, node);
    }

    private TreeNode traverse(TreeNode root, TreeNode node) {
        if(root == null) return node;
        if(node.val >= root.val) {
            root.right = traverse(root.right, node);
        }
        else {
            root.left = traverse(root.left, node);
        }
        return root;
    }
}
