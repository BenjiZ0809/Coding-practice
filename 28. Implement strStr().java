//Two pointer approach
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.equals("")) return 0;
        int m = haystack.length();
        int n = needle.length();
        int hayPointer = 0;
        int needlePointer = 0;
        while(hayPointer < m && needlePointer < n) {
            if(haystack.charAt(hayPointer) == needle.charAt(needlePointer)) {
                hayPointer++;
                needlePointer++;
            }
            else {
                hayPointer = hayPointer - needlePointer + 1;
                needlePointer = 0;
            }
        }
        
        return needlePointer == n? hayPointer - needlePointer:-1;
    }
}
