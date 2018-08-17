import java.util.*;

public class CleanGenericsCode {

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<Integer>();
    list.add(0, new Integer(42));
    int total = list.get(0).intValue();
  }

}
