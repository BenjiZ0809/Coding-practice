class Solution {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        Map<Integer, List<Integer>> graph = buildGraph(nums, sequences);
        List<Integer> topo = getTopo(graph);
        if(topo == null) return false;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != topo.get(i)) return false;
        }
        return true;
    }
    
    private Map<Integer, List<Integer>> buildGraph(int[] nums, List<List<Integer>> sequences) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int num:nums) {
            graph.put(num, new ArrayList<>());
        }
        
        for(List<Integer> edge:sequences) {
            for(int i=1; i<edge.size(); i++) {
                graph.get(edge.get(i - 1)).add(edge.get(i));
            }
        }
        return graph;
    }
    
    private Map<Integer, Integer> getIndegree(Map<Integer, List<Integer>> graph){
        Map<Integer, Integer> indegree = new HashMap<>();
        for(int node:graph.keySet()) {
            indegree.put(node, 0);
        }
        for(int node:graph.keySet()) {
            for(int neighbor:graph.get(node)) {
                indegree.put(neighbor, indegree.get(neighbor) + 1);
            }
        }
        return indegree;
    }
    
    private List<Integer> getTopo(Map<Integer, List<Integer>> graph) {
        Queue<Integer> q = new ArrayDeque<>();
        Map<Integer, Integer> indegree = getIndegree(graph);
        List<Integer> topo = new ArrayList<>();
        
        for(int node:indegree.keySet()) {
            if(indegree.get(node) == 0) q.offer(node);
        }
        
        while(!q.isEmpty()) {
            if(q.size() > 1) return null;
            int cur = q.poll();
            topo.add(cur);
            for(int neighbor:graph.get(cur)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if(indegree.get(neighbor) == 0) q.offer(neighbor);
            }
        }
        return topo;
    }
}


//simplified version
class Solution {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        List<Integer>[] graph = new ArrayList[nums.length + 1];
        int[] indegree = new int[nums.length + 1];
        for(int num:nums) {
            graph[num] = new ArrayList<>();
        }
        for(List<Integer> edge:sequences) {
            for(int i=1; i<edge.size(); i++) {
                int from = edge.get(i - 1);
                int to = edge.get(i);
                graph[from].add(to);
                indegree[to]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> topo = new ArrayList<>();
        for(int i=1; i<indegree.length; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()) {
            if(q.size() > 1) return false;
            int cur = q.poll();
            topo.add(cur);
            for(int neighbor:graph[cur]) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) q.offer(neighbor);
            }
        }

        for(int i=0; i<nums.length; i++) {
            if(nums[i] != topo.get(i)) return false;
        }

        return true;
    }
}
