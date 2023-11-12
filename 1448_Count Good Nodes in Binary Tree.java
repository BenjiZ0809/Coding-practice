class Solution {
    int res = 0;
    public int goodNodes(TreeNode root) {
        traverse(root, root.val);
        return res;    
    }

    public void traverse(TreeNode root, int max) {
        if(root == null) return;
        int cur = root.val;
        if(cur >= max) {
            res++;
            max = cur;
        }
        traverse(root.left, max);
        traverse(root.right, max);
    }
}
