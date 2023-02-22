class LFUCache {
    Map<Integer, Integer> kv;
    Map<Integer, Integer> kf;
    Map<Integer, LinkedHashSet<Integer>> fk;
    int cap;
    int min;

    public LFUCache(int capacity) {
        this.cap = capacity;
        this.min = 0;
        this.kv = new HashMap<>();
        this.kf = new HashMap<>();
        this.fk = new HashMap<>();    
    }
    
    public int get(int key) {
        if(kv.containsKey(key)) {
            increaseFreq(key);
            return kv.get(key);
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if(kv.containsKey(key)) {
            kv.put(key, value);
            increaseFreq(key);
            return;
        }
        else {
            if(kv.size() >= cap) {
                removeMinFreq();
            }
            kv.put(key, value);
            kf.put(key, 1);
            fk.putIfAbsent(1, new LinkedHashSet<>());
            fk.get(1).add(key);
            min = 1;
            return;
        }
    }

    private void increaseFreq(int key) {
        int freq = kf.get(key);
        kf.put(key, freq + 1);
        fk.putIfAbsent(freq + 1, new LinkedHashSet<>());
        fk.get(freq + 1).add(key);
        fk.get(freq).remove(key);
        if(fk.get(freq).isEmpty()) {
            fk.remove(freq);
            if(freq == min) min++;
        }
    }

    private void removeMinFreq() {
        LinkedHashSet<Integer> keySet = fk.get(min);
        int del = keySet.iterator().next();
        kv.remove(del);
        kf.remove(del);
        keySet.remove(del);
        if(fk.get(min).isEmpty()) fk.remove(min);
    }
}
