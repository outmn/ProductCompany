package userInterface;

import javax.swing.*;

/**
 * Created by maximgrozniy on 18.09.15.
 */
public class AdminPanel extends JFrame {
    private JPanel panel;

    public AdminPanel() {
        super("Administrative Panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 1000);
        this.setResizable(false);
        initPanel();
        add(panel);
        setVisible(true);


    }

    private void initPanel() {
        panel = new JPanel();
    }
}
