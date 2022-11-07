public class Solution {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        List<ListNode> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            ListNode dummy = new ListNode(-1);
            ListNode curListNode = new ListNode(-1);
            for(int i=0; i<size; i++) {
                TreeNode cur = q.poll();
                if(i == 0) {
                    curListNode = new ListNode(cur.val);
                    dummy.next = curListNode;
                }
                else {
                    curListNode.next = new ListNode(cur.val);
                    curListNode = curListNode.next;
                }
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
            res.add(dummy.next);
        }
        return res;
    }
}
