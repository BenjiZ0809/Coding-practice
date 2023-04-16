// Approach 1
class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int idx = n - 1;
        while(s.charAt(idx) == ' ') {
            idx--;
        }
        int count = 0;
        while(idx >= 0 && s.charAt(idx) != ' ') {
            idx--;
            count++;
        }
        return count;
    }
}

// Approach 2
class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int index = s.length() - 1;
        int count = 0;
        while(index >= 0 && s.charAt(index) != ' ') {
            index--;
            count++;
        }
        return count;
    }
}
