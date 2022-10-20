class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backTracking(root, path, res);
        return res;
    }
    
    private void backTracking(TreeNode root, List<String> path, List<String> res) {
        if(root == null) return;
        path.add(String.valueOf(root.val));
        
        if(root.left == null && root.right == null) {
            res.add(String.join("->", path));
        }
        
        backTracking(root.left, path, res);
        backTracking(root.right, path, res);
        
        path.remove(path.size() - 1);
    }
}
