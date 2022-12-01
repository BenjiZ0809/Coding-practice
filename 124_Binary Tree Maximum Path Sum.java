class Solution {
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        traverse(root);
        return res;
    }

    int res = Integer.MIN_VALUE;
    private int traverse(TreeNode root) {
        if(root == null) return 0;
        int left = Math.max(0, traverse(root.left));
        int right = Math.max(0, traverse(root.right));
        int max = left + right + root.val;
        res = Math.max(max, res);
        return Math.max(left, right) + root.val;
    }
}
