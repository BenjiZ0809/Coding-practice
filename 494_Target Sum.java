// DP
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum - Math.abs(target) < 0 || (sum + target) % 2 != 0) return 0;
        sum = (sum + target) / 2;
        int n = nums.length;
        int[][] dp = new int[n + 1][sum + 1];
        dp[0][0] = 1;
        for(int i=1; i<=n; i++) {
            for(int j=0; j<=sum; j++) {
                if(j - nums[i - 1] < 0) dp[i][j] = dp[i - 1][j];
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }
}

// backTrack
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        backTrack(nums, 0, 0, target);
        return count;
    }

    int count = 0;
    private void backTrack(int[] nums, int index, int sum, int tar) {
        if(index == nums.length && sum == tar) {
            count++;
        }
        if(index == nums.length) return;
        
        backTrack(nums, index + 1, sum + nums[index], tar);
        backTrack(nums, index + 1, sum - nums[index], tar);   
    }
}
