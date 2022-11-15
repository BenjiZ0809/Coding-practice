//UF
class Solution {
    public int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);
        for(int[] edge:edges) {
            int a = edge[0];
            int b = edge[1];
            uf.union(a, b);
        }
        return uf.count;
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
            parent[rootB] = rootA;
            count--;
        }

        public int find(int a) {
            if(parent[a] != a) {
                parent[a] = find(parent[a]);
            }
            return parent[a];
        }

        public boolean connected(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            return rootA == rootB;
        }
    }
}

//BFS
class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] graph = buildGraph(n, edges);
        Set<Integer> visited = new HashSet<>();
        int num = 0;

        for(int i=0; i<n; i++) {
            if(!visited.contains(i)) {
                num++;
                bfs(graph, i, visited);
            }
        }
        return num;
    }

    private List<Integer>[] buildGraph(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge:edges) {
            int from = edge[0];
            int to = edge[1];
            graph[from].add(to);
            graph[to].add(from);
        }
        return graph;
    }

    private void bfs(List<Integer>[] graph, int v, Set<Integer> visited) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(v);
        visited.add(v);

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int neighbor:graph[cur]) {
                if(!visited.contains(neighbor)) {
                    q.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }
}

//DFS
class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] graph = buildGraph(n, edges);
        Set<Integer> visited = new HashSet<>();
        int num = 0;
        for(int i=0; i<n; i++) {
            if(!visited.contains(i)) {
                num++;
                dfs(graph, i, visited);
            }
        }
        return num;
    }

    private List<Integer>[] buildGraph(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge:edges) {
            int from = edge[0];
            int to = edge[1];
            graph[from].add(to);
            graph[to].add(from);
        }
        return graph;
    }

    private void dfs(List<Integer>[] graph, int v, Set<Integer> visited) {
        if(visited.contains(v)) return;
        visited.add(v);
        for(int neighbor:graph[v]) {
            dfs(graph, neighbor, visited);
        }
    }
}
