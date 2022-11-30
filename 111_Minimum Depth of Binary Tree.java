//BFS
class Solution {
    public int minDepth(TreeNode root) {
        Queue<Pair> q = new ArrayDeque<>();
        if(root == null) return 0;
        q.offer(new Pair(root, 1));

        int res = 0;
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            TreeNode curNode = cur.node;
            int curDepth = cur.depth;
            if(curNode.left == null && curNode.right == null) {
                res = cur.depth;
                break;
            }
            if(curNode.left != null) q.offer(new Pair(curNode.left, curDepth + 1));
            if(curNode.right != null) q.offer(new Pair(curNode.right, curDepth + 1));
        }
        return res;
    }

    class Pair {
        TreeNode node;
        int depth;
        public Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}

//DFS recursive
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int min = Integer.MAX_VALUE;
        if(root.left != null) {
            min = Math.min(minDepth(root.left), min);
        }
        if(root.right != null) {
            min = Math.min(minDepth(root.right), min);
        }
        return min + 1;
    }
}
