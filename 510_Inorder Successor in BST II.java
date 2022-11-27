//Approach 1
class Solution {
    public Node inorderSuccessor(Node node) {
        if(node.right != null) {
            node = node.right;
            while(node.left != null) node = node.left;
            return node;
        }
        else {
            while(node.parent != null && node.parent.right == node) node = node.parent;
            return node.parent;
        }
    }
}

//Approach 2
class Solution {
    public Node inorderSuccessor(Node node) {
        if(node == null) return null;
        if(node.right != null) return getMostLeft(node.right);
        else return getParentSuccessor(node);
    }

    private Node getMostLeft(Node node) {
        if(node.left == null) return node;
        return getMostLeft(node.left);
    }

    private Node getParentSuccessor(Node node) {
        if(node.parent == null) return null;
        if(node == node.parent.right) {
            return getParentSuccessor(node.parent);
        }
        return node.parent;
    }
}
