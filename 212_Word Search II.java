//DFS backTrack original(slow)
class Solution {
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};
    public List<String> findWords(char[][] board, String[] words) {
        if(board == null || board.length == 0) return new ArrayList<>();
        if(board[0] == null || board[0].length == 0) return new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        Set<String> wordSet = new HashSet<>();
        Set<String> prefix = new HashSet<>();
        for(String word:words) {
            for(int i=0; i<word.length(); i++) {
                prefix.add(word.substring(0, i + 1));
            }
            wordSet.add(word);
        }

        Set<String> res = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                visited[i][j] = true;
                sb.append(board[i][j]);
                backTrack(board, wordSet, visited, i, j, prefix, sb, res);
                visited[i][j] = false;
                sb.delete(0, sb.length());
            }
        }
        List<String> result = new ArrayList<>(res);
        return result;
    }

    private void backTrack(char[][] board, Set<String> wordSet, boolean[][] visited, int x, int y, Set<String> prefix, StringBuilder sb, Set<String> res) {
        if(!prefix.contains(sb.toString())) return;
        if(wordSet.contains(sb.toString())) res.add(sb.toString());

        for(int k=0; k<4; k++) {
            int newX = x + dx[k];
            int newY = y + dy[k];
            if(isValid(board, visited, newX, newY)) {
                sb.append(board[newX][newY]);
                visited[newX][newY] = true;
                backTrack(board, wordSet, visited, newX, newY, prefix, sb, res);
                sb.deleteCharAt(sb.length() - 1);
                visited[newX][newY] = false;
            }
        }
    }

    private boolean isValid(char[][] board, boolean[][] visited, int x, int y) {
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;
        if(visited[x][y]) return false;
        return true;
    }
}


// Trie
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int n = board.length;
        int m = board[0].length;
        List<String> res = new ArrayList<>();
        boolean[][] visited = new boolean[n][m];
        StringBuilder sb = new StringBuilder();
        Trie trie = new Trie();

        for(String str:words) {
            trie.insert(str);
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                dfs(board, visited, i, j, sb, trie.root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, boolean[][] visited, int x, int y, StringBuilder sb, TrieNode node, List<String> res) {
        if(node.isEnd()) {
            res.add(sb.toString());
            node.notEnd();
        }
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;
        if(visited[x][y]) return;

        char ch = board[x][y];
        if(!node.contains(ch)) return;

        TrieNode parent = node;
        node = node.get(ch);

        sb.append(ch);
        visited[x][y] = true;
        dfs(board, visited, x + 1, y, sb, node, res);
        dfs(board, visited, x - 1, y, sb, node, res);
        dfs(board, visited, x, y + 1, sb, node, res);
        dfs(board, visited, x, y - 1, sb, node, res);
        visited[x][y] = false;
        sb.deleteCharAt(sb.length() - 1);

        int index = 0;
        for(index=0; index<26; index++) {
            if(node.contains(index)) break; 
        }
        if(index == 26) {
            parent.links[ch - 'a'] = null;
        }
        return;

    }

    class TrieNode {
        TrieNode[] links;
        boolean isEnd;

        public TrieNode() {
            this.links = new TrieNode[26];
            this.isEnd = false;
        }

        public void put(char ch) {
            links[ch - 'a'] = new TrieNode();
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public boolean contains(char ch) {
            return links[ch - 'a'] != null;
        }

        public boolean contains(int i) {
            return links[i] != null;
        }

        public void setEnd() {
            this.isEnd = true;
        }

        public void notEnd() {
            this.isEnd = false;
        }

        public boolean isEnd() {
            return this.isEnd;
        }
    }

    class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String str) {
            TrieNode node = root;
            for(char ch:str.toCharArray()) {
                if(!node.contains(ch)) {
                    node.put(ch);
                }
                node = node.get(ch);
            }
            node.setEnd();
        }
    }
}
