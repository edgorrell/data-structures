import java.util.*;
import java.io.*;
/**
 * Read all words from a file and add them to a
 * map whose keys are word lengths and whose values
 * are comma-separated strings of words of the same length.
 * Then print out those strings, in increasing order by
 * the length of their entries.
 * Modify Worked Example 15.1.
 */
public class StringLengthMap1{
    public static void main(String[] args) throws FileNotFoundException{
        String filename = "Chapter 15 Activities\\StringLengthMap\\src\\test1.txt";

        try (Scanner scan = new Scanner(new File(filename))){

            // Create your map here
            Map<Integer, String> map = new HashMap<Integer, String>();

            while (scan.hasNext()){
                String word = clean(scan.next());
                Integer i = word.length();

                // Update the map here
                // Use the Java 8 merge method
                if(map.get(i) == null){
                    map.put(i," " + word);
                    continue;
                } else if(!map.get(i).contains(" " + word)){
                    map.merge(i,word,(old, next) -> old + ", " + next);
                    continue;
                }
            }

            // Print the strings, in increasing order of their length
            // Use this format: 1: i, a, i
            for(Integer key : map.keySet()){
                System.out.println(key + ":" + map.get(key));
            }
        } catch (FileNotFoundException e){
            System.out.println("Cannot open: " + filename);
        }
    }

    public static String clean(String s){
        String r = "";
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (Character.isLetter(c)){
                r = r + c;
            }
        }
        return r.toLowerCase();
    }

}
