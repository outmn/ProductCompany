package userInterface;

import sun.plugin2.ipc.windows.WindowsEvent;

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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maximgrozniy on 18.09.15.
 */
public class AdminPanel extends JFrame implements Runnable {
    private Socket socket;
    private JButton addGroup, delGroup, editGroup,addSubGroup, delSubGroup, editSubGroup, addProduct, delProduct, editProduct, statistic, searchButton;
    private JTextField search;
    private JTable productInfo;

    private JPanel mainPanel;


    // additional panels for buttons
    private JPanel addGroupPanel;
    private JPanel delGroupPanel;
    private JPanel editGroupPanel;

    private JPanel addSubGroupPanel;
    private JPanel delSubGroupPanel;
    private JPanel editSubGroupPanel;

    private JPanel addProductPanel;
    private JPanel delProductPanel;
    private JPanel editProductPanel;

    private JPanel statisticPanel;
    private JPanel searchResultPanel;
    // end


    DataInputStream in;
    DataOutputStream out;

    public AdminPanel(Socket socket) {
        super("Administrative Panel");
        System.out.println("admin");

        this.socket = socket;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(1200, 1000);
        //this.setResizable(false);

        initialisation();
        add(mainPanel);
        setVisible(true);


        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    out.writeUTF("Close");
                    socket.close();

                } catch (IOException i) {
                    i.printStackTrace();
                }
            }
        });

        this.run();


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

    private void initaddSubGroupPanel() {
        addSubGroupPanel = new JPanel(null);

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

        addSubGroupPanel.add(name);
        addSubGroupPanel.add(nameText);
        addSubGroupPanel.add(addG);
    }
    // ens







    private void initialisation() {



        if (mainPanel == null) {
            mainPanel = new JPanel(new CardLayout());
        }

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

        Action action = new Action();
        addGroup.addActionListener(action);
        delGroup.addActionListener(action);
        editGroup.addActionListener(action);
        addSubGroup.addActionListener(action);
        delSubGroup.addActionListener(action);
        editSubGroup.addActionListener(action);
        addProduct.addActionListener(action);
        delProduct.addActionListener(action);
        editProduct.addActionListener(action);
        statistic.addActionListener(action);
        searchButton.addActionListener(action);

        mainPanel.add(addGroup);
        mainPanel.add(delGroup);
        mainPanel.add(editGroup);
        mainPanel.add(addSubGroup);
        mainPanel.add(delSubGroup);
        mainPanel.add(editSubGroup);
        mainPanel.add(addProduct);
        mainPanel.add(delProduct);
        mainPanel.add(editProduct);
        mainPanel.add(statistic);
        mainPanel.add(searchButton);
        mainPanel.add(search);


    }


    private void initInfoTable() {

    }

    @Override
    public void run() {

    }





    private class Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource() == addGroup) {
                    out.writeUTF("addGroup");
//                    new AddGroupWin(socket);
                } else if (e.getSource() == delGroup) {
                    out.writeUTF("delGroup");
//                    new DelGroupWin(socket);
                } else if (e.getSource() == editGroup) {
                    out.writeUTF("editGroup");
//                    new EditGroupWin(socket);
                } else if (e.getSource() == addSubGroup) {
                    out.writeUTF("addSubGroup");
//                    new AddSubGroupWin(socket);
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
