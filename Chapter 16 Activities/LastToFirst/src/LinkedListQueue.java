/**
    Add a method lastToFirst to this implementation of a queue.
    The method moves the element at the tail of the queue
    to the head.
*/
public class LinkedListQueue{
    private Node head = null;
    private Node tail = null;

    /**
        Constructs an empty queue.
    */
    public LinkedListQueue(){
        
    }

    /**
        Moves the tail of the queue to the head.
    */
    public void lastToFirst(){
        Node n = this.tail, temp;
        n.next = this.head; this.head = n;
        temp = new Node(head);
        while(!temp.next.equals(head)){
            temp = temp.next;
        } // n is new tail
        tail = temp;
        tail.next = null;
    }

    /**
        Checks whether this queue is empty.
        @return true if this queue is empty
    */
    public boolean empty(){
        return head == null;
    }

    /**
        Adds an element to the tail of this queue.
        @param newElement the element to add
    */
    public void add(Object data){
        if (head == null && tail == null){   // head must also be null
            Node newNode = new Node(data, null);
            tail = newNode;
            head = newNode;
        } else {
            Node newNode = new Node(data, null);
            tail.next = newNode;
            tail = newNode;
        }
    }

    /**
        Removes an element from the head of this queue.
        @return the removed element
    */
    public Object remove(){
        if (head == null)
            return null;
        Object element = head.data;
        head = head.next;
        if (head == null){    // queue is empty
            tail = null;
        }
        return element;
    }

    class Node{
        public Object data;
        public Node next;

        public Node(Node n){
            this.data = n.data;
            this.next = n.next;
        }

        public Node(Object data, Node next){
            this.data = data;
            this.next = next;
        }
    }
}
