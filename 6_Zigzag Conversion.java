class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        int x = 2 * (numRows - 1);
        char[] arr = new char[s.length()];
        int index = 0;
        for(int i=0; i<numRows; i++) {
            for(int j=i; j<s.length(); j+=x) {
                arr[index++] = s.charAt(j);
                if(i > 0 && i < numRows - 1 && j + x - 2 * i < s.length()) {
                    arr[index++] = s.charAt(j + x - 2 * i);
                }
            }
        }
        return new String(arr);
    }
}
