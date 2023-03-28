public class Solution {
    /**
     * @param n: An integer
     * @return: A boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        if(n == 0) return false;
        boolean[] dp = new boolean[n + 1];
        dp[1] = true;
        for(int i=2; i<=n; i++) {
            dp[i] = !(dp[i - 1] && dp[i - 2]);
        }
        return dp[n];
    }
}
