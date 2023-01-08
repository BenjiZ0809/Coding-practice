class Solution {
    public int compress(char[] chars) {
        int start = 0;
        int end = 0;
        int spaceCount = 0;

        while(end < chars.length) {
            char first = chars[start];
            char last = chars[end];
            while(end < chars.length && first == last) {
                end++;
                if(end == chars.length) break;
                last = chars[end];
            }  

            int count = end - start;
            if(count == 1) {
                start = end;
            }
            else {
                start++;
                String str = count + "";
                for(int i=0; i<str.length(); i++) {
                    chars[start++] = str.charAt(i);
                }
            }

            while(start < end) {
                chars[start++] = ' ';
                spaceCount++;
            }
        }
        int res = chars.length - spaceCount;
        start = 0;
        while(start < chars.length && chars[start] != ' ') start++;
        end = start;
        while(end < chars.length && chars[end] == ' ') end++;
        while(end < chars.length) {
            while(end < chars.length && chars[end] == ' ') end++;
            if(end == chars.length) break;
            chars[start++] = chars[end++];
        }
        return res;
    }
}
