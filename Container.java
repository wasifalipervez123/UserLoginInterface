import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Container extends JFrame implements ActionListener {

    // Declare the array of user IDs and passwords
    private String[][] users = { { "Admin", "Password1" }, { "Vale.Vicky", "ZZZZZZZ" }, { "Lane.Lois", "VVVVVV" },
            { "Kent.Clark", "AAAAAA" },
            { "Wayne.Bruce", "FFFFFFFF" }, { "Parker.Peter", "RRRRRRR" }, { "Rogers.Steve", "QQQQQQ" },
            { "Luther.Lex", "GGGGGG" },
            { "Osborn.Harry", "YYYYYY" }, { "Prince.Diana", "LLLLLLL" }, { "Linda Zoel", "PPPPPPPP" } };



    // Declare the components of the container
    private JLabel userLabel, passLabel, messageLabel;
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginButton;

    // Constructor to initialize the components and add them to the container
    public Container() {
        super("User Validation");
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        userLabel = new JLabel("User ID:");
        passLabel = new JLabel("Password:");
        messageLabel = new JLabel("");
        userField = new JTextField();
        passField = new JPasswordField();
        loginButton = new JButton("Login");

        add(userLabel);
        add(userField);
        add(passLabel);
        add(passField);
        add(messageLabel);
        add(new JLabel(""));
        add(loginButton);

        loginButton.addActionListener(this);
    }

    // Method to handle the action event of the login button
    public void actionPerformed(ActionEvent e) {
        // Get the user input from the text fields
        String userID = userField.getText();
        String password = new String(passField.getPassword());

        // Search the array for a matching user ID and password
        boolean found = false;
        for (int i = 0; i < users.length; i++) {
            if (users[i][0].equals(userID) && users[i][1].equals(password)) {
                found = true;
                break;
            }
        }

        // Display a message based on the search result
        if (found) {
            messageLabel.setText("Access granted.");
            messageLabel.setForeground(Color.BLUE);
            // TODO: Add code to access the program
        } else {
            messageLabel.setText("Access denied.");
            messageLabel.setForeground(Color.RED);
            // TODO: Add code to handle invalid login
        }
    }

    // Main method to create and show the container
    public static void main(String[] args) {
        Container c = new Container();
        c.setVisible(true);
    }
}
