public class QueueDemo{
    public static void main(String[] args){
        CircularQueue<String> queue = new CircularQueue<String>();

        queue.add("Tom");
        queue.add("Diana");
        queue.add("Harry");
        System.out.println(queue.remove()); // remove Tom
        queue.add("Romeo");
        System.out.println(queue.remove()); // remove Diana
        queue.add("Juliet");
        queue.add("Maria");

        while(!queue.isEmpty())
        {
            System.out.println(queue.remove());
        }
        
        System.out.println("Expected output: Tom, Diana, Harry, Romeo, Juliet, Maria");
        */
    }
}
