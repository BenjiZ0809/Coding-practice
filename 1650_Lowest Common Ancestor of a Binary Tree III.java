class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> set = new HashSet<>();
        while(p != null) {
            set.add(p);
            p = p.parent;
        }
        while(q != null) {
            if(set.contains(q)) return q;
            q = q.parent;
        }
        return null;
    }
}
