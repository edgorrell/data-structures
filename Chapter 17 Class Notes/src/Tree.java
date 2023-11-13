import java.util.ArrayList;

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
        root = new Node<T>(rootData);        
    }

    /**
        Adds a subtree as the last child of the root.
    */
    public void addSubtree(Tree<T> subtree){
        this.root.children.add(subtree.root);
    }

    /**
        Computes the size of this tree.
        @return the number of nodes in the tree
    */
    public int size(){
        return this.root.size();
    }
        
    static class Node<T>{
        ArrayList<Node<T>> children = new ArrayList<Node<T>>();
        T item;

        public Node(T item){
            this.item = item;
        }

        public int size(){
            int total = 1;
            for(Node<T> child : this.children){
                total += child.size();
            }
            return total;
        }
    }
}
