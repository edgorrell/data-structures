import java.util.*;


/**
 * Class for reversing the order of a sentence.
*/
public class SentenceReverser{
    /**
     * Reverses the given sentence.
     *
     * @param sentence Sentence to be reversed.
     * @return reversed sentence.
    */
    public static String reverse(String sentence){
        Scanner scan;
        ArrayList<String> strs = new ArrayList<String>();
        while(sentence.contains(".")){
            strs.add(sentence.substring(0, sentence.indexOf(".")).toLowerCase());
            sentence = sentence.substring(sentence.indexOf(".")+1);
        }
        String str = "";
        Stack<String> stack = new Stack<String>();
        for(String s : strs){
            scan = new Scanner(s);
            while(scan.hasNext()){
                stack.push(scan.next());
            }
            String next = stack.peek();
            str += next.toUpperCase().substring(0,1) + next.substring(1) + " ";
            stack.pop();
            while(!stack.isEmpty()){
                str += stack.pop() + " ";
            }
            str = str.substring(0,str.length()-1);
            str += ". ";
        }

        return str;
    }
}
