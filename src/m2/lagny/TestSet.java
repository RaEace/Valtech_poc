package m2.lagny;

public class TestSet {
  // bunch of tests on my thought
  public static void PersonnalTests() {


    /////////////////////
    //  GOOD DATA SET  //
    /////////////////////

    System.out.println("Good data \n");
    System.out.println(BalanceCalculator.handleBalanceCalc("28/10/2021",4));
    System.out.println(BalanceCalculator.handleBalanceCalc("26/10/2021",6));
    System.out.println(BalanceCalculator.handleBalanceCalc("04/11/2022",10));
    System.out.println(BalanceCalculator.handleBalanceCalc("04/06/2022",15));
    System.out.println("");


    /////////////////////
    //   BAD DATA SET  //
    /////////////////////

    System.out.println("Bad data \n");

    // data with wrong date value
    System.out.println(BalanceCalculator.handleBalanceCalc("33/10/2020",1));
    System.out.println(BalanceCalculator.handleBalanceCalc("31/13/2020",1));
    System.out.println(BalanceCalculator.handleBalanceCalc("30/10/2010",1));
    System.out.println("");

    // data with wrong days to take
    System.out.println(BalanceCalculator.handleBalanceCalc("28/10/2020",-5));
    System.out.println(BalanceCalculator.handleBalanceCalc("28/10/2020",12));
  }
}
