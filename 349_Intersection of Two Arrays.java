class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for(int num : nums1) set1.add(num);
        Set<Integer> set2 = new HashSet<>();
        for(int num : nums2) set2.add(num);
        
        if(set1.size() < set2.size()) return intersection(set1, set2);
        else return intersection(set2, set1);
    }
    
    public int[] intersection(Set<Integer> set1, Set<Integer> set2) {
        int[] res = new int[set1.size()];
        int index = 0;
        for(int num : set1) {
            if(set2.contains(num)) {
                res[index++] = num;
            } 
        }
        return Arrays.copyOf(res, index);
    }
}
