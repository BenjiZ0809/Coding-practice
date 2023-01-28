class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String str:strs) {
            char[] arr = new char[26];
            for(int i=0; i<str.length(); i++) {
                arr[str.charAt(i) - 'a']++;
            }
            String key = String.valueOf(arr);
            if(map.containsKey(key)) {
                map.get(key).add(str);
            }
            else {
                map.put(key, new ArrayList<>());
                map.get(key).add(str);
            }
        }

        for(String str:map.keySet()) {
            res.add(map.get(str));
        }
        return res;
    }
}
