import java.util.NoSuchElementException;

/**
    An implementation of a queue as a circular array.
*/
public class CircularQueue<T>{
    //private data
    private T[] elements;
    private int head, tail, size;

    /**
        Constructs an empty queue.
    */
    public CircularQueue(){
        final int INITAL_SIZE = 10;
        this.elements = (T[]) new Object[INITAL_SIZE];
        this.head = 0; this.tail = 0; this.size = 0;
    }

    /**
        Checks whether this queue is empty.
        @return true if this queue is empty
    */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
        Adds an element to the tail of this queue.
        @param newElement the element to add
    */
    public void add(T item){
        growIfNecessary();
        this.size++;
        this.elements[this.tail] = item;
        this.tail = tail++ % this.elements.length;
    }

    /**
        Removes an element from the head of this queue.
        @return the removed element
    */
    public T remove(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        this.size--;
        T item = this.elements[this.head];
        this.head = (this.head + 1) % this.elements.length;
        return item;
    }

    /**
        Grows the element array if the current size equals the capacity.
    */
    private void growIfNecessary(){
        if(this.size == this.elements.length){
            T[] newElements = (T[]) new Object[2 * this.elements.length];
            for(int i = 0; i < this.elements.length; i++)
            {
                newElements[i] = this.elements[(head + i) % this.elements.length];
            }
            this.elements = newElements;
            this.head = 0;
            this.tail = this.size;
        }
    }

}//LinkedQueue
