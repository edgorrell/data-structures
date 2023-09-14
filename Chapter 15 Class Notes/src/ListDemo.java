import java.util.LinkedList;
import java.util.ListIterator;

public class ListDemo{
    public static void main(String[] args){
        LinkedList<String> list = new LinkedList<String>();
        list.add("one"); list.add("two"); list.add("three"); list.add("four");
        ListIterator<String> it = list.listIterator();

        while(it.hasNext()){
            it.next();
            if(Math.random() < 0.5){
                it.remove();
            }
        }
        while(it.hasPrevious()){
            System.out.println(it.previous());
        }
    }
}
