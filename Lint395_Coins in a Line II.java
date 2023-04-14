public class Solution {
    public boolean firstWillWin(int[] values) {
        int n = values.length;
        if(n == 0) return false;
        if(n <= 2) return true;
        int[] dp = new int[n + 1];
        int[] sum = new int[n + 1];
        dp[0] = sum[0] = 0;
        dp[1] = sum[1] = values[n - 1];
        dp[2] = sum[2] = values[n - 1] + values[n - 2];

        for(int i=3; i<=n; i++) {
            int oneCoin = values[n - i] + (sum[i - 1] - dp[i - 1]);
            int twoCoin = values[n - i] + values[n - i + 1] + (sum[i - 2] - dp[i - 2]);
            dp[i] = Math.max(oneCoin, twoCoin);
            sum[i] = sum[i - 1] + values[n - i];
        }

        int firstHand = dp[n];
        int secondHand = sum[n] - dp[n];
        return firstHand > secondHand;
    }
}
