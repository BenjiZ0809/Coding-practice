class Solution {
    public boolean wordPatternMatch(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return backTrack(pattern, 0, s, 0, map, set);
    }

    private boolean backTrack(String pat, int i, String str, int j, Map<Character, String> map, Set<String> set) {
        if(i == pat.length() && j == str.length()) return true;
        if(i == pat.length() || j == str.length()) return false;

        char c = pat.charAt(i);
        if(map.containsKey(c)) {
            String s = map.get(c);
            if(!str.startsWith(s, j)) return false;
            return backTrack(pat, i + 1, str, j + s.length(), map, set);
        }

        for(int k=j; k<str.length(); k++) {
            String s = str.substring(j, k + 1);
            if(set.contains(s)) continue;
            map.put(c, s);
            set.add(s);
            if(backTrack(pat, i + 1, str, k + 1, map, set)) return true;
            map.remove(c);
            set.remove(s);
        }
        return false;
    }
}
