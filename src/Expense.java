public class Expense {

    private String name;
    private String category;
    private double amount;

    public Expense(String name, String category, double amount) {
        this.name = name;
        this.category = category;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public void displayExpense() {
        System.out.println(
            "Name: " + name +
            " | Category: " + category +
            " | Amount: $" + amount
        );
    }
}