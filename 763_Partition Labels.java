class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] occ = new int[26];
        for(int i=0; i<n; i++) {
            occ[s.charAt(i) - 'a'] = i;
        }
        int end = 0;
        int size = 0;
        List<Integer> res = new ArrayList<>();

        for(int i=0; i<n; i++) {
            end = Math.max(end, occ[s.charAt(i) - 'a']);
            size++;
            if(end == i) {
                res.add(size);
                size = 0;
            }
        }
        return res;
    }
}
