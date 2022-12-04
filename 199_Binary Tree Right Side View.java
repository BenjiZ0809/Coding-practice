//DFS
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        traverse(root);
        return res;
    }

    List<Integer> res = new ArrayList<>();
    int depth = 0;
    private void traverse(TreeNode root) {
        if(root == null) return;
        depth++;
        if(depth > res.size()) res.add(root.val);
        traverse(root.right);
        traverse(root.left);
        depth--;
    }
}

//BFS
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            TreeNode node = q.peek();
            res.add(node.val);
            for(int i=0; i<size; i++) {
                TreeNode cur = q.poll();
                if(cur.right != null) q.offer(cur.right);
                if(cur.left != null) q.offer(cur.left);
            }
        }
        return res;
    }
}
