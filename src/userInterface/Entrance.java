package userInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by maximgrozniy on 17.09.15.
 */
public class Entrance extends JFrame implements Runnable{

    private Socket socket;

    private JPanel panel;
    private JComboBox userBox;
    private JPasswordField password;
    private JButton enterButton;
    private JButton helpButton;

    private String users[] = {
            Users.Customer.toString(),
            Users.SalesManager.toString(),
            Users.Administrator.toString()};


    public Entrance(Socket socket) {
        super("Entrance");
        this.socket = socket;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 500);
        this.setResizable(false);
        initPanel();
        add(panel);
        setVisible(true);

        this.run();


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
                    checkPassword();

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
                    checkPassword();

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

    private void checkPassword() {

        try {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            out.writeInt(userBox.getSelectedIndex());

            String passWord = "";
            char [] pass = password.getPassword();

            for (int i = 0; i < pass.length; i++) {
                passWord += pass[i];
            }

            out.writeUTF(passWord);

            if (in.readBoolean()) {
                newWindow();
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void newWindow() {
        dispose();
        new WindowsManager(userBox.getSelectedIndex(), socket);
        System.out.println("newWindow");

    }

    @Override
    public void run() {

    }
}
