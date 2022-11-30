//Approach 1(BFS)
class Solution {
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int res = -1;
        while(!q.isEmpty()) {
            TreeNode cur = q.poll();
            if(isBST(cur, null, null)) {
                res = Math.max(res, numOfNodes(cur));
            }
            if(cur.left != null) q.offer(cur.left);
            if(cur.right != null) q.offer(cur.right);
        }
        return res;
    }

    private boolean isBST(TreeNode root, TreeNode min, TreeNode max) {
        if(root == null) return true;
        if(min != null && root.val <= min.val) return false;
        if(max != null && root.val >= max.val) return false;
        return isBST(root.left, min, root) && isBST(root.right, root, max);
    }

    private int numOfNodes(TreeNode root) {
        if(root == null) return 0;
        int left = numOfNodes(root.left);
        int right = numOfNodes(root.right);
        return left + right + 1;
    }
}

//Approach 2 (Recursive)
class Solution {
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        if(isBST(root, null, null)) return numOfNodes(root);
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    private boolean isBST(TreeNode root, TreeNode min, TreeNode max) {
        if(root == null) return true;
        if(min != null && root.val <= min.val) return false;
        if(max != null && root.val >= max.val) return false;
        return isBST(root.left, min, root) && isBST(root.right, root, max);
    }

    private int numOfNodes(TreeNode root) {
        if(root == null) return 0;
        int left = numOfNodes(root.left);
        int right = numOfNodes(root.right);
        return left + right + 1;
    }
}
