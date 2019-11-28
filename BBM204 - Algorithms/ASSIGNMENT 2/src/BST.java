public class BST {
    private BSTNode root;

    public BST() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(String data) {
        root = insert(root, data);
    }

    private BSTNode insert(BSTNode node, String data) {
        if (node == null)
            node = new BSTNode(data);
        else {
            if (data.compareTo(node.getData())<0)
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);
        }
        return node;
    }

    public void delete(String k) {
        if (isEmpty()) {}
        else
            root = delete(root, k);
    }
    private BSTNode delete(BSTNode root, String k) {
        BSTNode p, p2, n;
        if (root.getData().compareTo(k)==0) {
            BSTNode left, right;
            left = root.getLeft();
            right = root.getRight();
            if (left == null && right == null)
                return null;
            else if (left == null) {
                p = right;
                return p;
            }
            else if (right == null) {
                p = left;
                return p;
            }
            else {
                p2 = right;
                p = right;
                while (p.getLeft() != null)
                    p = p.getLeft();
                p.setLeft(left);
                return p2;
            }
        }
        if (k.compareTo(root.getData())<0) {
            n = delete(root.getLeft(), k);
            root.setLeft(n);
        }
        else {
           n = delete(root.getRight(), k);
            root.setRight(n);             
        }
        return root;
    }

    public int countNodes() {
    	return countNodes(root);
    }

    private int countNodes(BSTNode root) {
       if (root == null)
            return 0;
        else {
            int l = 1;
            l += countNodes(root.getLeft());
            l += countNodes(root.getRight());
            return l;
        }
    }

    public boolean search(String k) {
        return search(root, k);
    }

    private boolean search(BSTNode root, String item) {
        boolean found = false;
        while ((root != null) && !found) {
            String root_value = root.getData();
            if (item.compareTo(root_value)<0)
            	root = root.getLeft();
            else if (item.compareTo(root_value)>0)
            	root = root.getRight();
            else {
                found = true;
                break;
            }
            found = search(root, item);
        }
        return found;
    }
}
 
class BSTNode {
     
	BSTNode left, right;
	String data;
	
    public BSTNode() {
        left = null;
        right = null;
        data = "";
    }
    public BSTNode(String n) {
        left = null;
        right = null;
        data = n;
    }
    public void setLeft(BSTNode n) {
        left = n;
    }
    public void setRight(BSTNode n) {
        right = n;
    }
    public BSTNode getLeft() {
        return left;
    }
    public BSTNode getRight() {
        return right;
    }
    public void setData(String d) {
        data = d;
    }
    public String getData() {
        return data;
    }     
}
 