class Solution {
    public int mySqrt(int x) {
        if(x < 2) return x;
        
        int start = 1;
        int end = x / 2;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if((long)mid * mid < x) start = mid;
            else end = mid;
        }
        
        if((long)end * end <= x) return end;
        if((long)start * start <= x) return start;
        return -1;
    }
}
