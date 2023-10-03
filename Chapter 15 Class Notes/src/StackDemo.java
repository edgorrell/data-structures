import java.util.*;

/**
 * This program simulates an undo stack. Note that operations
 * must be undone in the opposite order in which they are first
 * issued.
*/
public class StackDemo{
    public static void main(String[] args){
        Stack<String> stack = new Stack<String>();

        for(int i = 0; i < 16; i++){
            stack.push("thing number: " + i);
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}