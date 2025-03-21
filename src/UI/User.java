```java

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class User {
    private int userId;
    private String name;
    private String username;
    private String email;
    private String password;

    public boolean register(String name, String email, String password) {
        // Registration logic here
        return true;
    }

    public boolean login(String username, String password) {
        // Login logic here
        return true;
    }

    public boolean updateProfile(String newName, String newEmail) {
        // Update profile logic here
        return true;
    }

    public boolean resetPassword(String oldPassword, String newPassword) {
        // Reset password logic here
        return true;
    }
}

public class UserInterface extends JFrame {
    private User user;

    public UserInterface() {
        user = new User();
        setTitle("User Management");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton registerButton = new JButton("Register");
        JButton loginButton = new JButton("Login");
        JButton updateProfileButton = new JButton("Update Profile");
        JButton resetPasswordButton = new JButton("Reset Password");

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Registration logic
            }
        });

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Login logic
            }
        });

        updateProfileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Update profile logic
            }
        });

        resetPasswordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Reset password logic
            }
        });

        add(registerButton);
        add(loginButton);
        add(updateProfileButton);
        add(resetPasswordButton);
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.setVisible(true);
    }
}

```
