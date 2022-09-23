class Solution {
    public int longestSubstring(String s, int k) {
        int[] hash = new int[26];
        for(int i=0; i<s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        
        boolean fullStr = true;
        for(int i=0; i<s.length(); i++) {
            if(hash[s.charAt(i) - 'a'] > 0 && hash[s.charAt(i) - 'a'] < k) {
                fullStr = false;
            }
        }
        if(fullStr) return s.length();
        
        int start = 0;
        int end = 0;
        int res = 0;
        while(end < s.length()) {
            if(hash[s.charAt(end) - 'a'] < k) {
                res = Math.max(res, longestSubstring(s.substring(start, end), k));
                start = end + 1;
            }
            end++;
        }
        res = Math.max(res, longestSubstring(s.substring(start), k));
        return res;
    }
}
