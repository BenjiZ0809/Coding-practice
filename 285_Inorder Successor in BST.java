class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        traverse(root, p);
        return res;
    }

    boolean flag = false;
    TreeNode res = null;
    private void traverse(TreeNode root, TreeNode p) {
        if(root == null) return;
        traverse(root.left, p);
        if(root.val > p.val && flag == false) {
            flag = true;
            res = root;
        }
        traverse(root.right, p);
    }
}
