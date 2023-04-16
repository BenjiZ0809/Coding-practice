class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for(int i=1; i<strs.length; i++) {
            int idx = prefix.length() - 1;
            while(idx >= 0) {
                if(!strs[i].startsWith(prefix)) {
                    idx--;
                    prefix = prefix.substring(0, idx + 1);
                    continue;
                }
                else break;
            }
        }
        return prefix;
    }
}


// Approach 2
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for(int i=1; i<strs.length; i++) {
            prefix = getCommon(prefix, strs[i]);
        }
        return prefix;
    }

    private String getCommon(String s, String t) {
        int l = 0;
        int r = 0;
        while(l < s.length() && r < t.length()) {
            if(s.charAt(l) == t.charAt(r)) {
                l++;
                r++;
            }
            else break;
        } 
        return s.substring(0, l);
    }
}
