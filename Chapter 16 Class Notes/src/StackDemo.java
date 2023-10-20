public class StackDemo{
    public static void main(String[] args){
        LinkedStack<String> stack = new LinkedStack<String>();

        stack.push("Tom");
        stack.push("Diana");
        stack.push("Harry");

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

        System.out.println("Expected: Harry Diana Tom");

    }
}
