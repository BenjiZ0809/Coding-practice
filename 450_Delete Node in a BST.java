class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        else if(root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        else {
            if(root.left == null || root.right == null) root = root.left == null? root.right:root.left;
            else {
                TreeNode cur = root.right;
                while(cur.left != null) cur = cur.left;
                root.val = cur.val;
                root.right = deleteNode(root.right, cur.val);
            }
        }
        return root;
    }
}
