class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int[] arr:dp) Arrays.fill(arr, -1);
        int res = -1;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(dp[i][j] == -1) {
                    dfs(matrix, dp, i, j, -1);
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }

    public int dfs(int[][] matrix, int[][] dp, int x, int y, int prev) {
        int n = matrix.length;
        int m = matrix[0].length;
        if(x < 0 || x >= n || y < 0 || y >= m || matrix[x][y] <= prev) return 0;
        prev = matrix[x][y];
        if(dp[x][y] != -1) return dp[x][y];

        int res = -1;
        for(int k=0; k<4; k++) {
            int newX = x + dx[k];
            int newY = y + dy[k];
            int temp = dfs(matrix, dp, newX, newY, prev);
            res = Math.max(res, temp);
        }
        dp[x][y] = res + 1;
        return dp[x][y];
    }
}
