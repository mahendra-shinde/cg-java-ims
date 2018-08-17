import java.util.*;

public class SortingExample2 {
  public static void main(String[] args)
       throws java.io.FileNotFoundException {
    Map       word_count_map = new WordCountMap(args[0]);
    Set	      entry_set = word_count_map.entrySet();
    
    System.out.println("Unsorted Entry Set:\n" + entry_set);

    // Create a list of the entries and sort it alphabetically
    List      entry_list = new ArrayList(entry_set);
    Collections.sort(entry_list, new AlphaComparator());
    System.out.println("\nEntry Set (sorted alpha):\n" + entry_list);

    // Sort the list by frequency
    Collections.sort(entry_list, new FreqComparator());
    System.out.println("\nEntry Set (sorted by freq):\n" + entry_list);
  }

  private static class AlphaComparator implements Comparator {
    public int compare(Object e1, Object e2) {
      String word1 = (String) ((Map.Entry) e1).getKey();
      String word2 = (String) ((Map.Entry) e2).getKey();
      return word1.compareTo(word2);
    }
  }
  private static class FreqComparator implements Comparator {
    public int compare(Object e1, Object e2) {
      Integer freq1 = (Integer) ((Map.Entry) e1).getValue();
      Integer freq2 = (Integer) ((Map.Entry) e2).getValue();
      return freq2.compareTo(freq1);
    }
  }
}
