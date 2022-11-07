class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()) {
            root = q.poll();
            if(root.right != null) q.offer(root.right);
            if(root.left != null) q.offer(root.left);
        }
        return root.val;
    }
}
