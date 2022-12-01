class Solution {
    public int longestConsecutive(TreeNode root) {
        traverse(root, null, 0);
        return max;
    }
    
    int max = 0;
    private int traverse(TreeNode root, TreeNode parent, int count) {
        if(root == null) return 0;
        if(parent != null && root.val - parent.val == 1) {
            count++;
        }
        else count = 1;
        max = Math.max(max, count);
        traverse(root.left, root, count);
        traverse(root.right, root, count);
        return count;
    }
}
