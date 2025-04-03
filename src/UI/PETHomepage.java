import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PETHomepage {

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Personal Expense Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // Top panel with buttons
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton homeButton = new JButton("Home");
        JButton trackerButton = new JButton("Monthly Tracker");
        JButton accountButton = new JButton("Switch Account");
        topPanel.add(homeButton);
        topPanel.add(trackerButton);
        topPanel.add(accountButton);

        // Center panel with sections
        JPanel centerPanel = new JPanel(new GridLayout(4, 1, 10, 10));

        // Account-Year panel
        JPanel accountYearPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        accountYearPanel.add(new JLabel("Account:"));
        JComboBox<String> accountDropdown = new JComboBox<>(new String[]{
                "Glexainth's Account", "Leo's Tracker", "Sherline's Account"
        });
        accountYearPanel.add(accountDropdown);

        accountYearPanel.add(new JLabel("Year:"));
        JComboBox<String> yearDropdown = new JComboBox<>(new String[]{"2024", "2025"});
        accountYearPanel.add(yearDropdown);

        // Financial data panels
        JPanel incomeSavingsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel incomeLabel = new JLabel("Total Income:");
        JTextField incomeField = new JTextField(10);
        incomeField.setEditable(false);
        JLabel savingsLabel = new JLabel("Savings:");
        JTextField savingsField = new JTextField(10);
        savingsField.setEditable(false);
        incomeSavingsPanel.add(incomeLabel);
        incomeSavingsPanel.add(incomeField);
        incomeSavingsPanel.add(savingsLabel);
        incomeSavingsPanel.add(savingsField);

        JPanel expensesDebtPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel expensesLabel = new JLabel("Total Expenses:");
        JTextField expensesField = new JTextField(10);
        expensesField.setEditable(false);
        JLabel debtLabel = new JLabel("Total Debt:");
        JTextField debtField = new JTextField(10);
        debtField.setEditable(false);
        expensesDebtPanel.add(expensesLabel);
        expensesDebtPanel.add(expensesField);
        expensesDebtPanel.add(debtLabel);
        expensesDebtPanel.add(debtField);

        // Populate fields dynamically based on account selection
        accountDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedAccount = (String) accountDropdown.getSelectedItem();

                // Example logic for dynamic data (replace with real data as needed)
                if (selectedAccount.equals("Glexainth's Account")) {
                    incomeField.setText("P 100,000");
                    savingsField.setText("P 50,000");
                    expensesField.setText("P 30,000");
                    debtField.setText("P 20,000");
                } else if (selectedAccount.equals("Leo's Tracker")) {
                    incomeField.setText("P 120,000");
                    savingsField.setText("P 70,000");
                    expensesField.setText("P 40,000");
                    debtField.setText("P 10,000");
                } else if (selectedAccount.equals("Sherline's Account")) {
                    incomeField.setText("P 90,000");
                    savingsField.setText("P 60,000");
                    expensesField.setText("P 20,000");
                    debtField.setText("P 10,000");
                }
            }
        });

        // Adding components to center panel
        centerPanel.add(accountYearPanel);
        centerPanel.add(incomeSavingsPanel);
        centerPanel.add(expensesDebtPanel);

        // Add panels to the frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible(true);
    }
}
