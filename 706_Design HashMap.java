class MyHashMap {
    private int space;
    private List<Bucket> table;

    public MyHashMap() {
        this.space = 2069;
        this.table = new ArrayList<>();
        for(int i=0; i<space; i++) {
            table.add(new Bucket());
        }    
    }
    
    public void put(int key, int value) {
        int hashKey = key % space;
        table.get(hashKey).update(key, value);
    }
    
    public int get(int key) {
        int hashKey = key % space;
        return table.get(hashKey).get(key);
    }
    
    public void remove(int key) {
        int hashKey = key % space;
        table.get(hashKey).remove(key);
    }
}

class Pair {
    int key;
    int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class Bucket {
    private List<Pair> bucket;

    public Bucket() {
        this.bucket = new LinkedList<>();
    }

    public Integer get(int key) {
        for(Pair pair:bucket) {
            if(pair.key == key) return pair.value;
        }
        return -1;
    }

    public void update(int key, int value) {
        boolean found = false;
        for(Pair pair:bucket) {
            if(pair.key == key) {
                pair.value = value;
                found = true;
            }
        }
        if(!found) {
            bucket.add(new Pair(key, value));
        }
    }

    public void remove(int key) {
        for(Pair pair:bucket) {
            if(pair.key == key) {
                bucket.remove(pair);
                break;
            }
        }
    }
}
