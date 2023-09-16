class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(nums.length == 1) return nums[0];
        return Math.max(dp(nums, 0, n - 2), dp(nums, 1, n - 1));
    }

    public int dp(int[] nums, int start, int end) {
        if(start == end) return nums[start];
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);

        for(int i=start+2; i<=end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end];
    }
}
