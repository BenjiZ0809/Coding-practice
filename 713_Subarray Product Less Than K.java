class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        int prod = 1;
        int start = 0;
        int res = 0;
        
        for(int end=0; end<nums.length; end++) {
            prod *= nums[end];
            while(prod >= k) {
                prod /= nums[start++];
            }
            res += end - start + 1;
        }
        return res;
    }
}
