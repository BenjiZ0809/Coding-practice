class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0;
        int right = 0;
        int longest = 0;
        
        while(right < s.length() - 1) {
            if(!window.contains(s.charAt(right))) {
                window.add(s.charAt(right));
                right++;
            }
            else {
                window.remove(s.charAt(left));
                left++;
            }
            longest = Math.max(longest, (right - left));
        }
        return longest;
    }
}
