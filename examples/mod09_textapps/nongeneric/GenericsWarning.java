import java.util.*;
public class GenericsWarning {
  public static void main(String[] args) {
    List list = new ArrayList();
    list.add(0, new Integer(42));
    int total = ((Integer)list.get(0)).intValue();
  }
}
