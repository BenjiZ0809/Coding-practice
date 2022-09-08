//With 2 HashMap
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for(int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        for(int num : nums2) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> res = new ArrayList<>();
        for(int num : map1.keySet()) {
            if(map2.containsKey(num)) {
                for(int i=0; i<Math.min(map1.get(num), map2.get(num)); i++) {
                    res.add(num);
                }
            }
        }
        
        int[] ans = new int[res.size()];
        for(int i=0; i<res.size(); i++) {
            ans[i] = res.get(i);    
        }
        
        return ans;
    }
}

//Wtih one HashMap
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length) return intersect(nums2, nums1);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int index = 0;
        for(int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if(count > 0) {
                nums1[index++] = num;
                map.put(num, map.get(num) - 1);
            }
        }
        
        return Arrays.copyOf(nums1, index);
    }
}
