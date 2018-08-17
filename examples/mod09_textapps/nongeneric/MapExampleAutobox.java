import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.io.FileReader;

public class MapExampleAutobox {
  public static void main(String[] args)
       throws java.io.FileNotFoundException {
    Map       word_count_map = new HashMap();
    FileReader reader = new FileReader(args[0]);
    Iterator  words = new WordStreamIterator(reader);

    while ( words.hasNext() ) {
      String word = (String) words.next();
      String word_lowercase = word.toLowerCase();
      int frequency = word_count_map.get(word_lowercase);

      word_count_map.put(word_lowercase, ++frequency);
    }
    System.out.println(word_count_map);
  }
}
