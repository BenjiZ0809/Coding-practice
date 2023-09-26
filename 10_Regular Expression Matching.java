// class Solution {
//     public boolean isMatch(String s, String p) {
//         int n = s.length();
//         int m = p.length();
//         s = " " + s;
//         p = " " + p;
//         boolean[][] dp = new boolean[n + 1][m + 1];
//         dp[0][0] = true;

//         for(int i=0; i<=n; i++) {
//             for(int j=1; j<=m; j++) {
//                 if(j + 1 <= m && p.charAt(j + 1) == '*') continue;
//                 if(p.charAt(j) != '*') {
//                     dp[i][j] = (i > 0 && j > 0 && dp[i - 1][j - 1]) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
//                 }
//                 else {
//                     dp[i][j] = (j >=2 && dp[i][j - 2]) || ((i > 0 && dp[i - 1][j]) && (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.')); 
//                 }
//             }
//         }
//         return dp[n][m];
//     }
// }

class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for(int j=1; j<=m; j++) {
            if(p.charAt(j - 1) == '*' && dp[0][j - 2]) dp[0][j] = true;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(j < m && p.charAt(j) == '*') continue;
                if(p.charAt(j - 1) != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                }
                else {
                    dp[i][j] = dp[i][j - 2] || dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.');
                }
            }
        }
        return dp[n][m];
    }
}
