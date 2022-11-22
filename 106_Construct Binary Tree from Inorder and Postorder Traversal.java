class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(postorder, 0, postorder.length - 1,
                    inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int postStart, int postEnd,
                            int[] inorder, int inStart, int inEnd) {
        if(postStart > postEnd) return null;
        int val = postorder[postEnd];
        int index = map.get(val);
        int rightSize = inEnd - index;
        TreeNode root = new TreeNode(val);
        root.left = build(postorder, postStart, postEnd - rightSize - 1,
                            inorder, inStart, index - 1);
        root.right = build(postorder, postEnd - rightSize, postEnd - 1,
                            inorder, index + 1, inEnd);
        return root;
    }
}
