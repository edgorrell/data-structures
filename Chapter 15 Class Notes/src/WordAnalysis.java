import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * This program checks which words in a file are not present in a dictionary.
*/
public class WordAnalysis
{
    public static void main(String[] args) throws FileNotFoundException{
        Set<String> dictionary = readWords("words");
        Set<String> book = readWords("throughTheLookingGlass");
        System.out.println(book.size());
        book.removeAll(dictionary);
        System.out.println(book);
    }

    /**
     * Reads all words from a file.
     *
     * @param filename the name of the file
     * @return a set with all lowercased words in the file. Here, a
     * word is a sequence of upper- and lowercase letters.
    */
    public static Set<String> readWords(String filename) throws FileNotFoundException{
        Scanner scan = new Scanner(new File("Chapter 15 Class Notes/src/"+filename), "UTF-8");
        scan.useDelimiter("[^a-zA-Z]+");
        Set<String> words = new HashSet<String>();

        while(scan.hasNext()){
            words.add(scan.next().toLowerCase());
        }

        return words;
    }
}
