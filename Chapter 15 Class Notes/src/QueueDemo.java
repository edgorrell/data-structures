import java.util.LinkedList;
import java.util.Queue;

/**
 * This program simulates a print queue. Note that documents are printed
 * in the same order as they are submitted.
*/
public class QueueDemo{
    public static void main(String[] args){
        Queue<String> q = new LinkedList<String>();
        for(int i = 0; i < 16; i++){
            q.add("thing number: " + i);
        }
        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}
