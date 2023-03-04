public class Solution {
    /**
     * @param nums: the array
     * @return: the minimum times to flip digit
     */
    public int flipDigit(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int zero = 0;

        for(int i=0; i<n; i++) {
            if(nums[i] == 0) zero++;
            if(i == 0) dp[i] = 0;
            else {
                int min1 = nums[i] == 0? dp[i - 1]:dp[i - 1] + 1;
                int min2 = zero;
                dp[i] = Math.min(min1, min2);
            }
        }
        return dp[n - 1];
    }
}
