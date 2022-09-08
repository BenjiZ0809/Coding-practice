//PriorityQueue approach time:O(nlogk)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) -map.get(a));
        for(int num : map.keySet()) {
            pq.offer(num);
        }
        
        int[] res = new int[k];
        for(int i=0; i<k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}

//Bucket sort approach time:O(n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        Map<Integer, List<Integer>> bucket = new HashMap<>();
        for(int num : count.keySet()) {
            int freq = count.get(num);
            List<Integer> minires = bucket.getOrDefault(freq, new ArrayList<>());
            minires.add(num);
            bucket.put(freq, minires);
        }
        
        int[] res = new int[k];
        int index = 0;
        for(int i=nums.length; i>=0; i--) {
            if(bucket.get(i) != null) {
                for(int num : bucket.get(i)) {
                    if(index >= k) break;
                    res[index++] = num;
                }
            }
        }
        return res;
    }
}
