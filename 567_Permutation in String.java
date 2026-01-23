class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for(char ch:s1.toCharArray()) arr1[ch - 'a']++;
        int l = 0;
        int r = 0;
        while(r < s2.length()) {
            char ch = s2.charAt(r);
            arr2[ch - 'a']++;
            while(r - l + 1 > s1.length()) {
                char del = s2.charAt(l);
                arr2[del - 'a']--;
                l++;
            }
            if(r - l + 1 == s1.length()) {
                if (Arrays.equals(arr1, arr2)) return true;
            }
            r++;
        }
        return false;
    }
}
