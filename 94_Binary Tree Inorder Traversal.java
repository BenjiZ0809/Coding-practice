//Recursive approach
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }

    List<Integer> res = new ArrayList<>();
    private void traverse(TreeNode root) {
        if(root == null) return;
        traverse(root.left);
        res.add(root.val);
        traverse(root.right);
    }
}

//Iterative approach
class Solution {
    Stack<TreeNode> stack = new Stack<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        TreeNode cur = root;
        while(cur != null) {
            stack.push(cur);
            cur = cur.left;
        }

        while(!stack.isEmpty()) {
            cur = stack.pop();
            res.add(cur.val);
            if(cur.right != null) {
                cur = cur.right;
                while(cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
            }
        }
        return res;
    }
}
