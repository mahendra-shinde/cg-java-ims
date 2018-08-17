package myutilities;

import java.util.*;
import java.text.*;

public final class DateConverter2 {
  private static String DAY_OF_THE_WEEK[] =
      {"Sunday", "Monday", "Tuesday", "Wednesday",
        "Thursday", "Friday", "Saturday"};

  public static String getDayOfWeek (String theDate) {
    Date d = null;
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");

    try {
      d = sdf.parse (theDate);
    } catch (ParseException e) {
      System.out.println (e);
      e.printStackTrace();
    }

    // Create a GregorianCalendar object
    Calendar c =
        new GregorianCalendar(
            TimeZone.getTimeZone("EST"),Locale.US);
    c.setTime (d);

    return(
        DAY_OF_THE_WEEK[(c.get(Calendar.DAY_OF_WEEK)-1)]);
  }
}
