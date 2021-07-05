// Import required functionality
import java.util.List;
import java.util.Scanner; // Import the Scanner class for getting user input

/**
 * Class for the specific expense group of Ed, Edd, and Eddy
 */
public class ExpenseGroup {

    // Specific group only has certain allowed members
    List<String> allowedMembers = List.of("Ed", "Edd", "Eddy");
    ExpenseList EEEExpenseList = new ExpenseList();

    // Details on class, callable before instance creation
    public static void Details() {
        System.out.println("You can use this class to track expenses between Ed, Edd and Eddy.");
    }

    // User input wrapper for adding an expense
    public void AddEExpense() {
        // Initiate variables including scanner object for user input
        String eName;
        String ePriceS;
        double ePrice = -1;
        String eDescription;
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        // Loop until correct name input or breaking
        while (true) {
            // User input name, break loop if allowable, or return if breaking
            System.out.print("Enter name: ");
            eName = myObj.nextLine();  // Read user input
            if (eName.equals("break")) {return;}
            if (allowedMembers.contains(eName)) {break;}
            System.out.println(eName + " is not one of the three accepted names. Please input either Ed, Edd, or Eddy.");
            System.out.println("If you no longer want to add an expense, please type break.");
        }
        System.out.println(eName + " is an acceptable name.");
        // Loop until correct value input or breaking
        while (true) {
            // User input value, break loop if allowable, or return if breaking
            System.out.print("Enter expense value: £");
            ePriceS = myObj.nextLine();  // Read user input
            if (ePriceS.equals("break")) {break;}
            try {
                ePrice = Double.parseDouble(ePriceS);
                System.out.println("Value is: £" + ePriceS);  // Output user input
                break;
                // Catch if input cannot be converted to float
            } catch(NumberFormatException ex) {
                System.out.println("Please enter a valid number.");
                System.out.println("If you no longer want to add an expense, please type break.");
            }
        }
        // No handling for description
        System.out.print("Enter a short description: ");
        eDescription = myObj.nextLine();  // Read user input
        // Finally add user specified expense
        EEEExpenseList.AddExpense(eName, ePrice, eDescription);
    }

    // User input wrapper for allowable member details
    public void EMemberDetails() {
        // Create a Scanner object for user input
        String eName;
        Scanner myObj = new Scanner(System.in);
        // Loop until allowable name or break
        while (true) {
            // User input
            System.out.print("Enter name: ");
            eName = myObj.nextLine();  // Read user input
            // Accept input or escape
            if (eName.equals("break")) {return;}
            if (allowedMembers.contains(eName)) {break;}
            // User info on unacceptability
            System.out.println(eName + " is not one of the three accepted names. Please input either Ed, Edd, or Eddy.");
            System.out.println("If you no longer want to add an expense, please type break.");
        }
        // Finally add print user details
        EEEExpenseList.MemberDetails(eName);

    }

    public static void main(String[] args) {
        // Details of the ExpenseGroup object
        ExpenseGroup.Details();
        // Create a group to store Ed, Edd, and Eddy's expenses
        ExpenseGroup EEEGroup = new ExpenseGroup();
        // User input
        String user_option;
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        // Loop until user wants to break
        while (true) {
            // Allowable options
            System.out.println("\nThe user options are:");
            System.out.println("add - to add an expense");
            System.out.println("all - to see info on all expenses");
            System.out.println("user - to see a breakdown by specific user");
            System.out.println("break - to exit");
            System.out.print("Enter option: ");
            user_option = myObj.nextLine();  // Read user input
            System.out.println(" ");
            // Check input for viability
            switch(user_option) {
                case "break":
                    return;
                case "add":
                    EEEGroup.AddEExpense();
                    break;
                case "all":
                    EEEGroup.EEEExpenseList.MemberDetails("all");
                    break;
                case "user":
                    EEEGroup.EMemberDetails();
                    break;
                default:
                    System.out.println("Invalid input!");
            }
        }
    }
}