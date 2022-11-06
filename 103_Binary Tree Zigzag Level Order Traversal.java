class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> minires = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode cur = q.poll();
                minires.add(cur.val);
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
            res.add(minires);
        }
        Collections.reverse(res);
        return res;
    }
}
