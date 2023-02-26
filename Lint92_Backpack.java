public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param a: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] a) {
        int n = a.length;
        int[][] dp = new int[n + 1][m + 1];

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(j < a[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - a[i - 1]] + a[i - 1]);
                }
            }
        }
        return dp[n][m];
    }
}
