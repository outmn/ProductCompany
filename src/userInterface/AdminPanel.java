package userInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by maximgrozniy on 18.09.15.
 */
public class AdminPanel implements Runnable {
    private Socket socket;

    private JFrame mainFrame;

    private JButton addGroup, delGroup, editGroup,
            addSubGroup, delSubGroup, editSubGroup,
            addProduct, delProduct, editProduct,
            statistic, searchButton;

    private JTextField search;
    private JTable productInfo;

    private JPanel controlPanel;
    private JPanel clarificationPanel;


    // additional panels for buttons
    private JPanel addGroupPanel, delGroupPanel, editGroupPanel;
    private JPanel addSubGroupPanel, delSubGroupPanel, editSubGroupPanel;
    private JPanel addProductPanel, delProductPanel, editProductPanel;
    private JPanel statisticPanel, searchResultPanel;
    // end

    private CardLayout cardLayout;


    DataInputStream in;
    DataOutputStream out;

    public AdminPanel(Socket socket) {
        this.socket = socket;

        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        this.run();

        createAndShowGUI();


    }


    private void createAndShowGUI() {
        mainFrame = new JFrame("Administrative Panel");
        mainFrame.setSize(1100,600);
        mainFrame.setLayout(null);
        mainFrame.setLocationRelativeTo(null);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initControlPanel();
        initClarificationPanel();

        initAddGroupPanel();
        initAddSubGroupPanel();

        clarificationPanel.add("AddGroup", addGroupPanel);
        clarificationPanel.add("AddSubGroup", addSubGroupPanel);

        mainFrame.add(controlPanel);
        mainFrame.add(clarificationPanel);

        mainFrame.setVisible(true);
    }



    private void initControlPanel() {
        if (controlPanel == null) {
            controlPanel = new JPanel(null);
            controlPanel.setBounds(0, 0, 800, 600);

            initButons();

        }
    }


    private void initClarificationPanel() {
        if (clarificationPanel == null) {
            clarificationPanel = new JPanel();
            clarificationPanel.setBackground(Color.CYAN);

            clarificationPanel.setBounds(800, 0, 300, 600);

            clarificationPanel.setLayout(new CardLayout());

            clarificationPanel.add(new JButton("Button"));

            cardLayout = (CardLayout)(clarificationPanel.getLayout());
        }

    }



    // initialisation of adding panels
    private void initAddGroupPanel() {
        addGroupPanel = new JPanel(null);

        JLabel name = new JLabel("Имя групы");
        name.setBounds(0, 0, 100, 25);

        JTextField nameText = new JTextField();
        nameText.setBounds(100, 0, 200, 25);

        JButton addG = new JButton("ДОБАВИТЬ");
        addG.setBounds(0, 350, 300, 50);
        addG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        addGroupPanel.add(name);
        addGroupPanel.add(nameText);
        addGroupPanel.add(addG);
    }

    private void initAddSubGroupPanel() {
        addSubGroupPanel = new JPanel(null);

        JLabel name = new JLabel("Имя Подгрупы");
        name.setBounds(0, 0, 100, 25);

        JTextField nameText = new JTextField();
        nameText.setBounds(100, 0, 200, 25);

        JButton addG = new JButton("ДОБАВИТЬ");
        addG.setBounds(0, 350, 300, 50);
        addG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        addSubGroupPanel.add(name);
        addSubGroupPanel.add(nameText);
        addSubGroupPanel.add(addG);
    }
    // ens







    private void initButons() {

        if (addGroup == null) {
            addGroup = new JButton("Add Group");
            addGroup.setBounds(0, 0, 200, 50);
        }

        if (delGroup == null) {
            delGroup = new JButton("Delete Group");
            delGroup.setBounds(0, 50, 145, 50);
        }

        if (editGroup == null) {
            editGroup = new JButton("Edit Group");
            editGroup.setBounds(145, 50, 145, 50);
        }

        if (addSubGroup == null) {
            addSubGroup = new JButton("Add SubGroup");
            addSubGroup.setBounds(0, 150, 290, 50);
        }


        if (delSubGroup == null) {
            delSubGroup = new JButton("Delet SubGroup");
            delSubGroup.setBounds(0, 200, 145, 50);
        }


        if (editSubGroup == null ) {
            editSubGroup = new JButton("Edit SubGroup");
            editSubGroup.setBounds(145, 200, 145, 50);
        }

        if (addProduct == null) {
            addProduct = new JButton("Add Product");
            addProduct.setBounds(0, 300, 290, 50);
        }


        if (delProduct == null) {
            delProduct = new JButton("Delete Product");
            delProduct.setBounds(0, 350, 145, 50);
        }


        if (editProduct == null) {
            editProduct = new JButton("Edit Product");
            editProduct.setBounds(145, 350, 145, 50);
        }


        if (statistic == null) {
            statistic = new JButton("Statistic");
            statistic.setBounds(0, 500, 290, 50);
        }


        if (searchButton == null) {
            ImageIcon icon = new ImageIcon("images/SearchIcon.png");
            searchButton = new JButton(icon);
            searchButton.setBounds(1150, 10, 50, 50);
        }



        if (search == null) {
            search = new JTextField();
            search.setBounds(310, 10, 840, 50);
        }

        ActionAdministrator actionAdministrator = new ActionAdministrator();
        addGroup.addActionListener(actionAdministrator);
        delGroup.addActionListener(actionAdministrator);
        editGroup.addActionListener(actionAdministrator);
        addSubGroup.addActionListener(actionAdministrator);
        delSubGroup.addActionListener(actionAdministrator);
        editSubGroup.addActionListener(actionAdministrator);
        addProduct.addActionListener(actionAdministrator);
        delProduct.addActionListener(actionAdministrator);
        editProduct.addActionListener(actionAdministrator);
        statistic.addActionListener(actionAdministrator);
        searchButton.addActionListener(actionAdministrator);

        controlPanel.add(addGroup);
        controlPanel.add(delGroup);
        controlPanel.add(editGroup);
        controlPanel.add(addSubGroup);
        controlPanel.add(delSubGroup);
        controlPanel.add(editSubGroup);
        controlPanel.add(addProduct);
        controlPanel.add(delProduct);
        controlPanel.add(editProduct);
        controlPanel.add(statistic);
        controlPanel.add(searchButton);
        controlPanel.add(search);


    }


    private void initInfoTable() {

    }

    @Override
    public void run() {

    }





    private class ActionAdministrator implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource() == addGroup) {
                    out.writeUTF("addGroup");
                    cardLayout.show(clarificationPanel, "AddGroup");


                } else if (e.getSource() == delGroup) {
                    out.writeUTF("delGroup");
                    cardLayout.show(clarificationPanel, "DelGroup");

                } else if (e.getSource() == editGroup) {
                    out.writeUTF("editGroup");
//                    new EditGroupWin(socket);
                } else if (e.getSource() == addSubGroup) {
                    out.writeUTF("addSubGroup");
                    cardLayout.show(clarificationPanel, "AddSubGroup");

                } else if (e.getSource() == delSubGroup) {
                    out.writeUTF("delSubGroup");
//                    new DelSubGroupWin(socket);
                } else if (e.getSource() == editSubGroup) {
                    out.writeUTF("editSubGroup");
//                    new EditSubGroupWin(socket);
                } else if (e.getSource() == addProduct) {
                    out.writeUTF("addProduct");
//                    new AddProductWin(socket);
                } else if (e.getSource() == delProduct) {
                    out.writeUTF("delProduct");
//                    new DelProductWin(socket);
                } else if (e.getSource() == editProduct) {
                    out.writeUTF("editProduct");
//                    new EditProductWin(socket);
                } else if (e.getSource() == statistic) {
                    out.writeUTF("statistics");
//                    new StatisticsWin(socket);
                } else if (e.getSource() == searchButton) {
//                    out.writeUTF("search");
                }

            } catch (IOException exc) {
                exc.printStackTrace();
            }
        }
    }
}
