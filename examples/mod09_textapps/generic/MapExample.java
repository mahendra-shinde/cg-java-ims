import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.io.FileReader;

public class MapExample {
  public static void main(String[] args)
       throws java.io.FileNotFoundException {
    Map<String,Integer> word_count_map = new HashMap<String,Integer>();
    FileReader reader = new FileReader(args[0]);
    Iterator<String>  words = new WordStreamIterator(reader);

    while ( words.hasNext() ) {
      String word = words.next();
      String word_lowercase = word.toLowerCase();
      int frequency;

      if ( word_count_map.containsKey(word) ) {
	frequency = word_count_map.get(word_lowercase);
      } else {
	frequency = 0;
      }

      word_count_map.put(word_lowercase, ++frequency);
    }
    System.out.println(word_count_map);
  }
}
