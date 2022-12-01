//Approach 1 DFS
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        traverse(root, targetSum, 0);
        return res;
    }
    boolean res = false;
    private void traverse(TreeNode root, int tar, int path) {
        if(root == null) return;
        path += root.val;
        if(root.left == null && root.right == null && path == tar) res = true;
        traverse(root.left, tar, path);
        traverse(root.right, tar, path);
    }
}

//Approach 2 DFS*
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        targetSum -= root.val;
        if(root.left == null && root.right == null && targetSum == 0) return true;
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}

//Approach 3 Iterative
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        nodeStack.push(root);
        sumStack.push(targetSum - root.val);

        while(!nodeStack.isEmpty()) {
            TreeNode cur = nodeStack.pop();
            int curSum = sumStack.pop();
            if(cur.left == null && cur.right == null && curSum == 0) return true;
            if(cur.left != null) {
                nodeStack.push(cur.left);
                sumStack.push(curSum - cur.left.val);
            }
            if(cur.right != null) {
                nodeStack.push(cur.right);
                sumStack.push(curSum - cur.right.val);
            }
        }
        return false;
    }
}
