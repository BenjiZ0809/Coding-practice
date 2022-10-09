class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == nums[left] && nums[mid] == nums[right]) {
                left++;
                right--;
                continue;
            }
            else if(nums[mid] <= nums[right]) {
                right = mid;
            }
            else left = mid;
        }
        
        return nums[left] <= nums[right]? nums[left]:nums[right];
    }
}
