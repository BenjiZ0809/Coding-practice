public class Solution {
    /**
     * @param a: an integer array
     * @param v: an integer array
     * @param m: An integer
     * @return: an array
     */
    public int backPackIII(int[] a, int[] v, int m) {
        int n = a.length;
        int[][] dp = new int[n + 1][m + 1];

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(j < a[i - 1]) dp[i][j] = dp[i - 1][j];
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - a[i - 1]] + v[i - 1]);
                }
            }
        }
        return dp[n][m];
    }
}
