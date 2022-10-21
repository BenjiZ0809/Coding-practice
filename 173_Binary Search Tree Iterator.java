class BSTIterator {
    private Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        updateStack(root);
    }
    
    public int next() {
        TreeNode node = stack.pop();
        updateStack(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void updateStack(TreeNode node) {
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
