class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for(int i=1; i<n; i++) {
            if(res.get(res.size() - 1)[1] < intervals[i][0]) {
                res.add(intervals[i]);
            }
            else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], intervals[i][1]);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
