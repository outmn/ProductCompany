package userInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by maximgrozniy on 17.09.15.
 */
public class Entrance extends JFrame {

    private JPanel panel;
    private JComboBox userBox;
    private JPasswordField password;
    private JButton enterButton;
    private JButton helpButton;

    private String users[] = {
            Users.Customer.toString(),
            Users.SalesManager.toString(),
            Users.Administrator.toString()};
    private PasswordAuthentication passwordAuthentication;

    public Entrance(PasswordAuthentication passwordAuthentication) {
        super("Entrance");
        this.passwordAuthentication = passwordAuthentication;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 500);
        this.setResizable(false);
        initPanel();
        add(panel);
        setVisible(true);


    }

    private void initPanel() {
        panel = new JPanel(null);

        if (userBox == null) {
            userBox = new JComboBox(users);
            userBox.setVisible(true);
            userBox.setBounds(100, 200, 175, 20);
        }

        if (password == null) {
            password = new JPasswordField(10);
            password.setBounds(300, 200, 175, 20);
            password.setEditable(true);
            password.setVisible(true);
            password.setActionCommand("");
            password.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
        }

        if (enterButton == null) {
            enterButton = new JButton("Enter");
            enterButton.setBounds(200, 230, 175, 20);
            enterButton.setVisible(true);
            enterButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    switch (passwordAuthentication.check(userBox.getSelectedIndex(), password.getPassword())) {
                        case "Administrator":
                            System.out.println("Administrator");
                            break;
                        case "Sales manager":
                            System.out.println("Sales manager");
                            break;
                        case "Customer":
                            System.out.println("Customer");
                    }


                }
            });

        }

        if (helpButton == null) {
            helpButton = new JButton("Help");
            helpButton.setBounds(200, 260, 175, 20);
            helpButton.setVisible(true);
        }



        panel.add(userBox);
        panel.add(password);
        panel.add(enterButton);
        panel.add(helpButton);

    }

}
