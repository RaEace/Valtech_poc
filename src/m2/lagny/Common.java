package m2.lagny;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Common {
  //Function to have the today's date with the format i want (dd/mm/yyyy)
  public static String todayIs() {
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Date today = Calendar.getInstance().getTime();
    String todayAsString = dateFormat.format(today);
    return todayAsString;
  }

  // Function to check if the year is a leap year or not
  public static int isLeapYear() {
    String currentDate[] = Common.todayIs().split("/");
    if(Integer.parseInt(currentDate[2]) % 4 == 0) {
      if(Integer.parseInt(currentDate[2]) % 100 != 0 && Integer.parseInt(currentDate[2]) % 400 == 0) {
        return 29;
      }
    }
    return 28;
  }
}
