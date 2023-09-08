class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        List<String> res = new ArrayList<>();
        for(List<String> ticket:tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            PriorityQueue<String> dist = graph.getOrDefault(from, new PriorityQueue<>());
            dist.add(to);
            graph.put(from, dist);
        }

        dfs("JFK", graph, res);
        return res;
    }

    public void dfs(String start, Map<String, PriorityQueue<String>> graph, List<String> res) {
        PriorityQueue<String> dist = graph.get(start);
        while(dist != null && dist.size() != 0) {
            dfs(dist.poll(), graph, res);
        }
        res.add(0, start);
    }
}
