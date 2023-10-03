import java.util.PriorityQueue;
import java.util.Queue;


/**
 * This program demonstrates a priority queue of to-do items. The
 * most important to-do items are removed first.
*/
public class PriorityQueueDemo{
    public static void main(String[] args){
        Queue<WorkOrder> pq = new PriorityQueue<WorkOrder>();
        pq.add(new WorkOrder(3, "a"));
        pq.add(new WorkOrder(2, "b"));
        pq.add(new WorkOrder(2, "c"));
        pq.add(new WorkOrder(9, "d"));
        pq.add(new WorkOrder(1, "e"));

        while(!pq.isEmpty()){
            System.out.println(pq.remove());
        }
    }
}

