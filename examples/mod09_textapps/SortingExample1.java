import java.util.Arrays;
import java.text.DecimalFormat;

public class SortingExample1 {
  public static void main(String[] args) {
    double[]  random_values = new double[10];

    // populate the array with random numbers
    for ( int i = 0; i < random_values.length; i++ ) {
      random_values[i] = Math.random();
    }

    // print out unsorted array
    System.out.println("Unsorted Array:");
    printArray(random_values);

    // print out sorted array
    Arrays.sort(random_values);
    System.out.println("Sorted Array:");
    printArray(random_values);
  }

  private static void printArray(double array[]) {
    System.out.print('[');
    for ( int i = 0; i < array.length; i++ ) {
      System.out.print(FORMAT.format(array[i]));
      if ( (i + 1) < array.length ) {
	System.out.print(", ");
      }
    }
    System.out.println(']');
  }
  private static DecimalFormat FORMAT = new DecimalFormat("0.000");
}
