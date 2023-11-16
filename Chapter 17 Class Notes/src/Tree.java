import java.util.ArrayList;
import java.util.List;

/**
    A tree in which each node has an arbitrary number of children.
*/
public class Tree<T>{
    Node<T> root = null;

    /**
        Constructs a tree with one node and no children.
        @param rootData the data for the root
    */
    public Tree(T rootData){
        root = new Node<T>();
        root.data = rootData;
        root.children = new ArrayList<Node<T>>();        
    }

    /**
        Adds a subtree as the last child of the root.
    */
    public void addSubtree(Tree<T> subtree){
        this.root.children.add(subtree.root);
        subtree.root.parent = this.root;
    }

    /* 
        traverses tree in pre-order
        @param v: visitor to be invoked at each node
    */ 
    public void preorder(Visitor<T> v){
        preorder(this.root, v);
    }

    /*
        traverses the tree with a given root
        @param n: root of the tree to traverse
        @param v:  visitor to be invoked at each node
     */
    private void preorder(Node<T> n, Visitor<T> v){
        if(n == null){
            return;
        }
        v.visit(n.data);
        for(Node<T> child : n.children){
            preorder(child,v);
        }
    }

    /**
        Computes the size of this tree.
        @return the number of nodes in the tree
    */
    public int size(){
        return this.root.size();
    }
        
    public static class Node<T> {
        private T data;
        private Node<T> parent;
        private ArrayList<Node<T>> children;

        public int size(){
            int total = 1;
            for(Node<T> child : this.children){
                total += child.size();
            }
            return total;
        }
    }

    public interface Visitor<T>{
        abstract void visit(T data);
    }
}
