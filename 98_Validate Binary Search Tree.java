//Approach 1
class Solution {
    public boolean isValidBST(TreeNode root) {
        traverse(root);
        for(int i=0; i<arr.size() - 1; i++) {
            if(arr.get(i) >= arr.get(i + 1)) return false;
        }
        return true;
    }

    List<Integer> arr = new ArrayList<>();
    private void traverse(TreeNode root) {
        if(root == null) return;
        traverse(root.left);
        arr.add(root.val);
        traverse(root.right);
    }
}

//Approach 2
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode root, TreeNode min, TreeNode max) {
        if(root == null) return true;
        if(min != null && root.val <= min.val) return false;
        if(max != null && root.val >= max.val) return false;
        return isValid(root.left, min, root) && isValid(root.right, root, max);
    }
}
