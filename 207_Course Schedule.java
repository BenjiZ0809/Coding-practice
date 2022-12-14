//BFS
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        int[] indegree = new int[numCourses];
        for(int[] edge:prerequisites) {
            int to = edge[0];
            indegree[to]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<indegree.length; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        int count = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            count++;
            for(int neighbor:graph[cur]) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) q.offer(neighbor);
            }
        }
        return count == numCourses;
    }
    
    private List<Integer>[] buildGraph(int num, int[][] edges) {
        List<Integer>[] graph = new ArrayList[num];
        for(int i=0; i<num; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge:edges) {
            int from = edge[1];
            int to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }
}


//DFS
class Solution {
    boolean[] visited;
    boolean[] onPath;
    boolean hasCycle = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for(int i=0; i<numCourses; i++) {
            traverse(graph, i);
        }
        return !hasCycle;
    }

    private List<Integer>[] buildGraph(int num, int[][] edges) {
        List<Integer>[] graph = new ArrayList[num];
        for(int i=0; i<num; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge:edges) {
            int from = edge[1];
            int to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }
    
    private void traverse(List<Integer>[] graph, int v) {
        if(onPath[v]) hasCycle = true;
        if(visited[v] || hasCycle) return;

        visited[v] = true;
        onPath[v] = true;
        for(int neighbor:graph[v]) {
            traverse(graph, neighbor);
        }
        onPath[v] = false;
    }
}
