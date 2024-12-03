package main.java.useraccountmanagement.frontend;



import main.java.database.JsonHandler;
import main.java.useraccountmanagement.backend.User;
import main.java.useraccountmanagement.backend.UserAccountManagement;
import main.java.useraccountmanagement.backend.UserCheck;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class Signup extends JFrame {
    public Signup(UserAccountManagement userAccountManagement) {
        setTitle("Signup");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // جعل النافذة في منتصف الشاشة
        setLayout(null);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 70, 100, 25);
        JTextField emailField = new JTextField();
        emailField.setBounds(150, 70, 200, 25);
        add(emailLabel);
        add(emailField);


        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 110, 100, 25);
        JTextField usernameField = new JTextField();
        usernameField.setBounds(150, 110, 200, 25);
        add(usernameLabel);
        add(usernameField);


        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 150, 100, 25);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 150, 200, 25);
        add(passwordLabel);
        add(passwordField);


        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(50, 190, 100, 25);
        JTextField dobField = new JTextField("YYYY-MM-DD");
        dobField.setBounds(150, 190, 200, 25);
        add(dobLabel);
        add(dobField);


        JButton signupButton = new JButton("signup");
        signupButton.setBounds(150, 250, 100, 30);
        add(signupButton);
        setVisible(true);


        signupButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                UserCheck userCheck = new UserCheck();
                if (usernameField.getText().isEmpty()|| passwordField.getText().isEmpty() || dobField.getText().isEmpty()|| emailField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all the required fields!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(!userCheck.Checkemailformat(emailField.getText())){
                    JOptionPane.showMessageDialog(null, "Please enter a valid email address!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if (!userCheck.Checkpasswaedformat(passwordField.getText())){
                    JOptionPane.showMessageDialog(null, "password must contain 8 character more:numbers or little character or Capital character or[@-#-$]", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if (!userCheck.Checkemailrepeat(userAccountManagement,emailField.getText())){
                    JOptionPane.showMessageDialog(null, "this email is already exist!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    User newuser=new User(emailField.getText(),usernameField.getText(),new String(passwordField.getPassword()) ,"offline", LocalDate.parse(dobField.getText()));
                    userAccountManagement.signup(newuser);
                    String filePath = "D:\\java\\Connect-Hub\\Connect-Hub\\main\\java\\resources\\users.json";
                    JsonHandler<User> userJsonHandler=new JsonHandler<User>(filePath, User.class);
                    userJsonHandler.saveAll(userAccountManagement.getUsers());
                    setVisible(false);
                    new Userwindow(userAccountManagement);
                }

            }
        });









    }

}
