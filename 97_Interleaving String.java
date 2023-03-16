class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        if(n + m != s3.length()) return false;
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for(int i=1; i<=n; i++) {
            dp[i][0] = s1.substring(0, i).equals(s3.substring(0, i));
        }
        for(int i=1; i<=m; i++) {
            dp[0][i] = s2.substring(0, i).equals(s3.substring(0, i));
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i - 1][j];
                }
                if(s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j - 1] || dp[i][j];
                }
            }
        }
        return dp[n][m];
    }
}
