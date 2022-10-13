class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = 0;
        for(int num:nums) {
            max = Math.max(max, num);
        }
        
        int start = 1;
        int end = max;
        
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            int thresh = getThreshold(nums, mid);
            if(thresh > threshold) start = mid;
            else end = mid;
        }
        
        if(getThreshold(nums, start) <= threshold) return start;
        if(getThreshold(nums, end) <= threshold) return end;
        return -1;
    }
    
    private int getThreshold(int[] nums, int x) {
        int sum = 0;
        for(int num:nums) {
            sum += (num / x) + (num % x == 0? 0:1);
        }
        return sum;
    }
}
