class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        int start = 0;
        int minLen = s.length() + 1;
        int subStr = 0;
        int matched = 0;
        
        for(int end=0; end<s.length(); end++) {
            char right = s.charAt(end);
            if(map.containsKey(right)) {
                map.put(right, map.get(right) - 1);
                if(map.get(right) == 0) matched++;
            }
            
            while(matched == map.size()) {
                if(minLen > end - start + 1) {
                    minLen = end - start + 1;
                    subStr = start;
                }
                char del = s.charAt(start);
                start++;
                if(map.containsKey(del)) {
                    if(map.get(del) == 0) matched--;
                    map.put(del, map.get(del) + 1);
                }
            }
        }
        return minLen == s.length() + 1? "" : s.substring(subStr, subStr + minLen);
    }
}
