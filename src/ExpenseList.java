// Import required functionality
import java.util.List;
import java.util.ArrayList;

/**
 * Class storing a list of expenses
 */
public class ExpenseList {

    // An expense list also has aggregated details like totals and distinct members
    List<Expense> ListOfExpenses = new ArrayList<Expense>();
    int numExpenses;
    double allSpending;
    List<String> members;

    // An expense list starts empty
    public ExpenseList() {
        numExpenses = 0;
        allSpending = 0;
        members = new ArrayList<String>();
    }

    // Adding an expense requires the same details as creating an expense object
    public void AddExpense(String payer, double price, String descrip) {
        ListOfExpenses.add(new Expense(payer, price, descrip));
        // After adding expense aggregated details need updating
        if (!members.contains(payer)) {
            members.add(payer);
        }
        numExpenses += 1;
        allSpending += price;

    }

    // Prints details on the expenses, either all or relating to a specific member
    public void MemberDetails(String member) {
        System.out.println("The expenses recorded so far for " + member + ":");
        // Print details only relating to specified member
        int elementNo = 1;
        double memberSpending = 0;
        for (Expense element : ListOfExpenses) {
            if (element.GetName().equals(member) || member.equals("all")) {
                System.out.print(elementNo + ") ");
                element.Print();
                memberSpending += element.GetAmount();
                elementNo += 1;
            }
        }
        // Catch case where no expense are shown
        if (elementNo == 1) {System.out.println("x) No expenses.");}
        System.out.println("Total spent is: £" + memberSpending);
        // "all" option breaks here
        if (member.contains("all")) {return;}
        // If a specific member, the amount owed or owes is shown
        double memberShare = allSpending / 3;
        if (memberSpending > memberShare) {
            System.out.println(member + " is owed £" + (memberSpending - memberShare));
        } else if (memberSpending < memberShare) {
            System.out.println(member + " owes £" + (memberShare - memberSpending));
        } else {
            System.out.println(member + " owes nothing");
        }
    }

    // Summary line printed
    public void Costs() {
        System.out.println("The total value of expenses is: £" + allSpending);
    }


}
