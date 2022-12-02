class Solution {
    public int longestConsecutive(TreeNode root) {
        traverse(root);
        return res;
    }

    int res = 0;
    private int[] traverse(TreeNode root) {
        int[] arr = new int[]{1, 1};
        if(root == null) return arr;

        int[] left = traverse(root.left);
        int[] right = traverse(root.right);

        if(root.left != null) {
            if(root.val + 1 == root.left.val) arr[0] = left[0] + 1;
            else if(root.val - 1 == root.left.val) arr[1] = left[1] + 1;
        }

        if(root.right != null) {
            if(root.val + 1 == root.right.val) arr[0] = Math.max(arr[0], right[0] + 1);
            else if(root.val - 1 == root.right.val) arr[1] = Math.max(arr[1], right[1] + 1);
        }

        res = Math.max(res, arr[0] + arr[1] - 1);
        return arr;
    }
}
