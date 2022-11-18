//Approach 1
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) return root;
        return left == null? right:left;
    }
}

//Approach 2
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        map.put(root, null);
        dfs(root);
        while(p != null) {
            parent.add(p);
            p = map.get(p);
        }
        while(q != null) {
            if(parent.contains(q)) {
                return q;
            }
            q = map.get(q);
        }
        return null;
    }

    Map<TreeNode, TreeNode> map = new HashMap<>();
    Set<TreeNode> parent = new HashSet<>();
    private void dfs(TreeNode root) {
        if(root == null) return;
        if(root.left != null) {
            map.put(root.left, root);
            dfs(root.left);
        }
        if(root.right != null) {
            map.put(root.right, root);
            dfs(root.right);
        }
    }
}
