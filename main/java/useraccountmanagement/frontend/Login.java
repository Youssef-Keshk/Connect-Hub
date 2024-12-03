package main.java.useraccountmanagement.frontend;



import main.java.useraccountmanagement.backend.UserAccountManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    public Login(UserAccountManagement userAccountManagement) {
        setTitle("login");
        setSize(300,300 );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        JLabel lUserId = new JLabel("UserId");
        lUserId.setFont(new Font("Arial", Font.BOLD, 14));
        lUserId.setBounds(50,35,100,30);
        add(lUserId);

        JLabel lPassword = new JLabel("Password");
        lPassword.setFont(new Font("Arial", Font.BOLD, 14));
        lPassword.setBounds(50,119,90,30);
        add(lPassword);

        JTextField tUserId = new JTextField();
        tUserId.setFont(new Font("Arial", Font.BOLD, 14));
        tUserId.setBounds(120,35,100,30);
        add(tUserId);

        JPasswordField tPassword = new JPasswordField();
        tPassword.setFont(new Font("Arial", Font.BOLD, 14));
        tPassword.setBounds(120,119,100,30);
        add(tPassword);

        JButton bLogin = new JButton("Login");
        bLogin.setFont(new Font("Arial", Font.BOLD, 14));
        bLogin.setBounds(100,200,100,30);
        add(bLogin);

        setVisible(true);

        bLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userId = tUserId.getText().trim();
                String password = new String(tPassword.getPassword()).trim();

                if (userId.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter userId and password", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int loginResult = userAccountManagement.login(userId, password);

                switch (loginResult) {
                    case -1:
                        JOptionPane.showMessageDialog(null, "User not found", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "Wrong password", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null, "Login Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Unexpected error occurred", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            }
        });


    }


}
