package m2.lagny;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner obj = new Scanner(System.in);
    int choice;
    do {
      System.out.println("**************BALANCE-CALCULATOR************");
      System.out.println("*                                          *");
      System.out.println("*       Press 1 for my personnal tests     *");
      System.out.println("*         Press 2 for your own tests       *");
      System.out.println("*              Press 3 for exit            *");
      System.out.println("*                                          *");
      System.out.println("******************************************** `\n");


      choice = obj.nextInt();

      switch (choice) {
        case 1:
          TestSet.PersonnalTests();
          System.out.println("");
          System.out.println("**********************************");
          System.out.println("** Press any keys to continue.. **");
          System.out.println("********************************** \n");
          obj.next();
          break;
        case 2:
          System.out.println("************************************************************");
          System.out.println("*                                                          *");
          System.out.println("*  Enter the date of your holidays and the amount of days  *");
          System.out.println("*                separate them with a '-'                  *");
          System.out.println("*               for example : 26/05/2021-3                 *");
          System.out.println("*                                                          *");
          System.out.println("************************************************************ \n");

          String date = obj.next();
          String[] options = date.split("-");
          System.out.println(BalanceCalculator.handleBalanceCalc(options[0],Float.parseFloat(options[1])));
          System.out.println("");
          System.out.println("**********************************");
          System.out.println("*  Press any keys to continue..  *");
          System.out.println("********************************** \n");
          obj.next();
          break;
        case 3:
          System.out.println("");
          System.out.println("**************");
          System.out.println("* exiting... *");
          System.out.println("************** \n");
          break;
        default:
          throw new IllegalStateException("Invalid choice");
      }
    } while (choice != 3);
  }
}
