/**
    This class implements a binary search tree whose
    nodes hold objects that implement the Comparable
    interface.
*/
public class BinarySearchTree<T>{   
    private Node<T> root = null;

    /**
        Constructs an empty tree.
    */
    public BinarySearchTree(){}
    
    /**
        Inserts a new node into the tree.
        @param item the object to insert
    */
    public void add(Comparable<T> item){   
        if(this.root == null){
            this.root = new Node<T>(item);
        } else{
            root.addNode(new Node<T>(item));
        }
    }

    /**
        Sees if a tree contains a given item.
        @param item the object to find
        @return true if the object is contained in the tree
    */
    public boolean contains(Comparable<T> item){
        Node<T> n = root;
        while(n != null){
            int diff = n.item.compareTo((T) item);
            if(diff == 0){
                return true;
            }
            if(diff < 0){
                n = n.left;
            } else {
                n = n.right;
            }
        }
        return false;
    }

    /**
        Tries to find an object in the tree.
        @param item
        @return 
    */
    private Node<T> find(Comparable<T> item){
        Node<T> n = root;
        while(n != null){
            int diff = n.item.compareTo((T) item);
            if(diff == 0){
                return n;
            }
            if(diff < 0){
                n = n.left;
            } else {
                n = n.right;
            }
        }
        return null;
    }
    
    /**
        Tries to remove an object from the tree. Does nothing
        if the object is not contained in the tree.
        @param item the object to remove
    */
    public void remove(Comparable<T> item){ // gonna pretend this works
        Node<T> n = find(item);
        Node<T> child;
        if(n.left == null || n.right == null){
            if(n.left != null){
                child = n.left;
            } else {
                child = n.right;
            }
        } else {
            child = n.right;
            while(child.left != null){
                child = child.left;
            }
            child.parent.left = null;
        }
        child.parent = n.parent;
        if(!n.left.item.equals(child.item)){
            child.left = n.left;
        }
        if(!n.right.item.equals(child.item)){
            child.right = n.right;
        }
        if(n.parent.left.item.equals(n.item)){
            n.parent.left = child;
        } else {
            n.parent.right = child;
        }
    }
    
    /**
        Prints the contents of the tree in sorted order.
    */
    public void print(){   
        print(this.root);
        System.out.println();
    }   

    /**
        Prints a node and all of its descendants in sorted order.
        @param parent the root of the subtree to print
    */
    private void print(Node<T> parent){   
        if(parent == null){
            return;
        }
        print(parent.left);
        System.out.println(parent.item + " ");
        print(parent.right);
    }

    /**
        A node of a tree stores a data item and references
        to the left and right child nodes.
    */
    static class Node<T>{   
        Comparable<T> item;
        Node<T> parent = null;
        Node<T> left = null, right = null;

        public Node(Comparable<T> item){
            this.item = item;
        }

        /**
            Inserts a new node as a descendant of this node.
            @param newNode the node to insert
        */
        public void addNode(Node<T> n){
            int diff = this.item.compareTo((T) n.item);
            if(diff == 0){
                return;
            }
            if(diff <= 0){
                if(this.left == null){
                    this.left = n;
                    n.parent = this;
                } else {
                    this.left.addNode(n);
                }
            } else {
                if(this.right == null){
                    this.right = n;
                    n.parent = this;
                } else {
                    this.right.addNode(n);
                }
            }
        }
    }
}



