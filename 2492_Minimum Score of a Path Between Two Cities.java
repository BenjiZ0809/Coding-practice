class Solution {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] graph = new ArrayList[n + 1];
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }    
        for(int[] edge:roads) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph[from].add(new int[]{to, weight});
            graph[to].add(new int[]{from, weight});
        }
        int[] distTo = dijkstra(graph, 1);
        return distTo[n];
    }

    class State {
        int id;
        int dist;
        public State(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }

    private int[] dijkstra(List<int[]>[] graph, int start) {
        int n = graph.length;
        int[] distTo = new int[n];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.add(new State(start, Integer.MAX_VALUE));

        int curMin = Integer.MAX_VALUE;
        while(!pq.isEmpty()) {
            State cur = pq.poll();
            int curId = cur.id;
            int curDist = cur.dist;
            if(curDist > distTo[curId]) continue;
            for(int[] neighbor:graph[curId]) {
                int nextId =neighbor[0];
                int nextDist = neighbor[1];
                int toNextDist = Math.min(curDist, nextDist);
                if(distTo[nextId] > toNextDist) {
                    distTo[nextId] = toNextDist;
                    pq.offer(new State(nextId, toNextDist));
                }
            }
        }
        return distTo;
    }
}
