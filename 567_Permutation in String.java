class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];
        
        for(int i=0; i<len1; i++) {
            hash1[s1.charAt(i) - 'a']++;
        }
        
        for(int i=0; i<len2; i++) {
            if(i >= len1) {
                hash2[s2.charAt(i - len1) - 'a']--;
            }
            hash2[s2.charAt(i) - 'a']++;
            if(Arrays.equals(hash1, hash2)) return true;
        }
        return false;
    }
}
