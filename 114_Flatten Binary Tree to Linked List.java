class Solution {
    public void flatten(TreeNode root) {
        dfs(root);
        for(int i=0; i<arr.size() - 1; i++) {
            arr.get(i).left = null;
            arr.get(i).right = arr.get(i + 1);
        }
        

    }
    List<TreeNode> arr = new ArrayList<>();
    public void dfs(TreeNode root) {
        if(root == null) return;
        arr.add(root);
        dfs(root.left);
        dfs(root.right);
    }
}
