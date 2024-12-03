package main.java.useraccountmanagement.frontend;



import main.java.useraccountmanagement.backend.UserAccountManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Userwindow extends JFrame {
    public Userwindow(UserAccountManagement userAccountManagement) {
        setTitle("login");
        setSize(300,200 );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setFont(new Font("Arial", Font.BOLD, 14));
       signUpButton.setBounds(90, 20, 100, 30);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setBounds(90, 90, 100, 30);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login(userAccountManagement);
                setVisible(false);
            }
        });

        signUpButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new Signup(userAccountManagement);
                setVisible(false);
            }
        });

        add(signUpButton);
        add(loginButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        UserAccountManagement userAccountManagement = new UserAccountManagement();
        new Userwindow(userAccountManagement);
    }
}
