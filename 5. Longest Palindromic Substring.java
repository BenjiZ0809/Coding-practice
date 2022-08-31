//expand() helper function approach
class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        for(int i=0; i<s.length(); i++){
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > end - start + 1){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end+1);
    }
    
    public int expand(String s, int l, int r){
        while(l >= 0 && r <= s.length() - 1 && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return r - l -1;
    }
}


//DP approach
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.equals("")) return "";
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        int longest = 1;
        int start = 0;
        for(int i=0; i<n; i++){
            dp[i][i] = true;
        }
        
        for(int i=0; i<n-1; i++){
            dp[i][i+1] = s.charAt(i) == s.charAt(i+1);
            if(dp[i][i+1]){
                longest = 2;
                start = i;
            }
        }
        
        for(int i=n-1; i>=0; i--){
            for(int j=i+2; j<n; j++){
                dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
                if(dp[i][j] && j - i + 1 > longest){
                    longest = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + longest);
    }
}
