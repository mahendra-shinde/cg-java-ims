import java.util.Iterator;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * This class presents an iterator over words in an input stream.
 * A "word" is defined as any contiguous sequence of letters (including
 * an apostrope for possesive words).  All whitespace and punctuation
 * is removed.
 */
public class WordStreamIterator implements Iterator {
  private static char    APOSTROPHE = '\'';
  private BufferedReader input;
  private String         current_line;
  private int            current_index;
  private String         next_word = null;

  /**
   * This is the basic constructor.
   */
  public WordStreamIterator(InputStreamReader stream) {
    input = new BufferedReader(stream);
    // Prime the word pump
    nextLine();
    nextWord();
  }

  /**
   * This method determines whether or not there are any more words.
   */
  public boolean hasNext() {
    return (next_word != null);
  }

  /**
   * This method return the "next word" in the stream.
   *
   * The "next word" is already available (an may be null), but this
   * method must move forward in the stream to get the next, next word.
   */
  public Object next() {
    String result = next_word;

    nextWord();

    return result;
  }

  /**
   * The <TT>remove</TT> method is not supported.
   */
  public void remove() {
    throw new UnsupportedOperationException();
  }

  /**
   * This private method is used to read the next line in the
   * input stream.
   *
   * <TT>current_line</TT> will be <TT>null</TT> when we reach the EOF.
   */
  private void nextLine() {
    try {
      current_line = input.readLine();
      if ( current_line == null ) {
	input.close();
      }
      current_index = 0;
    } catch (IOException e) {
      current_line = null;
    }
  }

  /**
   * This private method is used to parse the next word in the
   * input stream.
   *
   * This is the work-horse of this class.  It moves the current_index
   * through the current_line until it finds the start of a word, it
   * then parses the word (storing the letters in a buffer) until it
   * reaches the end of the word (a non-letter character or EOL).
   *
   * <TT>next_word</TT> will be <TT>null</TT> when we reach the EOF.
   */
  private void nextWord() {
    final StringBuffer buffer = new StringBuffer();
    char ch;
    buffer.setLength(0);

    // parse over all non-letters, handling line breaks and EOF
    do {
      if ( current_line == null ) {
	// quit loop on EOF
	break;
      }

      if ( current_index >= current_line.length() ) {
	// if at the end of the current line,
	// read a new one and continue from the top (could be EOF)
	nextLine();
	continue;
      }

      if ( ! Character.isLetter(current_line.charAt(current_index)) ) {
	// skip over all non-letters
	current_index++;
      } else {
	// quit loop, when a letter is reached
	break;
      }
    } while ( true );

    // parse letters into the buffer
    do {
      if ( current_line == null ) {
	// quit loop on EOF
	break;
      }

      // get the next character
      ch = current_line.charAt(current_index);
      if ( ! Character.isLetter(ch) && (ch != APOSTROPHE) ) {
	// quit loop, when a non-letter is reached
	break;
      }

      // store the character and move to the index forward
      buffer.append(ch);
      current_index++;

      // if we have reached the end of line,
      // then get the next line
      // and quit the loop (EOL always means the end of a word)
      if ( current_index >= current_line.length() ) {
	nextLine();
	break;
      }
    } while ( true );

    // create the next word, if any
    if ( buffer.length() == 0 ) {
      next_word = null;
    } else {
      next_word = buffer.toString();
    }
  }
}
