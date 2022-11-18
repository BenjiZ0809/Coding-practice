class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<TreeNode> set = new HashSet<>();
        for(TreeNode node:nodes) set.add(node);
        TreeNode res = traverse(root, set);
        return res;
    }

    private TreeNode traverse(TreeNode root, Set<TreeNode> set) {
        if(root == null) return null;
        if(set.contains(root)) return root;
        TreeNode left = traverse(root.left, set);
        TreeNode right = traverse(root.right, set);
        if(left != null && right != null) return root;
        return left == null? right:left;
    }
}
