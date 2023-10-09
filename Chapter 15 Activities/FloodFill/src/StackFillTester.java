public class StackFillTester{
    public static void main(String[] args){
        StackGrid gr = new StackGrid();
        gr.fill(3, 4);
        System.out.println(gr);

        gr = new StackGrid();
        gr.fill(0, 0);
        System.out.println(gr);
    }
}
