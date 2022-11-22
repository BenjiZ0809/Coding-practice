//Recursive approach
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }

    List<Integer> res = new ArrayList<>();
    private void traverse(TreeNode root) {
        if(root == null) return;
        traverse(root.left);
        traverse(root.right);
        res.add(root.val);
    }
}

//Iterative approach
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(0, cur.val);
            if(cur.left != null) stack.push(cur.left);
            if(cur.right != null) stack.push(cur.right);
            
        }
        return res;
    } 
}
