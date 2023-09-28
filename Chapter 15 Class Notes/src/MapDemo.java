import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
    This program demonstrates a map that maps names to colors.
*/
public class MapDemo{
    public static void main(String[] args){
        Map<String, Color> colors = new HashMap<>();

        colors.put("person1", Color.red);
        colors.put("person2", Color.green);
        colors.put("person3", Color.blue);
        colors.put("person4", Color.red); // many to one
        colors.put("person1", Color.black); // cant do one to many, get replaced
        System.out.println(colors.get("person1"));

        Set<String> keys = colors.keySet();
        for(String key : keys){
            System.out.println(key + "(" + key.hashCode() + ")" + "," + colors.get(key));
        }
    }
}
