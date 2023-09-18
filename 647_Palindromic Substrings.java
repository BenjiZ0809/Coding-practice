// expand function
class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        for(int i=0; i<s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            res += len1 + len2;
        }
        return res;
    }

    public int expand(String s, int l, int r) {
        int res = 0;
        while(l >= 0 && r < s.length()) {
            if(s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                res++;
            }
            else break;
        }
        return res;
    }
}

// dp
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int res = 0;
        for(int i=0; i<n; i++) {
            dp[i][i] = true;
            res++;
        }
        for(int i=0; i<n-1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if(dp[i][i + 1]) res++;
        }

        for(int i=n-1; i>=0; i--) {
            for(int j=i+2; j<n; j++) {
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                if(dp[i][j]) res++;
            }
        }
        return res;
    }
}
