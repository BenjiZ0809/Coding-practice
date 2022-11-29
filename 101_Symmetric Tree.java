//Iterative
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root.left == null && root.right == null) return true;
        if(root.left == null || root.right == null) return false;
        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();
        left.push(root.left);
        right.push(root.right);

        while(!left.isEmpty() || !right.isEmpty()) {
            TreeNode curL = left.pop();
            TreeNode curR = right.pop();
            if(curL == null && curR == null) continue;
            if(curL == null || curR == null) return false;
            if(curL.val != curR.val) return false;
            left.push(curL.right);
            left.push(curL.left);
            right.push(curR.left);
            right.push(curR.right);
        }
        return true;
    }
}

//Recursive
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
