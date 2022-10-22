//DFS approach
class Solution {
    public Node cloneGraph(Node node) {
        traverse(node);
        return map.get(node);
    }
    
    Map<Node, Node> map = new HashMap<>();
    
    public void traverse(Node node) {
        if(node == null) return;
        if(map.containsKey(node)) return;
        
        map.put(node, new Node(node.val));
        Node cloneNode = map.get(node);
        for(Node neighbor:node.neighbors) {
            traverse(neighbor);
            cloneNode.neighbors.add(map.get(neighbor));
        }
    }
}

//BFS approach
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Set<Node> nodes = findAll(node);
        Map<Node, Node> map = copyNodes(nodes);
        copyEdges(nodes, map);
        return map.get(node);
    }
    
    private Set<Node> findAll(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();
        q.offer(node);
        visited.add(node);
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            for(Node neighbor:cur.neighbors) {
                if(visited.contains(neighbor)) continue;
                q.offer(neighbor);
                visited.add(neighbor);
            }
        }
        return visited;
    }
    
    private Map<Node, Node> copyNodes(Set<Node> nodes) {
        Map<Node, Node> map = new HashMap<>();
        for(Node node:nodes) {
            Node newNode = new Node(node.val);
            map.put(node, newNode);
        }
        return map;
    }
    
    private void copyEdges(Set<Node> nodes, Map<Node, Node> map) {
        for(Node node:nodes) {
            Node newNode = map.get(node);
            for(Node neighbor:node.neighbors) {
                Node newNeighbor = map.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
    }
}
