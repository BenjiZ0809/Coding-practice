class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //wordList.add(endWord);
        Map<String, List<String>> graph = buildGraph(wordList);
        Set<String> visited = new HashSet<>();
        Deque<State> q = new ArrayDeque<>();
        q.offer(new State(beginWord, 1));
        visited.add(beginWord);

        while(!q.isEmpty()) {
            State cur = q.poll();
            String curStr = cur.str;
            int curDist = cur.dist;
            if(curStr.equals(endWord)) return curDist;
            for(int i=0; i<curStr.length(); i++) {
                String key = curStr.substring(0, i) + '*' + curStr.substring(i + 1, curStr.length());
                List<String> list = graph.getOrDefault(key, new ArrayList<>());
                for(String neighbor:list) {
                    if(!visited.contains(neighbor)) {
                        int nextDist = curDist + 1;
                        q.offer(new State(neighbor, nextDist));
                        visited.add(neighbor);
                    }
                }
            }
        }
        return 0;
    }

    public Map<String, List<String>> buildGraph(List<String> words) {
        Map<String, List<String>> graph = new HashMap<>();
        for(String word:words) {
            for(int i=0; i<word.length(); i++) {
                String key = word.substring(0, i) + '*' + word.substring(i + 1, word.length());
                List<String> list = graph.getOrDefault(key, new ArrayList<>());
                list.add(word);
                graph.put(key, list);
            }
        }
        return graph;
    }

    class State {
        String str;
        int dist;

        public State(String str, int dist) {
            this.str = str;
            this.dist = dist;
        }
    }
}
