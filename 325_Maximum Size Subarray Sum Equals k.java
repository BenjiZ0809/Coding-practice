class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int curSum = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        //map.put(0, -1);
        
        for(int i=0; i<nums.length; i++) {
            curSum += nums[i];
            if(curSum == k) res = i + 1;
            if(map.containsKey(curSum - k)) {
                res = Math.max(res, i - map.get(curSum - k));
            }
            if(!map.containsKey(curSum)) {
                map.put(curSum, i);
            }
            
        }
        return res;
    }
}
