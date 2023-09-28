import java.util.*;
/**
 * A program to add, remove, modify or print
 * student names and grades.
*/
public class Gradebook{
    public static void main(String[] args){
        Map<String, String> gradebook = new HashMap<String, String>();
        Scanner scan = new Scanner(System.in);

        while(true){
            System.out.println("A)dd R)emove M)odify P)rint Q)uit");
            String input = scan.next().toUpperCase();

            if (input.equals("Q")){
                break;
            } else if (input.equals("A")){
                System.out.println("Enter name and grade to add:");
                gradebook.put(scan.next(), scan.next());
            } else if (input.equals("R")){
                System.out.println("Enter name to remove:");
                gradebook.remove(scan.next());
            } else if (input.equals("M")){
                System.out.println("Enter name and grade to modify:");
                gradebook.put(scan.next(), scan.next());
            } else if (input.equals("P")){
                for(String name : gradebook.keySet()){
                    System.out.println(name + ": " + gradebook.get(name));
                }
            } else {
                break;
            }
        }
    }
}
