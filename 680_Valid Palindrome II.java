class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while(r > l) {
            if(s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            }
            else{
                return isPalindrome(s, l+1, r) || isPalindrome(s, l, r-1);
            }
        }
        return true;
    }
    
    public boolean isPalindrome(String s, int l, int r) {
        while(r > l) {
            char leftChar = s.charAt(l);
            char rightChar = s.charAt(r);
            if(leftChar != rightChar) return false;
            l++;
            r--;
        }
        return true;
    }
}
