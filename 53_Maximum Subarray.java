//DP approach
class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        
        for(int i=1; i<nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
        }
        
        int max = dp[0];
        for(int num:dp) {
            if(num > max) max = num;
        }
        return max;
    }
}

//Kadane Algorithm
class Solution {
    public int maxSubArray(int[] nums) {
        int curMax = 0;
        int max = nums[0];
        
        for(int i=0; i<nums.length; i++) {
            curMax += nums[i];
            if(curMax > max) max = curMax;
            if(curMax < 0) curMax = 0;
        }
        return max;
    }
}
