class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0 || nums == null) return false;
        int left = 0;
        int right = nums.length - 1;
        
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
                continue;
            }
            if(nums[mid] <= nums[right]) {
                if(target >= nums[mid] && target <= nums[right]) left = mid;
                else right = mid;
            }
            else {
                if(target >= nums[left] && target <= nums[mid]) right = mid;
                else left = mid;
            }
        }
        
        if(nums[left] == target || nums[right] == target) return true;
        return false;
    }
}
