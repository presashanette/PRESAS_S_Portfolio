//import java.util.Scanner;
//
//public class VMDriver {
//  public static void main(String[] args) {
//
//    Scanner sc = new Scanner(System.in);
//    int nChoice;
//    int nCapacity=0;
//    boolean checker = false;
//    RegularVM rvm = null;
//
//    do {
//      displayMenu();
//      System.out.print("Option : ");
//      nChoice = sc.nextInt();
//
//      switch (nChoice) {
//        case 1: // create vending machine
//          System.out.println("+------------------------------------------------+");
//          System.out.println("|       ===== CREATE A VENDING MACHINE =====     |");
//          System.out.println("|           Choose an option to proceed:         |");
//          System.out.println("| (1) Regular Vending Machine                    |");
//          System.out.println("| (2) Special Vending Machine                    |");
//          System.out.println("+------------------------------------------------+");
//          System.out.print("Option : ");
//          nChoice = sc.nextInt();
//
//          switch (nChoice) {
//            case 1: // Regular
//              //ask for info needed to create vending
//              do {
//                System.out.print("Enter the maximum capacity of each slot: ");
//                nCapacity = sc.nextInt();
//
//                if (nCapacity < 10)
//                  System.out.println("The maximum capacity should be at least 10! Try again!");
//              } while (nCapacity < 10);
//
//              rvm = new RegularVM();
//
//              sc.nextLine();
//
//              checker = true;
//
//              System.out.println("+------------------------------------------------+");
//              System.out.println("|  Regular Vending Machine successfully created! |");
//              System.out.println("+------------------------------------------------+");
//
//              break;
//
//            case 2: // Special
//              System.out.println("+------------------------------------------------+");
//              System.out.println("|       This option is not yet available!        |");
//              System.out.println("+------------------------------------------------+");
//              break;
//          }
//          break;
//        case 2: // test vending machine
//          if (checker == true) {
//            System.out.println("+------------------------------------------------+");
//            System.out.println("|       ===== TEST A VENDING MACHINE =====       |");
//            System.out.println("|          Choose an option to proceed:          |");
//            System.out.println("| (1) Check the features                         |");
//            System.out.println("| (2) Test the Maintenance                       |");
//            System.out.println("+------------------------------------------------+");
//            System.out.print("Option : ");
//            nChoice = sc.nextInt();
//
//            switch (nChoice) {
//              case 1: // check the features
//                //rvm.testFeatures();
//                break;
//
//              case 2: // Test the maintenance
//                rvm.testMaintenance(nCapacity);
//                break;
//            }
//            sc.nextLine();
//
//          }
//
//          else
//          {
//            System.out.println("+------------------------------------------------+");
//            System.out.println("|     There is no vending machine to test yet!   |");
//            System.out.println("|            Please create one first.            |");
//            System.out.println("+------------------------------------------------+");
//          }
//          break;
//        case 3: // exit (vending)
//          System.out.println("+------------------------------------------------+");
//          System.out.println("|  Thank you for trying out our vending machine! |");
//          System.out.println("+------------------------------------------------+");
//          break;
//      }
//
//    } while (nChoice != 3);
//    if(rvm != null)
//      rvm.shutDownExecutor();
//    sc.close();
//  }
//
//  public static void displayMenu() {
//    System.out.println("+------------------------------------------------+");
//    System.out.println("| ===== WELCOME TO VENDING MACHINE FACTORY ===== |");
//    System.out.println("|          Choose an option to proceed:          |");
//    System.out.println("| (1) Create Vending Machine                     |");
//    System.out.println("| (2) Test a Vending Machine                     |");
//    System.out.println("| (3) Exit                                       |");
//    System.out.println("+------------------------------------------------+");
//  }
//}