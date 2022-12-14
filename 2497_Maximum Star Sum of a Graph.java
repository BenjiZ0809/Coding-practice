class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int n = vals.length;
        Map<Integer, Queue<Integer>> graph = buildGraph(vals, edges);
        int res = Integer.MIN_VALUE;

        for(int num:graph.keySet()) {
            int cur = 0;
            cur += vals[num];
            res = Math.max(res, cur);
            int len = Math.min(graph.get(num).size(), k);
            for(int i=0; i<len; i++) {
                cur += graph.get(num).poll();
                res = Math.max(res, cur);
            }
        }
        return res;
    }

    private Map<Integer, Queue<Integer>> buildGraph(int[] vals, int[][] edges) {
        int n = vals.length;
        Map<Integer, Queue<Integer>> graph = new HashMap<>();

        for(int i=0; i<n; i++) graph.put(i, new PriorityQueue<>((a, b) -> b - a));

        for(int[] edge:edges) {
            int from = edge[0];
            int to = edge[1];
            Queue<Integer> neighbor = graph.get(from);
            neighbor.offer(vals[to]);
            graph.put(from, neighbor);
            neighbor = graph.get(to);
            neighbor.offer(vals[from]);
            graph.put(to, neighbor);
        }
        return graph;
    }
}
