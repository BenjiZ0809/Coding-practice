class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder, 0, preorder.length - 1,
                    postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                            int[] postorder, int postStart, int postEnd) {
        if(preStart > preEnd) return null;
        int val = preorder[preStart];
        TreeNode root = new TreeNode(val);
        if(preStart == preEnd) return root;
        int left = preorder[preStart + 1];
        int idx = 0;
        for(int i=postStart; i<=postEnd; i++) {
            if(postorder[i] == left) idx = i;
        }                        
        
        int leftSize = idx - postStart + 1;
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                        postorder, postStart, idx);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                        postorder, idx + 1, postEnd - 1);
        return root;
    }
}
