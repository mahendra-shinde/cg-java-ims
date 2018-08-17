import java.util.HashMap;
import java.util.Iterator;
import java.io.FileReader;

public class WordCountMap extends HashMap {
  public WordCountMap(String file)
       throws java.io.FileNotFoundException {
    super();

    FileReader reader = new FileReader(file);
    Iterator  words = new WordStreamIterator(reader);
    while ( words.hasNext() ) {
      String word = (String) words.next();
      String word_lowercase = word.toLowerCase();
      Integer frequency = (Integer) get(word_lowercase);

      if ( frequency == null ) {
	frequency = new Integer(1);
      } else {
	int value = frequency.intValue();
	frequency = new Integer(value + 1);
      }
      put(word_lowercase, frequency);
    }
  }
}
