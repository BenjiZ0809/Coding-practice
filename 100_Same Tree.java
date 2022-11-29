//Iterative
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();
        stackP.push(p);
        stackQ.push(q);

        while(!stackP.isEmpty() && !stackQ.isEmpty()) {
            TreeNode curP = stackP.pop();
            TreeNode curQ = stackQ.pop();
            if(curP == null && curQ == null) continue;
            if(curP == null && curQ != null) return false;
            if(curP != null && curQ == null) return false;
            if(curP.val != curQ.val) return false;

            stackP.push(curP.right);
            stackP.push(curP.left);
            stackQ.push(curQ.right);
            stackQ.push(curQ.left);
        }
        return true;
    }
}

//Recursive
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
