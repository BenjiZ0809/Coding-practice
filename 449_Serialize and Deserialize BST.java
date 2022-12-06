public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if(root == null) return;
        sb.append(root.val + ",");
        serialize(root.left, sb);
        serialize(root.right, sb);   
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] arr = data.split(",");
        Queue<Integer> q = new ArrayDeque<>();
        for(String str:arr) q.offer(Integer.valueOf(str));
        return deserialize(Integer.MIN_VALUE, Integer.MAX_VALUE, q);
    }

    private TreeNode deserialize(int min, int max, Queue<Integer> q) {
        if(q.isEmpty()) return null;
        int val = q.peek();
        if(val < min || val > max) return null;
        q.poll();
        TreeNode root = new TreeNode(val);
        root.left = deserialize(min, val, q);
        root.right = deserialize(val, max, q);
        return root;
    }
}
