class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int res = nums.length + 1;
        int sum = 0;
        
        while(right < nums.length) {
            while(right < nums.length && sum < target) {
                sum += nums[right];
                right++;
            }
            while(left < nums.length && sum >= target) {
                res = Math.min(res, right - left);
                sum -= nums[left];
                left++;
            }
        }
        return res == nums.length + 1? 0 : res;
    }
}
