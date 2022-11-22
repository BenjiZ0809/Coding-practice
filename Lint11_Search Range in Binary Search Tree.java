    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        List<Integer> res = new ArrayList<>();
        traverse(root, k1, k2, res);
        return res;
    }

    private void traverse(TreeNode root, int k1, int k2, List<Integer> res) {
        if(root == null) return ;
        traverse(root.left, k1, k2, res);
        if(root.val >= k1 && root.val <= k2) res.add(root.val);
        traverse(root.right, k1, k2, res);
    }
}
