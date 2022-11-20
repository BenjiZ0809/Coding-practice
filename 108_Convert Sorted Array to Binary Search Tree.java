class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return traverse(nums, 0, nums.length - 1);
    }

    public TreeNode traverse(int[] nums, int start, int end) {
        if(end < start) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = traverse(nums, start, mid - 1);
        root.right = traverse(nums, mid + 1, end);
        return root;
    }
}
