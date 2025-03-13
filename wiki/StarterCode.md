```java

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Expense {
    private String description;
    private double amount;

    public Expense(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }
}

public class ExpenseTracker {
    private List<Expense> expenses;

    public ExpenseTracker() {
        expenses = new ArrayList<>();
    }

    public void addExpense(String description, double amount) {
        expenses.add(new Expense(description, amount));
    }

    public void displayExpenses() {
        System.out.println("Expenses:");
        for (Expense expense : expenses) {
            System.out.println(expense.getDescription() + ": $" + expense.getAmount());
        }
    }

    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        Scanner scanner = new Scanner(System.in);
        String command;

        do {
            System.out.println("Enter expense description (or 'exit' to quit): ");
            command = scanner.nextLine();
            if (!command.equalsIgnoreCase("exit")) {
                System.out.println("Enter expense amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // consume newline
                tracker.addExpense(command, amount);
            }
        } while (!command.equalsIgnoreCase("exit"));

        tracker.displayExpenses();
        scanner.close();
    }
}

```
