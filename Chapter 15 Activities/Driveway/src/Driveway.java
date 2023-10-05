import java.util.Stack;
import java.util.Scanner;

/**
 * Class for simulating a driveway and a street, using stacks
 * of cars with license plate numbers as representation.
*/
public class Driveway{
    /**
      * Stack representing the cars in the driveway.
    */
    private Stack<Integer> drive;
    /**
      * Stack representing the cars in the street.
    */
    private Stack<Integer> street;

    /**
      * Constructor.
    */
    public Driveway(){
      // Complete the constructor
      drive = new Stack<Integer>();
      street = new Stack<Integer>();
    }

    /**
      * Add the given license plate to the driveway.
      *
      * @param plate number of license plate.
    */
    public void add(int plate){
      drive.push(plate);
      print();
    }

    /**
      * Remove the given license plate from the driveway.
      *
      * @param num number of license plate.
    */
    public void remove(int num){
      while(drive.peek() != num){
        street.push(drive.pop());
        print();
      }
      drive.pop();
      print();
      while(street.size() > 0){
        drive.add(street.pop());
        print();
      }
    }

    /**
      * Prints the driveway and street details to the screen.
    */
    public void print(){
        Stack<Integer> drive = (Stack<Integer>)this.drive.clone();
        Stack<Integer> street = (Stack<Integer>)this.street.clone();
        Stack<Integer> temp;

        System.out.println();
        System.out.print("Driveway: ");
        // Print the cars in the driveway here
        temp = new Stack<Integer>();
        while(!drive.isEmpty()){
          temp.add(drive.pop());
        }
        while(!temp.isEmpty()){
          System.out.print(temp.pop() + ", ");
        }
        System.out.println();

        System.out.print("Street: ");
        temp = new Stack<Integer>();
        while(!street.isEmpty()){
          temp.add(street.pop());
        }
        while(!temp.isEmpty()){
          System.out.print(temp.pop() + ", ");
        }
    }
}
