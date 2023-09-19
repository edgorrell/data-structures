import java.util.LinkedList;

public class ListUtil{
    /**
     * Reverses the elements in a linked list
     *
     * @param strings the linked list to reverse
    */
    public static void reverse(LinkedList<String> strings){
        for(int i = 0; i < strings.size(); i++){
            strings.addFirst(strings.remove(i));
        }   
    }
}
