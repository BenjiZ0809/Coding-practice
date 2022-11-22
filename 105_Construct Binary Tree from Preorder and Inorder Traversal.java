class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1,
                    inorder, 0, inorder.length -1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                            int[] inorder, int inStart, int inEnd) {
        if(preStart > preEnd) return null;
        int val = preorder[preStart];
        int index = map.get(val);
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(val);
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                            inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                            inorder, index + 1, inEnd);
        return root;
    }
}
