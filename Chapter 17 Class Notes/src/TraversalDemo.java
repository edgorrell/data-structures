import java.util.Iterator;

/**
    This program demonstrates tree traversal.
*/
public class TraversalDemo
{
    public static void main(String[] args)
    {
        Tree<String> t1 = new Tree<String>("Anne");
        Tree<String> t2 = new Tree<String>("Peter");
        t1.addSubtree(t2);
        Tree<String> t3 = new Tree<String>("Zara");
        t1.addSubtree(t3);
        Tree<String> t4 = new Tree<String>("Savannah");
        t2.addSubtree(t4);

        // Count short names with visitor
        class ShortNameCounter<T> implements Tree.Visitor<T>
        {
            public int counter = 0;
            public void visit(Object data)
            {
                System.out.println(data);
                if (data.toString().length() <= 5) { counter++; }
            }
        }

        ShortNameCounter<String> v = new ShortNameCounter<String>();

        t1.preorder(v);
        System.out.println("Short names: " + v.counter); 
    }
}
