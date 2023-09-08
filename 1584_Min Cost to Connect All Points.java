//Prim's Algo
class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int len = points.length;
        Set<Integer> visited = new HashSet<>();
        int res = 0;
        pq.offer(new int[] {0, 0});

        while(visited.size() < len) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curDist = cur[1];
            if(visited.contains(curNode)) continue;
            visited.add(curNode);
            res += curDist;

            for(int nextNode=0; nextNode<len; nextNode++) {
                if(!visited.contains(nextNode)) {
                    int nextDist = Math.abs(points[nextNode][0] - points[curNode][0]) + Math.abs(points[nextNode][1] - points[curNode][1]);
                    pq.offer(new int[] {nextNode, nextDist});
                }
            }
        }
        return res;
    }
}

//UF
class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList<>();
        int n = points.length;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int xi = points[i][0];
                int yi = points[i][1];
                int xj = points[j][0];
                int yj = points[j][1];
                int dist = Math.abs(xi - xj) + Math.abs(yi - yj);
                edges.add(new int[] {i, j, dist});
            }
        }

        Collections.sort(edges, (a, b) -> a[2] - b[2]);
        int res = 0;
        UF uf = new UF(n);
        for(int[] edge:edges) {
            int a = edge[0];
            int b = edge[1];
            int dist = edge[2];
            if(uf.isConnected(a, b)) continue;
            uf.union(a, b);
            res += dist;
        }
        return res;
    }

    class UF {
        int count;
        int[] parent;

        public UF(int n) {
            this.count = n;
            this.parent = new int[n];
            for(int i=0; i<n; i++) {
                parent[i] = i;
            }
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if(rootA == rootB) return;
            parent[rootA] = rootB;
            count--;
        }

        public int find(int a) {
            if(parent[a] != a) {
                parent[a] = find(parent[a]);
            }
            return parent[a];
        }

        public boolean isConnected(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            return rootA == rootB;
        }

        public int count() {
            return this.count;
        }
    }
}
