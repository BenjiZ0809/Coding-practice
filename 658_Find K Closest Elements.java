class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int right = binarySearch(arr, x);
        int left = right-1;
        
        while(right - left - 1 < k) {
            if(left < 0) {
                right++;
                continue;
            }
            if(right == arr.length || (x - arr[left]) <= (arr[right] - x)) left--;
            else right++;
        }
        
        for(int i=left+1; i<right; i++) {
            res.add(arr[i]);
        }
        return res;
    }
    
    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < target) left = mid;
            else right = mid;
        }
        
        if(nums[left] >= target) return left;
        if(nums[right] >= target) return right;
        return nums.length;
    }
}
