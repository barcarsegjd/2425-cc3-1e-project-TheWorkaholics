```java

import javax.swing.*;
import java.awt.*;

class Budget {
    private int budgetId;
    private double limit;
    private double spent;
    private BudgetPeriod period;

    public Budget(int budgetId, double limit, double spent, BudgetPeriod period) {
        this.budgetId = budgetId;
        this.limit = limit;
        this.spent = spent;
        this.period = period;
    }

    public double getRemainingAmount() {
        return limit - spent;
    }

    public boolean isExceeded() {
        return spent > limit;
    }

    public double getProgress() {
        return (spent / limit) * 100;
    }
}

enum BudgetPeriod {
    DAILY, WEEKLY, MONTHLY, YEARLY
}

public class BudgetApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Budget Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        Budget budget = new Budget(1, 1000.0, 250.0, BudgetPeriod.MONTHLY);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        
        panel.add(new JLabel("Budget ID:"));
        panel.add(new JLabel(String.valueOf(budget.budgetId)));
        
        panel.add(new JLabel("Limit:"));
        panel.add(new JLabel(String.valueOf(budget.limit)));
        
        panel.add(new JLabel("Spent:"));
        panel.add(new JLabel(String.valueOf(budget.spent)));
        
        panel.add(new JLabel("Remaining Amount:"));
        panel.add(new JLabel(String.valueOf(budget.getRemainingAmount())));
        
        frame.add(panel);
        frame.setVisible(true);
    }
}

```
