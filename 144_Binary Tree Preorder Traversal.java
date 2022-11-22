//Recursive approach
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }

    List<Integer> res = new ArrayList<>();
    private void traverse(TreeNode root) {
        if(root == null) return;
        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}

//Iterative approach
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if(cur.right != null) stack.add(cur.right);
            if(cur.left != null) stack.add(cur.left);
        }
        return res;
    }
}
