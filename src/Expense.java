/**
 * Class for storing information relating to an expense
 */
public class Expense {

    // An expense consists of a person who paid, an amount paid, and a description
    // These are fixed one an expense is created
    private String paidBy;
    private double amount;
    private String description;

    // When an expense is created, all three pieces of information must be supplied
    public Expense(String payer, double price, String descrip) {
        paidBy = payer;
        amount = price;
        description = descrip;
    }

    // Information on expense can only be accessed through the following three functions (read only)
    public void Print() {
        System.out.println(paidBy + " payed £" + amount + " - " + description);
    }

    public String GetName() {
        return paidBy;
    }

    public double GetAmount() {
        return amount;
    }

}
