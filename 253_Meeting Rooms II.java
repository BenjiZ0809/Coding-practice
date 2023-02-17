class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i=0; i<n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int s = 0, e = 0, count = 0, res = 0;
        while(s < n) {
            if(end[e] > start[s]) {
                count++;
                res = Math.max(res, count);
                s++;
            }
            else {
                count--;
                e++;
            }
        }
        return res;
    }
}
