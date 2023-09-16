// PQ
class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(int key:map.keySet()) {
            pq.offer(new int[] {key, map.get(key)});
        }

        while(pq.size() > 1) {
            int[] a = pq.poll();
            int[] b = pq.poll();

            a[1] -= 1;
            b[1] -= 1;

            if(a[1] != 0) pq.offer(a);
            if(b[1] != 0) pq.offer(b);
        }

        int res = 0;
        while(!pq.isEmpty()) {
            res += pq.poll()[1];
        }
        return res;
        
    }
}

// two pointer
class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        int i = 0;
        Set<Integer> removed = new HashSet<>();
        for (int j = nums.size() / 2; j < nums.size(); j ++) {
            if (nums.get(j) > nums.get(i) && !removed.contains(i) ) {
                removed.add(i);
                removed.add(j);
                i ++;
            }
        }
        return nums.size() - removed.size();
    }
}
