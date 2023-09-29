import java.util.*;
import java.io.*;
/**
 * Read all words from a file and add them to a map
 * whose keys are the first letters of the words and
 * whose values are sets of words that start with
 * that same letter.
 * Then print out the word sets in alphabetical order.
 * Use the Java 8 merge() feature.
*/
public class FirstLetterMap2{
    public static void main(String[] args){
        String filename = "Chapter 15 Activities\\FirstLetterMap\\FirstLetterMap1\\src\\test1.txt";

        try (Scanner scan = new Scanner(new File(filename))){

            // Create your map here
            Map<Character, Set<String>> map = new HashMap<Character, Set<String>>();

            while (scan.hasNext()){
                String word = clean(scan.next());
                Character c = word.charAt(0);
                Set<String> tempSet = new HashSet<String>();
                tempSet.add(word);

                // Update the map here
                // Use the Java 8 merge method
                map.merge(c,tempSet,(old, next) -> combine(old, next));
            }
            scan.close();

            // Print the map here in this form
            // a: [a, able, aardvark]
            for(Character key : map.keySet()){
                System.out.println(key + ": " + map.get(key));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open: " + filename);
        }
    }

    public static Set<String> combine(Set<String> s1, Set<String> s2){
        Set<String> tempSet = new HashSet<String>();
        tempSet.addAll(s1); tempSet.addAll(s2);
        return tempSet;
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
