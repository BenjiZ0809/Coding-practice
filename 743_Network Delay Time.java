class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n + 1];
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge:times) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph[from].add(new int[]{to, weight});
        }

        int[] distTo = dijkstra(graph, k);
        int res = 0;
        for(int i=1; i<=n; i++) {
            if(distTo[i] == Integer.MAX_VALUE) return -1;
            res = Math.max(res, distTo[i]);
        }
        return res;
    }

    class State {
        int id;
        int distFromStart;
        public State(int id, int dist) {
            this.id = id;
            this.distFromStart = dist;
        }
    }

    private int[] dijkstra(List<int[]>[] graph, int start) {
        int[] distTo = new int[graph.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[start] = 0;
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> a.distFromStart - b.distFromStart);
        pq.offer(new State(start, 0));

        while(!pq.isEmpty()) {
            State cur = pq.poll();
            int curId = cur.id;
            int curDist = cur.distFromStart;
            if(distTo[curId] < curDist) continue;
            for(int[] neighbor:graph[curId]) {
                int nextId = neighbor[0];
                int nextDist = neighbor[1];
                int toNextDist = curDist + nextDist;
                if(distTo[nextId] > toNextDist) {
                    distTo[nextId] = toNextDist;
                    pq.offer(new State(nextId, toNextDist));
                }
            }
        }
        return distTo;
    }
}
