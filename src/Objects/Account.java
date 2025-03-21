```java
  
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

enum AccountType {
    SAVINGS, CHECKING
}

class Account {
    private int accountId;
    private AccountType accountType;
    private double balance;

    public Account(int accountId, AccountType accountType) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }
}

public class AccountApp {
    private JFrame frame;
    private JTextField amountField;
    private JTextArea outputArea;
    private Account account;

    public AccountApp() {
        account = new Account(1, AccountType.SAVINGS);
        frame = new JFrame("Account Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        amountField = new JTextField(10);
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountField.getText());
                account.deposit(amount);
                outputArea.append("Deposited: " + amount + "\n");
                outputArea.append("New Balance: " + account.getBalance() + "\n");
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountField.getText());
                if (account.withdraw(amount)) {
                    outputArea.append("Withdrew: " + amount + "\n");
                } else {
                    outputArea.append("Withdrawal failed: Insufficient funds\n");
                }
                outputArea.append("New Balance: " + account.getBalance() + "\n");
            }
        });

        frame.add(new JLabel("Amount:"));
        frame.add(amountField);
        frame.add(depositButton);
        frame.add(withdrawButton);
        frame.add(new JScrollPane(outputArea));

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new AccountApp();
    }
}

```
