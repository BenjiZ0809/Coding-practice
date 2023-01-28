class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        int res = 0;

        for(int n:nums) {
            map.put(n, false);
        }

        for(int n:nums) {
            if(map.get(n)) continue;
            int count = 1;
            int left = n - 1;
            int right = n + 1;

            while(map.containsKey(left)) {
                map.put(left, true);
                count++;
                left--;
            }
            while(map.containsKey(right)) {
                map.put(right, true);
                count++;
                right++;
            }

            res = Math.max(count, res);
        }
        return res;
    }
}
