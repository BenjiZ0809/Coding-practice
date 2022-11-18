//approach 1
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = traverse(root, p, q);
        if(findP && findQ) return res;
        return null;
    }

    boolean findP = false;
    boolean findQ = false;
    private TreeNode traverse(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        TreeNode left = traverse(root.left, p, q);
        TreeNode right = traverse(root.right, p, q);
        if(left != null && right != null) return root;
        if(root == p || root == q) {
            if(root == p) findP = true;
            if(root == q) findQ = true;
            return root;
        }
        return left == null? right:left;
    }
}

//Approach 2
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        map.put(root, null);
        dfs(root);
        while(p != null) {
            set.add(p);
            p = map.get(p);
        }
        while(q != null) {
            if(set.contains(q)) return q;
            q = map.get(q);
        }
        return null;
    }

    Map<TreeNode, TreeNode> map = new HashMap<>();
    Set<TreeNode> set = new HashSet<>();
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
