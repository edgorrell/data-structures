import java.util.LinkedList;

/**
 * A test class for the downsize method.
*/
public class DownsizeTester
{
    public static void main(String[] args)
    {
        LinkedList<String> employeeNames = new LinkedList<>();
        employeeNames.add("one");
        employeeNames.add("two");
        employeeNames.add("three");
        employeeNames.add("four");
        employeeNames.add("five");
        employeeNames.add("six");
        employeeNames.add("seven");

        Business.downsize(employeeNames, 3);

        System.out.println(employeeNames);
    }
}
