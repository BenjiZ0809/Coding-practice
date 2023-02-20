class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();

        for(int i=0; i<n; i++) {
            int[] cur = intervals[i];
            if(newInterval == null || newInterval[0] > cur[1]) {
                res.add(cur);
            }
            else if(newInterval[1] < cur[0]) {
                res.add(newInterval);
                res.add(cur);
                newInterval = null;
            }
            else {
                newInterval[0] = Math.min(newInterval[0], cur[0]);
                newInterval[1] = Math.max(newInterval[1], cur[1]);
            }
        }
        if(newInterval != null) {
            res.add(newInterval);
        }
        return res.toArray(new int[res.size()][2]);
    }
}
