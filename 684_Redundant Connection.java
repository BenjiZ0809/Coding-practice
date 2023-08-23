// dfs
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for(int i=0; i<=n; i++) graph[i] = new ArrayList<>();

        for(int[] edge:edges) {
            int from = edge[0];
            int to = edge[1];
            boolean[] visited = new boolean[n + 1];
            if(dfs(graph, from, to, visited)) return edge;
            graph[from].add(to);
            graph[to].add(from);
        }
        return new int[0];
    }

    public boolean dfs(List<Integer>[] graph, int v, int n, boolean[] visited) {
        if(v == n) return true;
        visited[n] = true;
        for(int num:graph[n]) {
            if(!visited[num]) {
                if(dfs(graph, v, num, visited)) return true;
            }
        }
        return false;
    }
}

// UF
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UF uf = new UF(n + 1);

        for(int[] edge:edges) {
            int from = edge[0];
            int to = edge[1];
            if(uf.isConnected(from, to)) return edge;
            uf.union(from, to);
        }
        return new int[0];
    }

    class UF {
        int count;
        int[] parent;

        public UF(int n) {
            this.count = n;
            parent = new int[n];
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
