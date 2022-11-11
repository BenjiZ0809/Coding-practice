//BFS
class Solution {
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];

        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j] == 0) q.offer(new int[]{i, j});
                else res[i][j] = Integer.MAX_VALUE;
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            for(int k=0; k<4; k++) {
                int newX = curX + dx[k];
                int newY = curY + dy[k];
                if(isValid(mat, newX, newY)) {
                    if(res[newX][newY] > res[curX][curY] + 1) {
                        res[newX][newY] = res[curX][curY] + 1;
                        q.offer(new int[]{newX, newY});
                    }
                }
            }
        }
        return res;
    }

    private boolean isValid(int[][] mat, int x, int y) {
        int m = mat.length;
        int n = mat[0].length;
        if(x < 0 || x >= m || y < 0 || y >= n) return false;
        return true;
    }
}

//DP
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j] == 1) {
                    dp[i][j] = Integer.MAX_VALUE - 100000;
                    if(i > 0) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                    if(j > 0) dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }

        for(int i=m-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                if(mat[i][j] == 1) {
                    if(i < m - 1) dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                    if(j < n - 1) dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }
        return dp;
    }
}
