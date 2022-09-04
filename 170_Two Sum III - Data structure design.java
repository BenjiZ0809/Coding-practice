class TwoSum {
    Map<Integer, Integer> map;
    public TwoSum() {
        this.map = new HashMap<>();
    }
    
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    public boolean find(int value) {
        for(int num:map.keySet()) {
            if(num == value - num) {
                if(map.get(num) >= 2) return true;
            }
            else {
                if(map.getOrDefault(value - num, 0) >= 1) return true;
            }
        }
        return false;
    }
}
//Can't use HashSet, need to use HashMap for duplica numbers
