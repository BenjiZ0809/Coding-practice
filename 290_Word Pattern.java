class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if(pattern.length() != arr.length) return false;
        Map<Character, String> charMap = new HashMap<>();
        Map<String, Character> wordMap = new HashMap<>();
        
        for(int i=0; i<pattern.length(); i++) {
            if(!charMap.containsKey(pattern.charAt(i))) {
                if(wordMap.containsKey(arr[i])) return false;
                else {
                    charMap.put(pattern.charAt(i), arr[i]);
                    wordMap.put(arr[i], pattern.charAt(i));
                }
            }
            else {
                String cur = charMap.get(pattern.charAt(i));
                if(!cur.equals(arr[i])) return false;
            }
        }
        return true;
    }
}
