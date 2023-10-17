import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

/**
 * A linked list is a sequence of nodes with efficient
 * element insertion and removal. This class
 * contains a subset of the methods of the standard
 * java.util.LinkedList class.
*/
public class LinkedList<T>{
    // Data
    Node<T> first;

    /**
        Constructs an empty linked list.
    */
    public LinkedList(){
    }

    public boolean isEmpty(){
        return first == null;
    }

    /**
        Returns the first element in the linked list.
        @return the first element in the linked list
    */
    public T getFirst(){
        Node<T> n = first;
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return n.item;
    }


    /**
        Adds an element to the front of the linked list.
        @param element the element to add
    */
    public boolean addFirst(T item){
        if(item == null){
            return false;
        }
        final Node<T> newNode = new Node<T>(item, this.first);
        final Node<T> oldNode = this.first;
        this.first = newNode;
        newNode.next = oldNode;
        return true;
    }

    /**
        Removes the first element in the linked list.
        @return the removed element
    */
    public T removeFirst(){
        if(this.first == null){
            throw new NoSuchElementException();
        }
        final Node<T> nextNode = this.first.next;
        final Node<T> oldNode = this.first;
        this.first = nextNode;
        return oldNode.item;
    }

    /**
        Returns an iterator for iterating through this list.
        @return an iterator for iterating through this list
    */
    public LinkedListIterator iterator(){
        return new LinkedListIterator();
    }

    // NEW CLASS
    static class Node<T>{
        public T item;
        public Node<T> next;

        Node(T item, Node<T> next){
            this.item = item;
            this.next = next;
        }
    }
    
    // NEW CLASS
    class LinkedListIterator implements ListIterator<T>{
        //Data
        private Node<T> pos, last;
        private boolean moved;

        /**
            Constructs an iterator that points to the front
            of the linked list.
        */
        public LinkedListIterator(){
            last = null;
            pos = first;
        }

        /**
            Tests if there is an element after the iterator position.
            @return true if there is an element after the iterator position
        */
        public boolean hasNext(){
            return pos != null;
        }
    
        /**
            Moves the iterator past the next element.
            @return the traversed element
        */
        public T next(){
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            moved = true;
            last = pos;
            pos = pos.next;
            return last.item;
        }

        

        /**
            Adds an element before the iterator position
            and moves the iterator past the inserted element.
            @param element the element to add
        */
        public boolean add(T item){
            if(moved){
                throw new ConcurrentModificationException();
            }
            Node<T> newNode = new Node<T>(item, pos);
            last.next = newNode;
            last = newNode;
            return true;
        }

        /**
            Removes the last traversed element. This method may
            only be called after a call to the next() method.
        */
        public boolean remove(){
            if(!moved){
                throw new IllegalStateException();
            }
            Node<T> prev = first;
            while(!prev.next.equals(last)){
                prev = prev.next;
            }
            prev.next = pos;
            return true;
        }

        /**
            Sets the last traversed element to a different value.
            @param element the element to set
        */
        public boolean set(T item){
            if(!moved){
                throw new IllegalStateException();
            }
            last.item = item;
            return true;
        }
    }//LinkedListIterator
}//LinkedList