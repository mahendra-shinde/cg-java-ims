import java.util.*;

public class TestIteration {
  public static void main(String[] args) {

    // Create a list
    System.out.print("Create a list: ");
    List list = new ArrayList();
    list.add("one");
    list.add("second");
    list.add("3rd");
    list.add(new Integer(4));
    list.add(new Float(5.0F));
    list.add("second");
    list.add(new Integer(4));
    System.out.println(list);

    //
    int idx = 0;
    System.out.println("Iterate using an iterator: ");
    Iterator it = list.iterator();
    while ( it.hasNext() ) {
      System.out.println("  " + idx++ + ": " + it.next() );
    }
    System.out.println();

    //
    idx = 0;
    System.out.println("Iterate using enhanced for-loop: ");
    for ( Object o : list ) {
      System.out.println("  " + idx++ + ": " + o );
    }
    System.out.println();
  }
}
