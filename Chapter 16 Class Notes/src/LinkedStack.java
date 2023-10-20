import java.util.NoSuchElementException;

/**
 * An implementation of a stack as a sequence of nodes.
*/
public class LinkedStack<T>{
    private Node<T> top = null;

    /**
     * Constructs an empty stack.
    */
    public LinkedStack(){

    }

    /**
     * Adds an element to the top of the stack.
     *
     * @param element the element to add
    */
    public void add(T item){
        Node<T> n = new Node<T>(item, top);
        top = n;
    }

    /**
        Removes the element from the top of the stack.
        @return the removed element
    */
    public T remove(){
        if(top == null){
            throw new NoSuchElementException();
        }
        T item = top.item;
        this.top = top.link;
        return item;
    }

    public void push(T item){
        add(item);
    }

    public T pop(){
        return remove();
    }

    /**
     * Checks whether this stack is empty.
     *
     * @return true if the stack is empty
    */
    public boolean isEmpty(){
        return top == null;
    }

    static class Node<T>{
        public T item;
        public Node<T> link;

        public Node(T item, Node<T> link){
            this.item = item;
            this.link = link;
        }
    }
}
