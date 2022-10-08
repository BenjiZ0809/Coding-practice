class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if(nums.length == 0) return res;
        int left = 0;
        int right = nums.length - 1;
        
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target) right = mid;
            else left = mid;
        }
        
        if(nums[left] == target) right = left;
        else if(nums[right] == target) left = right;
        else return res;
        
        while(right < nums.length && nums[right] == target) right++;
        right--;
        res[0] = left;
        res[1] = right;
        
        return res;
    }
}
