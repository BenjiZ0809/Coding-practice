class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[mid - 1]) right = mid;
            else if(nums[mid] < nums[mid + 1]) left = mid;
            else return mid;
        }
        
        return nums[left] > nums[right]? left:right;
    }
}
