import java.util.LinkedList;
import java.util.ListIterator;

public class ListDemo{
    public static void main(String[] args){
        LinkedList<String> list = new LinkedList<String>();
        list.add("one"); list.add("two"); list.add("three"); list.add("four");
        ListIterator<String> it = list.listIterator();

        for(String str : list){
            if(str.equals("three")){
                list.remove(str);
            }
        }
        System.out.println(list);
    }
}
