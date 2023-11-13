/**
    A binary tree in which each node has two children.
*/
public class BinaryTree<T>{
    private Node<T> root;

    /**
        Constructs an empty tree.
    */
    public BinaryTree(){

    } 

    /**
        Constructs a tree with one node and no children.
        @param rootData the data for the root
    */
    public BinaryTree(T rootData) {
        this.root = new Node<T>();
        this.root.item = rootData;
    }

    /**
        Constructs a binary tree.
        @param rootData the data for the root
        @param left the left subtree
        @param right the right subtree
    */
    public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree){
        this(rootData);
        this.root.left = leftTree.root;
        this.root.right = rightTree.root;
    }

    /**
        Returns the height of the subtree whose root is the given node.
        @param n a node or null
        @return the height of the subtree, or 0 if n is null
    */
    private int height(Node<T> n){
        if(n == null){
            return 0;
        }
        return 1 + Math.max(height(root.left),height(root.right));
    }

    /**
        Returns the height of this tree.
        @return the height
    */
    public int height(){
        return this.height(this.root);
    }

    /**
        Checks whether this tree is empty.
        @return true if this tree is empty
    */
    public boolean isEmpty(){
         return this.root == null;
    }

    /**
        Gets the data at the root of this tree.
        @return the root data
    */
    public T data(){
         return root.item;
    }
    
    /**
        Gets the left subtree of this tree.
        @return the left child of the root
    */
    public BinaryTree<T> left() { 
        BinaryTree<T> subtree = new BinaryTree<T>();
        subtree.root = root.left;
        return subtree;
    }

    /**
        Gets the right subtree of this tree.
        @return the right child of the root
    */
    public BinaryTree<T> right() { 
        BinaryTree<T> subtree = new BinaryTree<T>();
        subtree.root = root.right;
        return subtree;
    }

    static class Node<T>{
        T item = null;
        Node<T> left = null, right = null;
    }
}
