class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;

    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();    
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int index = map.get(val);
        map.put(list.get(list.size() - 1), index);
        map.remove(val);
        list.set(index, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        return true;
    }
    
    public int getRandom() {
        int index = (int)(Math.random() * list.size());
        return list.get(index);
    }
}
