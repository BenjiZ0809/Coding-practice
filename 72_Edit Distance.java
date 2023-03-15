// top down
class Solution {
    int[][] memo;
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        memo = new int[n][m];
        for(int[] arr:memo) {
            Arrays.fill(arr, -1);
        }
        return dp(word1, word2, n - 1, m - 1);
    }

    public int dp(String word1, String word2, int i, int j) {
        if(i == -1) return j + 1;
        if(j == -1) return i + 1;
        if(memo[i][j] != -1) return memo[i][j];
        if(word1.charAt(i) == word2.charAt(j)) {
            memo[i][j] = dp(word1, word2, i - 1, j - 1);
        }
        else {
            memo[i][j] = min(dp(word1, word2, i, j - 1) + 1, dp(word1, word2,i - 1, j) + 1, dp(word1, word2, i - 1, j - 1) + 1);
        }
        return memo[i][j];
    }

    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}

// bottom up
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];

        // 索引偏移，因为这里index不能为负数，所以用0代表-1，所有索引往后移一位
        for(int i=1; i<=n; i++) {
            dp[i][0] = i;
        }
        for(int j=1; j<=m; j++) {
            dp[0][j] = j;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[n][m];
    }

    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
