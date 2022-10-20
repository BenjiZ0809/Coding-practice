//approach 1 (全局变量)
class Solution {
    boolean isBalance = true;
    public boolean isBalanced(TreeNode root) {
        traverse(root);
        return isBalance;
    }
    
    private int traverse(TreeNode root) {
        if(root == null) return 0;
        
        int left = traverse(root.left);
        int right = traverse(root.right);
        
        if(Math.abs(left - right) > 1) isBalance = false;
        
        return Math.max(left, right) + 1;
    }
}

//approach 2 (inner class)
class Solution {
    public boolean isBalanced(TreeNode root) {
        Result res = traverse(root);
        return res.isBalance;
    }
    
    private Result traverse(TreeNode root) {
        if(root == null) return new Result(true, 0);
        
        Result left = traverse(root.left);
        Result right = traverse(root.right);
        
        int height = Math.max(left.height, right.height) + 1;
        boolean isBalance = true;
        
        if(!left.isBalance || !right.isBalance) isBalance = false;
        if(Math.abs(left.height - right.height) > 1) isBalance = false;
        
        return new Result(isBalance, height);
    }
    
    class Result {
        boolean isBalance;
        int height;
        
        public Result(boolean isBalance, int height) {
            this.isBalance = isBalance;
            this.height = height;
        }
    }
}
