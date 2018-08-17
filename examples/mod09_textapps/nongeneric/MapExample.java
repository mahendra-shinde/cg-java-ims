import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.io.FileReader;

public class MapExample {
  public static void main(String[] args)
       throws java.io.FileNotFoundException {
    Map       word_count_map = new HashMap();
    FileReader reader = new FileReader(args[0]);
    Iterator  words = new WordStreamIterator(reader);

    while ( words.hasNext() ) {
      String word = (String) words.next();
      String word_lowercase = word.toLowerCase();
      Integer frequency = (Integer) word_count_map.get(word_lowercase);

      if ( frequency == null ) {
	frequency = new Integer(1);
      } else {
	int value = frequency.intValue();
	frequency = new Integer(value + 1);
      }
      word_count_map.put(word_lowercase, frequency);
    }
    System.out.println(word_count_map);
  }
}
