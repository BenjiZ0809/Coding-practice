class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();    
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if(node.links[ch - 'a'] == null) {
                node.links[ch - 'a'] = new TrieNode();
            }
            node = node.links[ch - 'a'];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        return searchHelper(word, root, 0);
    }

    public boolean searchHelper(String word, TrieNode node, int index) {
        for(int i=index; i<word.length(); i++) {
            char ch = word.charAt(i);
            if(ch == '.') {
                for(int j=0; j<26; j++) {
                    if(node.links[j] != null) {
                        boolean res = searchHelper(word, node.links[j], i + 1);
                        if(res) return true;
                    }
                }
                return false;
            }
            else {
                node = node.links[ch - 'a'];
                if(node == null) return false;
            }
        }
        return node.isEnd;
    }

    class TrieNode {
        TrieNode[] links;
        boolean isEnd;

        public TrieNode() {
            this.links = new TrieNode[26];
            this.isEnd = false;
        }
    }
}
