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
        private List<Node<T>> children;

        public int size(){
            int total = 1;
            for(Node<T> child : this.children){
                total += child.size();
            }
            return total;
        }
    }
}
