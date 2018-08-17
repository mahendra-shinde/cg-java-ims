import java.io.*;
import java.util.Scanner;
public class ScanTest{
  public static void main(String [] args){
    Scanner s = new Scanner(System.in);
    String param = s.next();
    System.out.println("the param 1" + param);
    int value = s.nextInt();
    System.out.println("second param" + value);
    s.close();
  }
}
