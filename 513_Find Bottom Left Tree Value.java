//BFS
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

//DFS
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        traverse(root, 1);
        return res;
    }
    int level = 0;
    int res = 0;
    private void traverse(TreeNode root, int lv) {
        if(root == null) return;
        if(lv > level) {
            res = root.val;
            level = lv;
        }
        traverse(root.left, lv + 1);
        traverse(root.right, lv + 1);
    }
}
