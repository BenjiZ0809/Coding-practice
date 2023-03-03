class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2 * k + 1];

        for(int i=1; i<=k; i++) {
            dp[0][2 * i - 1] = -prices[0];
        }

        for(int i=1; i<n; i++) {
            for(int j=1; j<=k; j++) {
                dp[i][2 * j - 1] = Math.max(dp[i - 1][2 * j - 1], dp[i - 1][2 * j - 2] - prices[i]);
                dp[i][2 * j] = Math.max(dp[i - 1][2 * j], dp[i - 1][2 * j - 1] + prices[i]);
            }
        }

        return Math.max(dp[n - 1][2 * k - 1], dp[n - 1][2 * k]);
    }
}
