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
