//Approach 1 (binaryTree traverse)
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

//Approach 2 Linked List
class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p;
        Node b = q;
        while(a != b) {
            if(a == null) a = q;
            else a = a.parent;
            if(b == null) b = p;
            else b = b.parent;
        }
        return a;
    }
}
