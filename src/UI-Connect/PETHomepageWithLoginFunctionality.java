import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.HashMap;

public class PETHomepageWithLoginFunctionality {
    private static HashMap<String, UserAccount> accounts = new HashMap<>();
    private static String loggedInUser;

    public static void main(String[] args) {
        loadAccountData();
        showLoginScreen();
    }

    // Login screen
    public static void showLoginScreen() {
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(300, 200);

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Username:"));
        JTextField usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        JPasswordField passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");
        panel.add(loginButton);
        panel.add(registerButton);

        loginFrame.add(panel);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (accounts.containsKey(username) && accounts.get(username).getPassword().equals(password)) {
                loggedInUser = username;
                loginFrame.dispose();
                showHomeScreen();
            } else {
                JOptionPane.showMessageDialog(loginFrame, "Invalid credentials. Try again.");
            }
        });

        registerButton.addActionListener(e -> {
            loginFrame.dispose();
            showRegisterScreen();
        });

        loginFrame.setVisible(true);
    }

    // Register screen
    private static void showRegisterScreen() {
        JFrame registerFrame = new JFrame("Register");
        registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerFrame.setSize(300, 200);

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Username:"));
        JTextField usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        JPasswordField passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton registerButton = new JButton("Register");
        JButton cancelButton = new JButton("Cancel");
        panel.add(registerButton);
        panel.add(cancelButton);

        registerFrame.add(panel);

        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (accounts.containsKey(username)) {
                JOptionPane.showMessageDialog(registerFrame, "Username already exists.");
            } else {
                accounts.put(username, new UserAccount(username, password));
                saveAccountData();
                JOptionPane.showMessageDialog(registerFrame, "Registration successful!");
                registerFrame.dispose();
                showLoginScreen();
            }
        });

        cancelButton.addActionListener(e -> {
            registerFrame.dispose();
            showLoginScreen();
        });

        registerFrame.setVisible(true);
    }
    
    public static void addAccountScreen() {
        JFrame registerFrame = new JFrame("Register");
        registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerFrame.setSize(300, 200);

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Username:"));
        JTextField usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        JPasswordField passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton registerButton = new JButton("Register");
        JButton cancelButton = new JButton("Cancel");
        panel.add(registerButton);
        panel.add(cancelButton);

        registerFrame.add(panel);

        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (accounts.containsKey(username)) {
                JOptionPane.showMessageDialog(registerFrame, "Username already exists.");
            } else {
                accounts.put(username, new UserAccount(username, password));
                saveAccountData();
                JOptionPane.showMessageDialog(registerFrame, "Registration successful!");
                registerFrame.dispose();
            }
        });

        cancelButton.addActionListener(e -> {
            registerFrame.dispose();
        });

        registerFrame.setVisible(true);
    }
    // Home screen
    private static void showHomeScreen() {
        JFrame frame = new JFrame("Personal Expense Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout());
        JButton homepageButton = new JButton("Visit Homepage");
        JButton addButton = new JButton("Add Data");
        JButton viewButton = new JButton("View Data");
        JButton updateButton = new JButton("Update Data");
        JButton deleteButton = new JButton("Delete Account");
        JButton logoutButton = new JButton("Logout");
        topPanel.add(homepageButton);
        topPanel.add(addButton);
        topPanel.add(viewButton);
        topPanel.add(updateButton);
        topPanel.add(deleteButton);
        topPanel.add(logoutButton);

        frame.add(topPanel, BorderLayout.NORTH);
        
        homepageButton.addActionListener(e -> {
            frame.dispose();
            PETHomepage.constructUIHome();
        });
        addButton.addActionListener(e -> addData());
        viewButton.addActionListener(e -> viewData());
        updateButton.addActionListener(e -> updateData());
        deleteButton.addActionListener(e -> {
            deleteAccount();
            frame.dispose();
            showLoginScreen();
        });
        logoutButton.addActionListener(e -> {
            frame.dispose();
            loggedInUser = null;
            showLoginScreen();
        });

        frame.setVisible(true);
    }
    
    // Visit Homepage
    // Create: Add financial data
    private static void addData() {
        UserAccount account = accounts.get(loggedInUser);
        String income = JOptionPane.showInputDialog("Enter income:");
        String savings = JOptionPane.showInputDialog("Enter savings:");
        String expenses = JOptionPane.showInputDialog("Enter expenses:");
        String debt = JOptionPane.showInputDialog("Enter debt:");

        if (income != null && savings != null && expenses != null && debt != null) {
            account.setIncome(income);
            account.setSavings(savings);
            account.setExpenses(expenses);
            account.setDebt(debt);
            saveAccountData();
            JOptionPane.showMessageDialog(null, "Data added successfully!");
        }
    }
    
    // Read: View financial data
    private static void viewData() {
        UserAccount account = accounts.get(loggedInUser);
        String message = "Income: " + account.getIncome() +
                         "\nSavings: " + account.getSavings() +
                         "\nExpenses: " + account.getExpenses() +
                         "\nDebt: " + account.getDebt();
        JOptionPane.showMessageDialog(null, message);
    }

    // Update: Modify financial data
    private static void updateData() {
        UserAccount account = accounts.get(loggedInUser);
        String income = JOptionPane.showInputDialog("Update income:", account.getIncome());
        String savings = JOptionPane.showInputDialog("Update savings:", account.getSavings());
        String expenses = JOptionPane.showInputDialog("Update expenses:", account.getExpenses());
        String debt = JOptionPane.showInputDialog("Update debt:", account.getDebt());

        if (income != null && savings != null && expenses != null && debt != null) {
            account.setIncome(income);
            account.setSavings(savings);
            account.setExpenses(expenses);
            account.setDebt(debt);
            saveAccountData();
            JOptionPane.showMessageDialog(null, "Data updated successfully!");
        }
    }

    // Delete: Remove account
    public static void deleteAccount() {
        accounts.remove(loggedInUser);
        saveAccountData();
        JOptionPane.showMessageDialog(null, "Account deleted successfully!");
    }

    // Save accounts to file
    private static void saveAccountData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("accounts.ser"))) {
            oos.writeObject(accounts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load accounts from file
    private static void loadAccountData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("accounts.ser"))) {
            accounts = (HashMap<String, UserAccount>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            accounts = new HashMap<>();
        }
    }
}

// UserAccount class to store user data
class UserAccount implements Serializable {
    private String username;
    private String password;
    private String income = "0";
    private String savings = "0";
    private String expenses = "0";
    private String debt = "0";

    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getSavings() {
        return savings;
    }

    public void setSavings(String savings) {
        this.savings = savings;
    }

    public String getExpenses() {
        return expenses;
    }

    public void setExpenses(String expenses) {
        this.expenses = expenses;
    }

    public String getDebt() {
        return debt;
    }

    public void setDebt(String debt) {
        this.debt = debt;
    }
}
