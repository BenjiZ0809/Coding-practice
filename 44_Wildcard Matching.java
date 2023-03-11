class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        s = " " + s;
        p = " " + p;
        dp[0][0] = true;

        for(int i=0; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(p.charAt(j) != '*') {
                    dp[i][j] = (i >= 1 && j >= 1 && dp[i - 1][j - 1]) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?');
                }
                else {
                    dp[i][j] = (j >= 1 && dp[i][j - 1]) ||( i >= 1 && dp[i - 1][j]);
                }
            }
        }
        return dp[n][m];
    }
}
