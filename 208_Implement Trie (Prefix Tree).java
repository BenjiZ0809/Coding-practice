class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();    
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if(!node.contains(ch)) {
                node.put(ch);
            }
            node = node.get(ch);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    public TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for(int i=0; i<prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if(node.contains(ch)) {
                node = node.get(ch);
            }
            else return null;
        }
        return node;
    }

    class TrieNode {
        private TrieNode[] links;
        private boolean isEnd;

        public TrieNode() {
            this.links = new TrieNode[26];
            this.isEnd = false;
        }

        public boolean contains(char ch) {
            return links[ch - 'a'] != null;
        }

        public void put(char ch) {
            links[ch - 'a'] = new TrieNode();
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void setEnd() {
            this.isEnd = true;
        }

        public boolean isEnd() {
            return this.isEnd;
        }
    }
}
