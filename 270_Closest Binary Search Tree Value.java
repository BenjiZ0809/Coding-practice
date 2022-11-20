//Approach 1
class Solution {
    public int closestValue(TreeNode root, double target) {
        traverse(root, target);
        return res;
    }

    double dif = 100;
    int res;
    private void traverse(TreeNode root, double tar) {
        if(root == null) return;
        if(root.val > tar) traverse(root.left, tar);
        else traverse(root.right, tar);
        double differ = Math.abs(root.val - tar);
        if(differ > dif) return;
        dif = differ;
        res = root.val;
    }
}

//Approach 2 lower/upper bound recursive
class Solution {
    public int closestValue(TreeNode root, double target) {
        TreeNode low = lower(root, target);
        TreeNode up = upper(root, target);
        if(low == null || up == null) return low == null? up.val:low.val;
        else return Math.abs(low.val - target) > Math.abs(up.val - target)? up.val:low.val;
    }

    private TreeNode lower(TreeNode node, double target) {
        if(node == null) return null;
        if(node.val > target) {
            return lower(node.left, target);
        }
        TreeNode low = lower(node.right, target);
        return low == null? node:low;
    }

    private TreeNode upper(TreeNode node, double target) {
        if(node == null) return null;
        if(node.val < target) {
            return upper(node.right, target);
        }
        TreeNode up = upper(node.left, target);
        return up == null? node:up;
    }
}

//Approach 3 lower/upper iterative
class Solution {
    public int closestValue(TreeNode root, double target) {
        TreeNode low = root;
        TreeNode up = root;

        while(root != null) {
            if(root.val > target) {
                up = root;
                root = root.left;
            }
            else if(root.val < target) {
                low = root;
                root = root.right;
            }
            else return root.val;
        }
        return Math.abs(low.val - target) > Math.abs(up.val - target)? up.val:low.val;
    }
}

//Approach 4 inOrder -> binart search (TLE)
class Solution {
    public int closestValue(TreeNode root, double target) {
        inOrder(root);
        int left = 0;
        int right = arr.size() - 1;

        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(arr.get(mid) > target) right = mid;
            else if(arr.get(mid) < target) left = mid;
        }

        return Math.abs(arr.get(left) - target) > Math.abs(arr.get(right) - target)? arr.get(right):arr.get(left);
    }

    List<Integer> arr = new ArrayList<>();
    private void inOrder(TreeNode root) {
        if(root == null) return;
        inOrder(root.left);
        arr.add(root.val);
        inOrder(root.right);
    }
}
