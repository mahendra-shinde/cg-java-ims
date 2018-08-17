package myutilities;

import java.util.*;
import java.text.*;

public final class DateConverter {
  private static final String DAY_OF_THE_WEEK [] =
    {"Sunday", "Monday", "Tuesday", "Wednesday",
    "Thursday", "Friday", "Saturday"};

  public static String getDayOfWeek (String theDate){
    int month, day, year;

    StringTokenizer st = new StringTokenizer (theDate, "/");

    month = Integer.parseInt(st.nextToken ());
    day = Integer.parseInt(st.nextToken());
    year = Integer.parseInt(st.nextToken());
    Date d = new Date (year, month, day);

    return (DAY_OF_THE_WEEK[d.getDay()]);
  }
}
