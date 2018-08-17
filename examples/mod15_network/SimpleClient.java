import java.net.*;
import java.io.*;

public class SimpleClient {
  public static void main(String args[]) {
    try {
      // Open your connection to a server, at port 5432
      // localhost used here
      Socket s1 = new Socket("127.0.0.1", 5432);  

      // Connect a reader to the socket
      BufferedReader br = new BufferedReader(
        new InputStreamReader(s1.getInputStream()));

      // Read the input and print it to the screen
      System.out.println(br.readLine());

      // When done, just close the steam and connection
      br.close();
      s1.close();
    } catch (ConnectException connExc) {
      System.err.println("Could not connect to the server.");
    } catch (IOException e) {
      // ignore
    }
  }
}
