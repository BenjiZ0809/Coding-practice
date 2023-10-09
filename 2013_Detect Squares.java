class DetectSquares {
    Map<List<Integer>, Integer> map;
    public DetectSquares() {
        this.map = new HashMap<>();
    }
    
    public void add(int[] point) {
        List<Integer> key = new ArrayList<>();
        key.add(point[0]);
        key.add(point[1]);
        map.put(key, map.getOrDefault(key, 0) + 1);
    }
    
    public int count(int[] point) {
        int px = point[0];
        int py = point[1];
        int res = 0;
        for(List<Integer> cur:map.keySet()) {
            int x = cur.get(0);
            int y = cur.get(1);
            if(!(Math.abs(px - x) == Math.abs(py - y)) || px == x || py == y) continue;
            List<Integer> a = Arrays.asList(new Integer[]{px, y});
            List<Integer> b = Arrays.asList(new Integer[]{x, py});
            // 这里也可以用List.of(px, y) 和 List.of(x, py) 来代替a,b
            res += map.getOrDefault(a, 0) * map.getOrDefault(b, 0) * map.get(cur);
        }
        return res;
    }
}
