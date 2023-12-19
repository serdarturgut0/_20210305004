import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class thepage extends JFrame implements ActionListener{


    JFrame frame = new JFrame();
    JLabel mainLabel = new JLabel("BOUTIQUE STORE INVENTORY SYSTEM");
    JLabel secondaryLabel = new JLabel("Welcome to the inventory system, here you can add or remove products from the database.");
    JButton addNewButton = new JButton("Add New Product");
    JButton deleteButton = new JButton("Delete");
    JButton exitButton = new JButton("Exit");
    JLabel pagelogo = new JLabel();
    JTable tblData = new JTable();
    DefaultTableModel model = (DefaultTableModel) tblData.getModel();
    JScrollPane tabloicin = new JScrollPane();
    JTextField idField = new JTextField();
    JTextField typeField = new JTextField();
    JTextField genderField = new JTextField();
    JTextField sizeField = new JTextField();
    JTextField colorField = new JTextField();
    JTextField dateField = new JTextField();
    JLabel idLabel = new JLabel("Enter the product ID:");
    JLabel typeLabel = new JLabel("Enter the product type:");
    JLabel genderLabel = new JLabel("Enter the products gender:");
    JLabel sizeLabel = new JLabel("Enter the product size:");
    JLabel colorLabel = new JLabel("Enter the product color:");
    JLabel dateLabel = new JLabel("Enter the products registery date:");
    JButton update = new JButton("Update");
    JTable table = new JTable();
    Object[] columns = {"1","2","3","4","5","6"};
    DefaultTableModel modeling = new DefaultTableModel();


    thepage(){
        model.setColumnIdentifiers(columns);
        table.setModel(model);

        table.setBackground(Color.BLUE);
        table.setForeground(Color.red);
        table.setSelectionBackground(Color.CYAN);
        table.setGridColor(Color.GREEN);
        table.setSelectionForeground(Color.BLACK);
        table.setFont(new Font("Trebuchet MS",Font.PLAIN,20));
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);

        JScrollPane pane = new JScrollPane();
        pane.setForeground(Color.BLUE);
        pane.setBackground(Color.CYAN);
        pane.setBounds(500,195,601,600);
        frame.getContentPane().add(pane);

        Object[] row = new Object[6];

        ImageIcon pageLogo = new ImageIcon("logomini.png");
        pagelogo.setIcon(pageLogo);
        pagelogo.setOpaque(true);
        pagelogo.setVisible(true);
        pagelogo.setBounds(0,0,180,180);

        mainLabel.setBounds(178,92,900,55);
        mainLabel.setFont(new Font("Trebuchet MS",Font.BOLD,44));
        mainLabel.setForeground(new Color(11, 1, 151));

        secondaryLabel.setBounds(180,123,900,55);
        secondaryLabel.setFont(new Font("Trebuchet MS",Font.PLAIN,20));
        secondaryLabel.setForeground(Color.darkGray);

        addNewButton.setBounds(1140,190,200,80);
        addNewButton.addActionListener(this);
        addNewButton.setFocusable(false);
        addNewButton.setBackground(Color.WHITE);


        deleteButton.setBounds(1140,310,200,80);
        deleteButton.addActionListener(this);
        deleteButton.setFocusable(false);
        deleteButton.setBackground(Color.WHITE);

        exitButton.setBounds(1140,650,200,80);
        exitButton.addActionListener(this);
        exitButton.setFocusable(false);
        exitButton.setBackground(Color.WHITE);

        update.setBounds(1140,430,200,80);
        update.addActionListener(this);
        update.setFocusable(false);
        update.setBackground(Color.WHITE);

        tblData.setVisible(true);
        tblData.setBounds(500,190,600,640);
        tblData.setBackground(new Color(238,238,238));

        idField.setBounds(50,220,400,50);
        idField.setFont(new Font("TAHOMA",Font.PLAIN,30));

        idLabel.setBounds(50,185,400,50);

        typeField.setBounds(50,320,400,50);
        typeField.setFont(new Font("TAHOMA",Font.PLAIN,30));

        typeLabel.setBounds(50,285,400,50);

        genderField.setBounds(50,420,400,50);
        genderField.setFont(new Font("TAHOMA",Font.PLAIN,30));

        genderLabel.setBounds(50,385,400,50);

        sizeField.setBounds(50,520,400,50);
        sizeField.setFont(new Font("TAHOMA",Font.PLAIN,30));

        sizeLabel.setBounds(50,485,400,50);

        colorField.setBounds(50,620,400,50);
        colorField.setFont(new Font("TAHOMA",Font.PLAIN,30));

        colorLabel.setBounds(50,585,400,50);

        dateField.setBounds(50,720,400,50);
        dateField.setFont(new Font("TAHOMA",Font.PLAIN,30));

        dateLabel.setBounds(50,685,400,50);


        ImageIcon littleicon = new ImageIcon("logo1.jpg");


        frame.add(table);
        frame.add(update);
        frame.setTitle("Clothing Boutique Inventory System");
        frame.add(idLabel);
        frame.add(typeLabel);
        frame.add(genderLabel);
        frame.add(sizeLabel);
        frame.add(colorLabel);
        frame.add(dateLabel);
        frame.add(dateField);
        frame.add(colorField);
        frame.add(sizeField);
        frame.add(genderField);
        frame.add(typeField);
        frame.add(idField);
        frame.add(tblData);
        frame.setLocationRelativeTo(null);
        frame.add(pagelogo);
        frame.add(secondaryLabel);
        frame.add(exitButton);
        frame.add(deleteButton);
        frame.add(addNewButton);
        frame.add(mainLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1400,900);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setIconImage(littleicon.getImage());



    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitButton) {
            if (JOptionPane.showConfirmDialog(frame, "Are sure that you want to exit?", "Boutique Inventory System", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                System.exit(0);
        }

        if (e.getSource() == addNewButton) {
            String id = idField.getText();
            String type = typeField.getText();
            String gender = genderField.getText();
            String size = sizeField.getText();
            String color = colorField.getText();
            String date = dateField.getText();

            if (!id.isEmpty() && !type.isEmpty() && !gender.isEmpty() && !size.isEmpty() && !color.isEmpty() && !date.isEmpty()) {
                String[] row = {id, type, gender, size, color, date};
                DefaultTableModel model = (DefaultTableModel) tblData.getModel();
                model.addRow(row);

                idField.setText("");
                typeField.setText("");
                genderField.setText("");
                sizeField.setText("");
                colorField.setText("");
                dateField.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Please fill in all fields.");
            }


        }
        if (e.getSource() == deleteButton) {
            int row = tblData.getSelectedRow();

            if (row >= 0) {
                DefaultTableModel model = (DefaultTableModel) tblData.getModel();
                model.removeRow(row);

                JOptionPane.showMessageDialog(frame, "Product deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a row to delete.");
            }
        }
        if (e.getSource()==update){
            int selectedRow = tblData.getSelectedRow();

            if (selectedRow >= 0) {
                DefaultTableModel model = (DefaultTableModel) tblData.getModel();

                String id = idField.getText();
                String type = typeField.getText();
                String gender = genderField.getText();
                String size = sizeField.getText();
                String color = colorField.getText();
                String date = dateField.getText();

                String[] updatedRow = {id, type, gender, size, color, date};

                model.setValueAt(id, selectedRow, 0);
                model.setValueAt(type, selectedRow, 1);
                model.setValueAt(gender, selectedRow, 2);
                model.setValueAt(size, selectedRow, 3);
                model.setValueAt(color, selectedRow, 4);
                model.setValueAt(date, selectedRow, 5);

                JOptionPane.showMessageDialog(frame, "Product updated successfully!");

                idField.setText("");
                typeField.setText("");
                genderField.setText("");
                sizeField.setText("");
                colorField.setText("");
                dateField.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a row to update.");
            }
        }




    }

}

