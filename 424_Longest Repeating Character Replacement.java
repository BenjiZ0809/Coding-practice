class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int res = 0;
        char[] arr = new char[26];

        while(right < s.length()) {
            arr[s.charAt(right) - 'A']++;
            maxLen = Math.max(maxLen, arr[s.charAt(right) - 'A']);
            while(right - left + 1 - maxLen > k) {
                arr[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
