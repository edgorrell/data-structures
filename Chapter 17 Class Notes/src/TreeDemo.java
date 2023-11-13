/**
   This class demonstrates the tree class.
*/
public class TreeDemo
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
      System.out.println("Size: " + t1.size());
   }
}
