class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[left]) {
                if(target >= nums[left] && target <= nums[mid]) right = mid;
                else left = mid;
            }
            else {
                if(target >= nums[mid] && target <= nums[right]) left = mid;
                else right = mid;
            }
        }
        
        if(nums[left] == target) return left;
        if(nums[right] == target) return right;
        return -1;
    }
}
