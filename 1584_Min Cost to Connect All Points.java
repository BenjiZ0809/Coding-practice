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
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                pq.offer(new int[] {i, j, dist});
            }
        }

        UF uf = new UF(n);
        int res = 0;
        while(uf.count != 1) {
            int[] cur = pq.poll();
            int from = cur[0];
            int to = cur[1];
            int dist = cur[2];
            if(uf.isConnected(from, to)) continue;
            uf.union(from, to);
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
            return find(a) == find(b);
        }
    }
}
