//单队列 approach（最常用）
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> minires = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                minires.add(node.val);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            res.add(minires);
        }
        return res;
    }
}


//双队列 approach
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        List<TreeNode> q1 = new ArrayList<>();
        q1.add(root);
        
        while(!q1.isEmpty()) {
            List<TreeNode> q2 = new ArrayList<>();
            List<Integer> level = new ArrayList<>();
            for(TreeNode node:q1) level.add(node.val);
            res.add(level);
            for(TreeNode node:q1) {
                if(node.left != null) q2.add(node.left);
                if(node.right != null) q2.add(node.right);
            }
            q1 = q2;
        }
        return res;
    }
}

//递归 approach
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return res;
        helper(root,0);
        return res;
    }
    
    public void helper(TreeNode node, int level){
        if(res.size() == level){
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(node.val);
        if(node.left != null) helper(node.left, level+1);
        if(node.right != null) helper(node.right, level +1);
    }
}
