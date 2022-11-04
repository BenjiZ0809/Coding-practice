class Solution {
    public String alienOrder(String[] words) {
        String res = "";
        Map<Character, List<Character>> graph = buildGraph(words);
        if(graph == null) return res;
        Map<Character, Integer> indegree = getIndegree(graph);
        Queue<Character> q = new ArrayDeque<>();
        
        for(char ch:indegree.keySet()) {
            if(indegree.get(ch) == 0) q.offer(ch);
        }

        while(!q.isEmpty()) {
            char cur = q.poll();
            res += cur;
            for(char neighbor:graph.get(cur)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if(indegree.get(neighbor) == 0) q.offer(neighbor);
            }
        }
        return res.length() == indegree.size()? res:"";
    }

    private Map<Character, List<Character>> buildGraph(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        for(String word:words) {
            for(char ch:word.toCharArray()) {
                if(!graph.containsKey(ch)) {
                    graph.put(ch, new ArrayList<>());
                }
            }
        }
        int n = words.length;
        for(int i=0; i<n-1; i++) {
            int m = Math.min(words[i].length(), words[i + 1].length());
            for(int j=0; j<m; j++) {
                if(words[i].charAt(j) != words[i + 1].charAt(j)) {
                    graph.get(words[i].charAt(j)).add(words[i + 1].charAt(j));
                    break;
                }
                if(j == m-1) {
                    if(words[i].length() > words[i + 1].length()) return null;
                }
            }
        }
        return graph;
    }

    private Map<Character, Integer> getIndegree(Map<Character, List<Character>> graph) {
        Map<Character, Integer> indegree = new HashMap<>();
        for(char ch:graph.keySet()) {
            indegree.put(ch, 0);
        }
        for(char ch:graph.keySet()) {
            for(char neighbor:graph.get(ch)) {
                indegree.put(neighbor, indegree.get(neighbor) + 1);
            }
        }
        return indegree;
    }
}

//simplified version
class Solution {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(String word:words) {
            for(char ch:word.toCharArray()) {
                graph.put(ch, new ArrayList<>());
                indegree.put(ch, 0);
            }
        }
        int n = words.length;
        for(int i=0; i<n-1; i++) {
            int m = Math.min(words[i].length(), words[i + 1].length());
            for(int j=0; j<m; j++) {
                if(words[i].charAt(j) != words[i + 1].charAt(j)) {
                    graph.get(words[i].charAt(j)).add(words[i + 1].charAt(j));
                    indegree.put(words[i + 1].charAt(j), indegree.get(words[i + 1].charAt(j)) + 1);
                    break;
                }
                if(j == m - 1) {
                    if(words[i].length() > words[i + 1].length()) return "";
                }
            }
        }

        Queue<Character> q = new ArrayDeque<>();
        for(char ch:indegree.keySet()) {
            if(indegree.get(ch) == 0) q.offer(ch);
        }

        while(!q.isEmpty()) {
            char cur = q.poll();
            sb.append(cur);
            for(char neighbor:graph.get(cur)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if(indegree.get(neighbor) == 0) q.offer(neighbor);
            }
        }
        return sb.length() == indegree.size()? sb.toString():"";
    }
}
