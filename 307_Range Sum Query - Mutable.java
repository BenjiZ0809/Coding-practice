class NumArray {
    TreeNode root;

    public NumArray(int[] nums) {
        this.root = buildTree(nums, 0, nums.length - 1);    
    }
    
    public void update(int index, int val) {
        update(root, index, val);
    }
    
    public int sumRange(int left, int right) {
        return getSum(root, left, right);
    }

    public void update(TreeNode node, int index, int val) {
        if(node.start == node.end) node.sum = val;
        else {
            int mid = node.start + (node.end - node.start) / 2;
            if(index <= mid) {
                update(node.left, index, val);
            }
            else {
                update(node.right, index, val);
            }
            node.sum = node.left.sum + node.right.sum;
        }
    }

    public int getSum(TreeNode node, int left, int right) {
        if(node.start == left && node.end == right) return node.sum;
        else {
            int mid = node.start + (node.end - node.start) / 2;
            if(right <= mid) {
                return getSum(node.left, left, right);
            }
            else if(left > mid) {
                return getSum(node.right, left, right);
            }
            else {
                return getSum(node.left, left, mid) + getSum(node.right, mid + 1, right);
            }
        }
    }

    public TreeNode buildTree(int[] nums, int start, int end) {
        if(start > end) return null;
        else if(start == end) {
            TreeNode node = new TreeNode(start, end);
            node.sum = nums[start];
            return node;
        }
        else {
            int mid = start + (end - start) / 2;
            TreeNode node = new TreeNode(start, end);
            node.left = buildTree(nums, start, mid);
            node.right = buildTree(nums, mid + 1, end);
            node.sum = node.left.sum + node.right.sum;
            return node;
        }
    }

    class TreeNode {
        int sum;
        int start, end;
        TreeNode left, right;

        public TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
