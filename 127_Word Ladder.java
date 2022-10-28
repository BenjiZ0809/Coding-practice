class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(endWord);
        Queue<State> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        Map<String, List<String>> graph = buildGraph(wordList);
        q.add(new State(beginWord, 1));
        visited.add(beginWord);
        
        while(!q.isEmpty()) {
            State cur = q.poll();
            String curWord = cur.word;
            int curDist = cur.distFromStart;
            if(curWord.equals(endWord)) curDist;
            for(int i=0; i<curWord.length(); i++) {
                String key = curWord.substring(0, i) + "*" + curWord.substring(i+1, curWord.length());
                List<String> neighbors = graph.getOrDefault(key, new ArrayList<>());
                for(String neighbor:neighbors) {
                    if(!visited.contains(neighbor)) {
                        q.offer(new State(neighbor, curDist + 1));
                        visited.add(neighbor);
                    }
                }
            }
        }
    }
    
    private class State {
        private String word;
        private int distFromStart;
        public State(String word, int dist) {
            this.word = word;
            this.distFromStart = dist;
        }
    }
    
    private Map<String, List<String>> buildGraph(List<String> wordList) {
        Map<String, List<String>> graph = new HashMap<>();
        for(String word:wordList) {
            for(int i=0; i<word.length(); i++) {
                String key = word.substring(0, i) + "*" + word.substring(i + 1, word.length());
                List<String> neighbors = graph.getOrDefault(key, new ArrayList<>());
                neighbors.add(word);
                graph.put(key, neighbors);
            }
        }
        return graph;
    }
}
