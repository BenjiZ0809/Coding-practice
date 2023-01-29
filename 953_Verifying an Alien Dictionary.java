class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for(int i=1; i<words.length; i++) {
            if(isValid(words[i - 1], words[i], map)) continue;
            else return false;
        }
        return true;
    }

    private boolean isValid(String s1, String s2, Map<Character, Integer> map) {
        int a = 0;
        int b = 0;

        while(a < s1.length() && b < s2.length()) {
            if(map.get(s1.charAt(a)) > map.get(s2.charAt(b))) return false;
            else if(map.get(s1.charAt(a)) < map.get(s2.charAt(b))) return true;
            else {
                a++;
                b++;
            }
        }

        return a < s1.length()? false:true;
    }
}
