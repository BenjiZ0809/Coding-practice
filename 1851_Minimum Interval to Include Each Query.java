class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;
        int[][] q = new int[n][2];
        int[] res = new int[n];
        for(int i=0; i<n; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }   
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Arrays.sort(q, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - a[0]) - (b[1] - b[0]));
        int j = 0;

        for(int i=0; i<n; i++) {
            int val = q[i][0];
            int index = q[i][1];
            while(j < intervals.length && intervals[j][0] <= val) pq.offer(intervals[j++]);
            while(!pq.isEmpty() && pq.peek()[1] < val) pq.poll();
            res[index] = pq.isEmpty()? -1 : pq.peek()[1] - pq.peek()[0] + 1;
        }
        return res;
    }
}
