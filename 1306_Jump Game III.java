//BFS
class Solution {
    public boolean canReach(int[] arr, int start) {
        List<Integer>[] graph = buildGraph(arr);
        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(start);
        visited.add(start);

        while(!q.isEmpty()) {
            int cur = q.poll();
            if(arr[cur] == 0) return true;
            for(int neighbor:graph[cur]) {
                if(!visited.contains(neighbor)) {
                    q.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        } 
        return false;
    }

    private List<Integer>[] buildGraph(int[] arr) {
        int n = arr.length;
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
            if((i + arr[i]) >= 0 && (i + arr[i] < n)) graph[i].add(i + arr[i]);
            if((i - arr[i]) >= 0 && (i - arr[i] < n)) graph[i].add(i - arr[i]); 
        }
        return graph;
    }
}

//DFS
class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        if(start < 0 || start >= n || arr[start] < 0) return false;
        if(arr[start] == 0) return true;
        arr[start] = -arr[start];
        return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
    }
}
