public class TreeTester{
    public static void main(String[] args){
        LeafTree t1 = new LeafTree("Anne");
        LeafTree t2 = new LeafTree("Peter");
        t1.addSubtree(t2);
        LeafTree t3 = new LeafTree("Zara");
        t1.addSubtree(t3);
        LeafTree t4 = new LeafTree("Savannah");
        t2.addSubtree(t4);
        System.out.println("Size: " + t1.size());
        System.out.println("Expected: 4");
        System.out.println("Leaf count: " + t1.leafCount());
        System.out.println("Expected: 2");
    }
}
