class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        traverse(root);
        int left = binarySearch(arr, target);
        int right = left + 1;
        while(right - left - 1 < k) {
            if(left < 0) {
                right++;
                continue;
            }
            if(right >= arr.size()) {
                left--;
                continue;
            }
            if(target - arr.get(left) > arr.get(right) - target) right++;
            else left--;
        }
        List<Integer> res = new ArrayList<>();
        for(int i=left+1; i<right; i++) {
            res.add(arr.get(i));
        }
        return res;
    }

    List<Integer> arr = new ArrayList<>();
    private void traverse(TreeNode root) {
        if(root == null) return;
        traverse(root.left);
        arr.add(root.val);
        traverse(root.right);
    }

    private int binarySearch(List<Integer> arr, double target) {
        int n = arr.size();
        int left = 0;
        int right = n - 1;

        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(arr.get(mid) > target) {
                right = mid;
            }
            else {
                left = mid;
            }
        }

        return target - arr.get(left) <= arr.get(right) - target? left:right; 
    }
}
