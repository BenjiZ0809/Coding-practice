//BFS approach
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        int[] indegree = new int[numCourses];
        for(int[] edge:prerequisites) {
            int to = edge[0];
            indegree[to]++;
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0) q.offer(i);
        }
        
        int count = 0;
        int[] res = new int[numCourses];
        while(!q.isEmpty()) {
            int cur = q.poll();
            res[count] = cur;
            count++;
            for(int n:graph[cur]) {
                indegree[n]--;
                if(indegree[n] == 0) q.offer(n);
            }
        }
        
        return count == numCourses? res:new int[]{};
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

//DFS approach
class Solution {
    boolean[] visited;
    boolean[] onPath;
    boolean hasCycle = false;
    List<Integer> res = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for(int i=0; i<numCourses; i++) {
            traverse(graph, i);
        }
        
        if(hasCycle) return new int[]{};
        else {
            int index = 0;
            int[] ans = new int[numCourses];
            for(int i=res.size()-1; i>=0; i--) {
                ans[index++] = res.get(i);
            }
            return ans;
        }
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
        if(hasCycle || visited[v]) return;
        
        visited[v] = true;
        onPath[v] = true;
        for(int n:graph[v]) {
            traverse(graph, n);
        }
        onPath[v] = false;
        res.add(v);
    }
}
