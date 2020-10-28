package m2.lagny;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BalanceCalculator {

  // hashmap to associate the number of each month to the number of days in each of these months
  public static Map<Integer,Integer> monthMap = new HashMap<>() {{
    put(01,31);
    put(02,30);
    put(03,31);
    put(04,Common.isLeapYear());
    put(05,31);
    put(06,30);
    put(07,31);
    put(8,31);
    put(9,30);
    put(10,31);
    put(11,30);
    put(12,31);
  }};

  // "main" function, this one will be call on the TestSet class
  public static String handleBalanceCalc(String date, float daysToTake) {
    String currentDate[] = Common.todayIs().split("/");
    String targetDate[] = date.split("/");

    if(HandleErrors.handleDateErrors(targetDate) != "good") {
      return HandleErrors.handleDateErrors(targetDate);
    }

    float daysAvailable = daysAvailablesAre(currentDate,targetDate);

    DecimalFormat df = new DecimalFormat("###.##");

    if(HandleErrors.handleCountErrors(daysToTake,daysAvailable) != "good") {
      return HandleErrors.handleCountErrors(daysToTake,daysAvailable);
    }

    return "you are taking " + df.format((daysToTake)) + " days off | " + df.format(daysAvailable - daysToTake) + " days off still available";
  }

  // Function to calcul the days available between today and the given date
  // It's the most tricky functions, so i decided to detail my way of thinking
  public static float daysAvailablesAre(String currentDate[], String targetDate[]) {
    float daysAvailable = 0;

    // The next line will add 12 at the available days for each full years between the 2 dates
    daysAvailable += (Float.parseFloat(targetDate[2]) - (Float.parseFloat(currentDate[2]) + 1 )) * 12;

    // Here we add the full months between the current date and the end of the years
    daysAvailable += 12 - Float.parseFloat(currentDate[1]);

    // we do the same between the target months and the beginning of his year
    daysAvailable += Float.parseFloat(targetDate[1]) - 1;

    // Here we divise the remaining number of days in the current month and the total amount of days of this months
    // And, we devise this with the number of days of the months, to have the most accurate ratio possible
    daysAvailable += (monthMap.get(Integer.parseInt(currentDate[1])) - Float.parseFloat(currentDate[0])) / monthMap.get(Integer.parseInt(currentDate[1]));

    // Finally here, we just add the remaning days off -> number of day in the month of the target day (ofc between 1 and the targeted day) divide by the number of day of this month
    daysAvailable += Float.parseFloat(targetDate[0]) / monthMap.get(Integer.parseInt(targetDate[1]));
    return daysAvailable*2;
  }
}
