/*
 * This is an example using javadoc tags.
 */

package mypack;

import java.util.List;

/**
 * This class contains a bunch of documentation tags.
 * @author Bryan Basham
 * @version 0.5(beta)
 */
public class DocExample {

  /** A simple attribute tag. */
  private int x;

  /**
   * This variable a list of stuff.
   * @see #getStuff()
   */
  private List stuff;

  /**
   * This constructor initializes the x attribute.
   * @param x_value  the value of x
   */
  public DocExample(int x_value) {
    this.x = x_value;
  }

  /**
   * This method return some stuff.
   * @throws IllegalStateException if no stuff is found
   * @return List the list of stuff
   */
  public List getStuff()
       throws IllegalStateException {
    if ( stuff == null ) {
      throw new java.lang.IllegalStateException("ugh, no stuff");
    }
    return stuff;
  }
}
