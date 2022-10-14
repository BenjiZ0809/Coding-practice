class TimeMap {
    Map<String, List<Pair>> map;
    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair node = new Pair(value, timestamp);
        List<Pair> pairs = map.getOrDefault(key, new ArrayList<>());
        pairs.add(node);
        map.put(key, pairs);
    }
    
    public String get(String key, int timestamp) {
        List<Pair> pairs = map.getOrDefault(key, new ArrayList<>());
        if (pairs.size() == 0) return "";
        
        int start = 0;
        int end = pairs.size() - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(pairs.get(mid).time > timestamp) end = mid;
            else start = mid;
        }
        
        if(pairs.get(end).time <= timestamp) return pairs.get(end).value;
        if(pairs.get(start).time <= timestamp) return pairs.get(start).value;
        return "";
    }
    
    class Pair {
        String value;
        int time;
        public Pair(String value, int time) {
            this.value = value;
            this.time = time;
        }
    }
}
