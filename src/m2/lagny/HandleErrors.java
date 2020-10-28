package m2.lagny;

import java.text.DecimalFormat;

// Class to catch the differents errors
// I could use exceptions to handle errors, but realize this by commenting on this function, and i already spent more than 2h
// So i leave it like this
public class HandleErrors {

  // Errors on the bad dates due to a bad entry
  public static String handleDateErrors( String targetDate[]) {
    if(Float.parseFloat(targetDate[0]) > 31 || Float.parseFloat(targetDate[0]) < 0) {
      return "There is an error on the day";
    }
    if(Float.parseFloat(targetDate[1]) > 12 || Float.parseFloat(targetDate[1]) < 0) {
      return "there is an error on the month";
    }
    if(Float.parseFloat(targetDate[2]) < 2020) {
      return "there is an error on the year, don't live in the past";
    }
    // I think it's may be special for a company if employees take holidays 5 years in advance no ? :)
    if(Float.parseFloat(targetDate[2]) > 2024) {
      return "you like to plan holidays in advance, right?";
    }
    /*if(currentDate == targetDate) {
      return "you can't take holidays today";
    }*/
    return "good";
  }


  // Errors on a bad entry of the amount of days off require by the employee, or if he is too greedy
  public static String handleCountErrors(float daysToTake, float daysAvailable) {
    DecimalFormat df = new DecimalFormat("###.##");

    if(daysToTake <= 0) {
      return "You have to choose a positive number";
    }
    if(daysToTake > daysAvailable) {
      return "You're asking for too much days, only " + df.format(daysAvailable) + " available";
    } else if(daysToTake == daysAvailable) {
      return "You're going to spend all you're days off available";
    }
    return "good";
  }
}
