class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> mapA = new HashMap<>();
        for(String str:words) {
            mapA.put(str, mapA.getOrDefault(str, 0) + 1);
        }

        Map<Integer, List<String>> mapB = new HashMap<>();
        for(String str:mapA.keySet()) {
            List<String> list = mapB.getOrDefault(mapA.get(str), new ArrayList<>());
            list.add(str);
            Collections.sort(list);
            mapB.put(mapA.get(str), list);
        }

        int count = 0;
        for(int i=words.length; i>0; i--) {
            if(mapB.get(i) != null) {
                for(String str:mapB.get(i)) {
                    if(count >= k) break;
                    res.add(str);
                    count++;
                }
            }
        }
        return res;
    }
}
