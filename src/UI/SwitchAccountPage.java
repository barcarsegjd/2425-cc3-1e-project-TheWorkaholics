import javax.swing.*;
import java.awt.*;

public class SwitchAccountPage {

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Account Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // Top panel with buttons
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton homeButton = new JButton("Home");
        JButton trackerButton = new JButton("Monthly Tracker");
        JButton switchAccountButton = new JButton("Switch Account");
        topPanel.add(homeButton);
        topPanel.add(trackerButton);
        topPanel.add(switchAccountButton);

        // Center panel for account management details
        JPanel centerPanel = new JPanel(new GridLayout(4, 1, 10, 10));

        // Account dropdown and password field
        JPanel accountPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        accountPanel.add(new JLabel("Account:"));
        JComboBox<String> accountDropdown = new JComboBox<>(new String[]{
                "Glexainth's Account", "Leo's Tracker", "Sherline's Account"
        });
        accountPanel.add(accountDropdown);

        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        passwordPanel.add(new JLabel("Password:"));
        JPasswordField passwordField = new JPasswordField(10);
        passwordPanel.add(passwordField);

        // Action buttons
        JPanel topActionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton loginButton = new JButton("Log In");
        JButton deleteButton = new JButton("Delete Account");
        deleteButton.setBackground(Color.RED); // Set Delete Account button to red
        deleteButton.setForeground(Color.WHITE); // Set text color to white
        topActionPanel.add(loginButton);
        topActionPanel.add(deleteButton);

        JPanel bottomActionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton addAccountButton = new JButton("Add New Account");
        JButton logoutButton = new JButton("Log Out");
        logoutButton.setBackground(Color.ORANGE); // Set Log Out button to orange
        logoutButton.setForeground(Color.BLACK); // Set text color to black
        bottomActionPanel.add(addAccountButton);
        bottomActionPanel.add(logoutButton);

        // Add panels to the center panel
        centerPanel.add(accountPanel);
        centerPanel.add(passwordPanel);
        centerPanel.add(topActionPanel);
        centerPanel.add(bottomActionPanel);

        // Add panels to the frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible(true);
    }
}
