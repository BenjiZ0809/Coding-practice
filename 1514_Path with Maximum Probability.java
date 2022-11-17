class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<double[]>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            double prob = succProb[i];
            graph[from].add(new double[]{(double)to, prob});
            graph[to].add(new double[]{(double)from, prob});
        }

        double[] probTo = dijkstra(graph, start);
        return probTo[end];
    }

    class State {
        int id;
        double probFromStart;
        public State (int id, double prob) {
            this.id = id;
            this.probFromStart = prob;
        }
    }

    private double[] dijkstra(List<double[]>[] graph, int start) {
        double[] probTo = new double[graph.length];
        Arrays.fill(probTo, 0);
        probTo[start] = 1;
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Double.compare(b.probFromStart, a.probFromStart));
        pq.offer(new State(start, 1));

        while(!pq.isEmpty()) {
            State cur = pq.poll();
            int curId = cur.id;
            double curProb = cur.probFromStart;
            if(probTo[curId] > curProb) continue;
            for(double[] neighbor:graph[curId]) {
                int nextId = (int)neighbor[0];
                double nextProb = neighbor[1];
                double toNextProb = curProb * nextProb;
                if(probTo[nextId] < toNextProb) {
                    probTo[nextId] = toNextProb;
                    pq.offer(new State(nextId, toNextProb));
                }
            }
        }
        return probTo;
    }
}
