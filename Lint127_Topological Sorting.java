public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        Map<DirectedGraphNode, Integer> indegree = new HashMap<>();

        for(DirectedGraphNode node: graph) {
            indegree.putIfAbsent(node, 0);
            for(DirectedGraphNode neighbor:node.neighbors) {
                indegree.put(neighbor, indegree.getOrDefault(neighbor, 0) + 1);
            }
        }

        Queue<DirectedGraphNode> q = new ArrayDeque<>();
        for(DirectedGraphNode node: indegree.keySet()) {
            if(indegree.get(node) == 0) q.offer(node);
        }

        while(!q.isEmpty()) {
            DirectedGraphNode cur = q.poll();
            res.add(cur);
            for(DirectedGraphNode neighbor:cur.neighbors) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if(indegree.get(neighbor) == 0) q.offer(neighbor);
            }
        }
        return res;
    }
}
