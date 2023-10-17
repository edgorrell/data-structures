/**
 *   A program that demonstrates the LinkedList class
 */
public class ListDemo{
    public static void main(String[] args){
        LinkedList<String> list = new LinkedList<String>();
        list.addFirst("Person1");
        list.addFirst("Person2");
        list.addFirst("Person3");
        list.addFirst("Person4");
        System.out.println(list);

        ListIterator<String> itr = list.iterator();
        itr.next();
        itr.set("Person5");
        itr.next();
        itr.remove();
        
        itr = list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
