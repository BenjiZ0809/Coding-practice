class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n][k];

        for(int i=0; i<k; i++) {
            dp[0][i] = costs[0][i];
        }

        for(int i=1; i<n; i++) {
            for(int j=0; j<k; j++) {
                int temp = Integer.MAX_VALUE;
                for(int l=0; l<k; l++) {
                    if(l == j) continue;
                    temp = Math.min(temp, dp[i - 1][l]);
                }
                dp[i][j] = costs[i][j] + temp;
            }
        }

        int res = Integer.MAX_VALUE;
        for(int i=0; i<k; i++) {
            res = Math.min(res, dp[n - 1][i]);
        }
        return res;
    }
}
