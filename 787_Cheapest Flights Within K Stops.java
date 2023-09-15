// dijkstra
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        for(int[] flight:flights) {
            int from = flight[0];
            int to = flight[1];
            int weight = flight[2];
            graph[from].add(new int[] {to, weight});
        }

        k++;
        return dijkstra(graph, src, dst, k);
    }

    class State {
        int id;
        int distFromStart;
        int stopFromStart;

        public State(int id, int dist, int stop) {
            this.id = id;
            this.distFromStart = dist;
            this.stopFromStart = stop;
        }
    }

    public int dijkstra(List<int[]>[] graph, int start, int end, int k) {
        int[] distTo = new int[graph.length];
        int[] stops = new int[graph.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        Arrays.fill(stops, Integer.MAX_VALUE);
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> a.distFromStart - b.distFromStart);
        pq.offer(new State(start, 0, 0));
        distTo[start] = 0;
        stops[start] = 0;

        while(!pq.isEmpty()) {
            State cur = pq.poll();
            int curId = cur.id;
            int curDist = cur.distFromStart;
            int curStop = cur.stopFromStart;
            if(curId == end) return curDist;
            if(curStop >= k) continue;
            
            for(int[] neighbor:graph[curId]) {
                int nextId = neighbor[0];
                int toNextDist = neighbor[1];
                int nextStop = curStop + 1;
                int nextDist = toNextDist + curDist;
                if(distTo[nextId] < nextDist && stops[nextId] < nextStop) continue;
                if(distTo[nextId] > nextDist) {
                    distTo[nextId] = nextDist;
                    stops[nextId] = nextStop;
                }
                pq.offer(new State(nextId, nextDist, nextStop));
            }
        }
        return -1;
    } 
}
