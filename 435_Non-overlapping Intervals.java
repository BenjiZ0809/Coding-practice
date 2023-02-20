class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int res = 0;
        int[] prev = intervals[0];

        for(int i=1; i<n; i++) {
            int[] cur = intervals[i];
            if(prev[1] > cur[0]) {
                res++;
                if(prev[1] > cur[1]) {
                    prev = cur;
                }
            }   
            else prev = cur;
        }
        return res;
    }
}
