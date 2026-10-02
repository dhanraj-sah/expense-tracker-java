import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ExpenseTracker tracker = new ExpenseTracker();

        int choice;

        do {
            System.out.println("\n===== Personal Expense Tracker =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Total Spending");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter expense name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();

                    System.out.print("Enter amount: $");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    Expense expense = new Expense(name, category, amount);
                    tracker.addExpense(expense);

                    break;

                case 2:
                    tracker.showExpenses();
                    break;

                case 3:
                    double total = tracker.getTotalExpenses();
                    System.out.println("Total Spending: $" + total);
                    break;

                case 4:
                    System.out.println("Thank you for using Expense Tracker.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (choice != 4);

        scanner.close();
    }
}