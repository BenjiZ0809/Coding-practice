//Approach 1
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        traverse(root, p);
        return res;
    }

    boolean flag = false;
    TreeNode res = null;
    private void traverse(TreeNode root, TreeNode p) {
        if(root == null) return;
        traverse(root.left, p);
        if(root.val > p.val && flag == false) {
            flag = true;
            res = root;
        }
        traverse(root.right, p);
    }
}

//Approach 2
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) return null;
        if(root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        }
        else {
            TreeNode node = inorderSuccessor(root.left, p);
            return node == null? root:node;
        }
    }
}

//Approach 3
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while(root != null) {
            if(root.val > p.val) {
                res = root;
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
        return res;
    }
}
