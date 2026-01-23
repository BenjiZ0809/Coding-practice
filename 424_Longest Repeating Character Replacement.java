class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int len = 0;
        int res = 0;
        int[] arr = new int[26];
        while(r < s.length()) {
            arr[s.charAt(r) - 'A']++;
            len = Math.max(len, arr[s.charAt(r) - 'A']);
            while(r - l + 1 - len > k) {
                arr[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}
