class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while(r > l) {
            while(r > l && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            char leftChar = Character.toLowerCase(s.charAt(l));
            
            while(r > l && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            char rightChar = Character.toLowerCase(s.charAt(r));
            
            if(leftChar != rightChar) return false;
            
            l++;
            r--;
        }
        return true;
    }
}
