import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ExpenseTracker {

    private ArrayList<Expense> expenses;
    private static final String FILE_NAME = "expenses.txt";

    public ExpenseTracker() {
        expenses = new ArrayList<>();
        loadExpensesFromFile();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
        saveExpenseToFile(expense);
        System.out.println("Expense added successfully.");
    }

    public void showExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        System.out.println("\n--- Expense List ---");

        for (Expense expense : expenses) {
            expense.displayExpense();
        }
    }

    public double getTotalExpenses() {
        double total = 0;

        for (Expense expense : expenses) {
            total += expense.getAmount();
        }

        return total;
    }
private void saveExpenseToFile(Expense expense) {
    try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
        writer.write(expense.toString() + System.lineSeparator());
    } catch (IOException e) {
        System.out.println("Error saving expense to file: " + e.getMessage());
    }
}

private void loadExpensesFromFile() {
    File file = new File(FILE_NAME);

    if (!file.exists()) {
        return;
    }

    try (Scanner reader = new Scanner(file)) {
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] parts = line.split(",");

            if (parts.length == 3) {
                String name = parts[0];
                String category = parts[1];
                double amount = Double.parseDouble(parts[2]);

                expenses.add(new Expense(name, category, amount));
            }
        }
    } catch (IOException | NumberFormatException e) {
        System.out.println("Error loading expenses from file: " + e.getMessage());
    }
}
 
}