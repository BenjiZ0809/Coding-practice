class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        map.put(beginWord, 1);
        wordSet.remove(beginWord);

        while(!q.isEmpty()) {
            String str = q.poll();
            int step = map.get(str);
            if(str.equals(endWord)) break;

            for(int i=0; i<str.length(); i++) {
                for(char ch='a'; ch<='z'; ch++) {
                    char[] arr = str.toCharArray();
                    arr[i] = ch;
                    String newWord = new String(arr);
                    if(wordSet.contains(newWord)) {
                        wordSet.remove(newWord);
                        map.put(newWord, step + 1);
                        q.offer(newWord);
                    }
                }
            }
        }

        List<List<String>> res = new ArrayList<>();
        if(map.containsKey(endWord)) {
            backTrack(endWord, beginWord, map, new ArrayList<>(), res);
        }
        return res;
    }

    private void backTrack(String str, String beginWord, Map<String, Integer> map, List<String> minires, List<List<String>> res) {
        if(str.equals(beginWord)) {
            List<String> temp = new ArrayList<>(minires);
            temp.add(str);
            Collections.reverse(temp);
            res.add(temp);
            return;
        }

        int step = map.get(str);
        for(int i=0; i<str.length(); i++) {
            for(char ch='a'; ch<='z'; ch++) {
                char[] arr = str.toCharArray();
                arr[i] = ch;
                String newWord = new String(arr);
                if(map.containsKey(newWord) && map.get(newWord) == step - 1) {
                    minires.add(str);
                    backTrack(newWord, beginWord, map, minires, res);
                    minires.remove(minires.size() - 1);
                }
            }
        }
    }
}
