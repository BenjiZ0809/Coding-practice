//BFS
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) return false;
        List<Integer>[] graph = buildGraph(n, edges);
        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(0);
        visited.add(0);

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int neighbor:graph[cur]) {
                if(!visited.contains(neighbor)) {
                    q.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return visited.size() == n;
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
}

//DFS
class Solution {
    Set<Integer> visited = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) return false;
        List<Integer>[] graph = buildGraph(n, edges);
        dfs(graph, 0);
        return visited.size() == n;
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

    private void dfs(List<Integer>[] graph, int v) {
        if(visited.contains(v)) return;
        visited.add(v);
        for(int neighbor:graph[v]) {
            dfs(graph, neighbor);
        }
    }
}

// DFS2
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n != edges.length + 1) return false;
        List<Integer>[] graph = buildGraph(n, edges);
        Set<Integer> visited = new HashSet<>();
        dfs(graph, 0, visited);
        return visited.size() == n;
    }

    public List<Integer>[] buildGraph(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();
        for(int[] edge:edges) {
            int from = edge[0];
            int to = edge[1];
            graph[from].add(to);
            graph[to].add(from);
        }
        return graph;
    }

    public void dfs(List<Integer>[] graph, int v, Set<Integer> visited) {
        if(visited.contains(v)) return;
        visited.add(v);
        for(int n:graph[v]) {
            dfs(graph, n, visited);
        }
    }
}

//UF
class Solution {
    public boolean validTree(int n, int[][] edges) {
        UF uf = new UF(n);
        for(int[] edge:edges) {
            int a = edge[0];
            int b = edge[1];
            if(uf.connected(a, b)) return false;
            uf.union(a, b);
        }
        return uf.count == 1;
    }

    class UF {
        int count;
        int[] parent;
        public UF (int n) {
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

        public int getCount() {
            return this.count;
        }
    }
}
