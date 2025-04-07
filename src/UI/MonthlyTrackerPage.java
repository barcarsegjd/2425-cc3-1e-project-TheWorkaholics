import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;

public class MonthlyTrackerPage {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MonthlyTrackerPage().createUI());
    }

    public void createUI() {
        JFrame frame = new JFrame("Monthly Tracker Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800); // Initial size for the frame
        frame.setLayout(new BorderLayout());

        // Top panel with 3 buttons
        JPanel topPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        JButton homeButton = new JButton("Home");
        JButton trackerButton = new JButton("Monthly Tracker");
        JButton switchAccountButton = new JButton("Switch Account");
        topPanel.add(homeButton);
        topPanel.add(trackerButton);
        topPanel.add(switchAccountButton);

        frame.add(topPanel, BorderLayout.NORTH);

        // Main panel: Aligning Year, Month, Monthly Income, and Monthly Balance in one row
        JPanel mainPanel = new JPanel(new GridLayout(1, 4, 10, 10));

        // Year and Month dropdowns
        JPanel yearMonthPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        yearMonthPanel.add(new JLabel("Year:"));
        yearMonthPanel.add(new JComboBox<>(new String[]{"2023", "2024", "2025"}));
        yearMonthPanel.add(new JLabel("Month:"));
        yearMonthPanel.add(new JComboBox<>(new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
        mainPanel.add(yearMonthPanel);

        // Monthly Income panel
        JPanel monthlyIncomePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        monthlyIncomePanel.add(new JLabel("Monthly Income:"));
        monthlyIncomePanel.add(new JTextField(10)); // Dynamic input line
        mainPanel.add(monthlyIncomePanel);

        // Monthly Balance panel
        JPanel monthlyBalancePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        monthlyBalancePanel.add(new JLabel("Monthly Balance:"));
        monthlyBalancePanel.add(new JTextField(10)); // Dynamic input line
        mainPanel.add(monthlyBalancePanel);

        frame.add(mainPanel, BorderLayout.CENTER);

        // Panel for both tables and archive button
        JPanel tablesAndButtonPanel = new JPanel(new BorderLayout());

        // Panel for tables (scrollable)
        JPanel tablesPanel = new JPanel(new GridLayout(2, 1, 10, 10)); // Two tables stacked vertically
        tablesPanel.add(createTablePanel("Variable Expenses:"));
        tablesPanel.add(createTablePanel("Fixed Expenses:"));

        JScrollPane scrollPane = new JScrollPane(tablesPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        tablesAndButtonPanel.add(scrollPane, BorderLayout.CENTER);

        // Bottom-right button (Archive this Page)
        JPanel bottomRightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton archiveButton = new JButton("Archive this Page");
        archiveButton.setBackground(Color.ORANGE);
        archiveButton.setForeground(Color.WHITE);
        bottomRightPanel.add(archiveButton);

        tablesAndButtonPanel.add(bottomRightPanel, BorderLayout.SOUTH);

        frame.add(tablesAndButtonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private JPanel createTablePanel(String label) {
        JPanel tablePanel = new JPanel(new BorderLayout());

        JLabel tableLabel = new JLabel(label);
        tableLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tableLabel.setFont(new Font("Arial", Font.BOLD, 16));
        tablePanel.add(tableLabel, BorderLayout.NORTH);

        String[] columnNames = {
                "Date of Transaction:", "Amount Due:", "Amount Paid:", "Category:", "Remarks:"
        };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Last row (Total) is not editable
                return row != getRowCount() - 1;
            }
        };

        // Add 15 empty rows and 1 "Total" row
        for (int i = 0; i < 20; i++) {
            model.addRow(new Object[]{"", "", "", "", ""});
        }
        model.addRow(new Object[]{"Total", "", "", "", ""});

        JTable table = new JTable(model);

        // Adding dropdown choices in the "Category" column
        JComboBox<String> categoryDropdown = new JComboBox<>(new String[]{
                "Rent", "Utilities (Electricity)", "Utilities (Water)", "Utilities (Internet)", "Subscription", "Others"
        });
        table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(categoryDropdown));

        // Format "Amount Due" and "Amount Paid" columns to accept numbers with commas
        NumberFormat format = NumberFormat.getNumberInstance();
        format.setGroupingUsed(true); // Enable commas
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setAllowsInvalid(false); // Only valid numbers
        JFormattedTextField textField = new JFormattedTextField(formatter);

        table.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(textField));
        table.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(textField));

        // Calculate totals when table is updated
        model.addTableModelListener(e -> updateTotals(table, model));

        tablePanel.add(new JScrollPane(table), BorderLayout.CENTER);

        return tablePanel;
    }

    private void updateTotals(JTable table, DefaultTableModel model) {
        double totalAmountDue = 0;
        double totalAmountPaid = 0;

        for (int row = 0; row < model.getRowCount() - 1; row++) {
            String amountDueStr = (String) model.getValueAt(row, 1);
            String amountPaidStr = (String) model.getValueAt(row, 2);

            if (amountDueStr != null && !amountDueStr.isEmpty()) {
                totalAmountDue += parseAmount(amountDueStr);
            }
            if (amountPaidStr != null && !amountPaidStr.isEmpty()) {
                totalAmountPaid += parseAmount(amountPaidStr);
            }
        }

        model.setValueAt(formatAmount(totalAmountDue), model.getRowCount() - 1, 1);
        model.setValueAt(formatAmount(totalAmountPaid), model.getRowCount() - 1, 2);
    }

    private double parseAmount(String amountStr) {
        try {
            return NumberFormat.getNumberInstance().parse(amountStr).doubleValue();
        } catch (Exception e) {
            return 0;
        }
    }

    private String formatAmount(double amount) {
        return NumberFormat.getNumberInstance().format(amount);
    }
}
