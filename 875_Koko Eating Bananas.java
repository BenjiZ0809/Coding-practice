class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int num:piles) {
            max = Math.max(max, num);
        }
        
        int start = 1;
        int end = max;
        
        while(start  + 1 < end) {
            int mid = start + (end - start) / 2;
            if(getTime(piles, mid) > h) start = mid;
            else end = mid;
        }
        
        if(getTime(piles, start) <= h) return start;
        if(getTime(piles, end) <= h) return end;
        return -1;
    }
    
    private int getTime(int[] piles, int speed) {
        int time = 0;
        for(int num:piles) {
            time += Math.ceil((double)num / speed);
        }
        return time;
    }
}
