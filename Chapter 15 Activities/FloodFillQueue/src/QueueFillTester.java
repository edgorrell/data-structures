public class QueueFillTester{
    public static void main(String[] args){
        QueueGrid gr = new QueueGrid();
        gr.fill(3, 4);
        System.out.println(gr);

        gr = new QueueGrid();
        gr.fill(0, 0);
        System.out.println(gr);
    }
}

