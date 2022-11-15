//BFS
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        List<Integer>[] graph = buildGraph(n, rooms);
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

    private List<Integer>[] buildGraph(int n, List<List<Integer>> edges) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<edges.size(); i++) {
            for(int j=0; j<edges.get(i).size(); j++) {
                graph[i].add(edges.get(i).get(j));
            }
        }
        return graph;
    }
}

//DFS
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        List<Integer>[] graph = buildGraph(n, rooms);
        Set<Integer> visited = new HashSet<>();
        dfs(graph, 0, visited);
        return visited.size() == n;
    }

    private List<Integer>[] buildGraph(int n, List<List<Integer>> edges) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<edges.size(); i++) {
            for(int j=0; j<edges.get(i).size(); j++) {
                graph[i].add(edges.get(i).get(j));
            }
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
