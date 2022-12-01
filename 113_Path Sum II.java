//Approach 1 BackTracking
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        traverse(root, targetSum, new ArrayList<>());
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();
    private void traverse(TreeNode root, int targetSum, List<Integer> minires) {
        if(root == null) return;
        targetSum -= root.val;
        minires.add(root.val);
        if(root.left == null && root.right == null && targetSum == 0) {
            res.add(new ArrayList<>(minires));
        }
        traverse(root.left, targetSum, minires);
        traverse(root.right, targetSum, minires);
        minires.remove(minires.size() - 1);
        targetSum += root.val;
    }
}
