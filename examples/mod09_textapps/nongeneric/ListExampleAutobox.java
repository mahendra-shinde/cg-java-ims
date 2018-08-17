import java.util.*;

// same as ListExample, but using autoboxing
public class ListExampleAutobox {
  public static void main(String[] args) {
    List list = new ArrayList();
    list.add("one");
    list.add("second");
    list.add("3rd");
    list.add(4);
    list.add(5.0F);
    list.add("second");
    list.add(4);
    System.out.println(list);
  }
}
