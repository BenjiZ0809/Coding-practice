//Sliding window approach
class Solution {
    public String minWindow(String s1, String s2) {
        int j = 0;
        int minLen = s1.length() + 1;
        int start = 0;
        
        for(int i=0; i<s1.length(); i++) {
            if(s1.charAt(i) == s2.charAt(j)) {
                if(j == s2.length() - 1) {
                    int end = i + 1;
                    while(j >= 0) {
                        if(s1.charAt(i) == s2.charAt(j)) {
                            i--;
                            j--;
                        }
                        else i--;
                    }
                    i++;
                    j++;
                    if(minLen > end - i) {
                        minLen = end - i;
                        start = i;
                    }
                }
                else j++;
            }
        }
        return minLen == s1.length() + 1? "" : s1.substring(start, start + minLen);
    }
}
