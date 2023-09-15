import java.util.LinkedList;


/**
 * A test program to reverse the entries in a linked list.
*/
public class ReverseTester
{
    public static void main(String[] args)
    {
        LinkedList<String> employeeNames = new LinkedList<>();
        employeeNames.addLast("one");
        employeeNames.addLast("two");
        employeeNames.addLast("three");
        employeeNames.addLast("four");

        ListUtil.reverse(employeeNames);
        System.out.println(employeeNames);
    }
}