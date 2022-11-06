//BFS
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        sb.append(root.val);
        sb.append(",");
        
        while(!q.isEmpty()) {
            TreeNode cur = q.poll();
            if(cur.left == null) sb.append("#,");
            else {
                sb.append(cur.left.val);
                sb.append(",");
                q.offer(cur.left);
            }

            if(cur.right == null) sb.append("#,");
            else {
                sb.append(cur.right.val);
                sb.append(",");
                q.offer(cur.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] arr = data.split(",");
        Queue<TreeNode> q = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
        q.offer(root);
        int index = 0;

        while(!q.isEmpty()) {
            TreeNode cur = q.poll();
            index++;
            if(arr[index].equals("#")) cur.left = null;
            else {
                cur.left = new TreeNode(Integer.valueOf(arr[index]));
                q.offer(cur.left);
            }
            index++;
            if(arr[index].equals("#")) cur.right = null;
            else {
                cur.right = new TreeNode(Integer.valueOf(arr[index]));
                q.offer(cur.right);
            }
        }
        return root;
    }
}

//DFS
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val + ",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        ArrayDeque<String> deq = new ArrayDeque<>();
        for(String str:data.split(",")) {
            deq.offer(str);
        }
        return deserialize(deq);
    }

    private TreeNode deserialize(ArrayDeque<String> deq) {
        if(deq.size() == 0) return null;
        String first = deq.removeFirst();
        if(first.equals("#")) return null;
        TreeNode cur = new TreeNode(Integer.valueOf(first));
        cur.left = deserialize(deq);
        cur.right = deserialize(deq);
        return cur;
    }
}
