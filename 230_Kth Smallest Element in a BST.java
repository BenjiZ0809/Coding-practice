//Approach 1
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        traverse(root);
        for(int i=0; i<k - 1; i++) {
            q.poll();
        }
        return q.poll();
    }
    Queue<Integer> q = new ArrayDeque<>();
    private void traverse(TreeNode root) {
        if(root == null) return;
        traverse(root.left);
        q.offer(root.val);
        traverse(root.right);
    }
}

//Approach 2
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return res;
    }

    int res = 0;
    int rank = 0;
    private void inOrder(TreeNode root, int k) {
        if(root == null) return;
        inOrder(root.left, k);
        rank++;
        if(rank == k) res = root.val;
        inOrder(root.right, k);
    }
}

//Approach 3 stack
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while(root != null) {
            stack.push(root);
            root = root.left;
        }    

        for(int i=0; i<k-1; i++) {
            TreeNode cur = stack.pop();
            if(cur.right != null) {
                cur = cur.right;
                while(cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
            }
        }
        return stack.peek().val;
    }
}
