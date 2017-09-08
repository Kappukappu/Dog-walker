/**
 * Created by Kappukappu on 9/5/17.
 */
import java.applet.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;

public class Dogwalker extends Applet implements ActionListener {
    ArrayList<Dog> dogList;
    Object[][] data;
    int totalPrice;
    int counter;
    JTextField nameArea;
    JCheckBox sizeBox, aggressiveBox;
    JButton addCustomer, packup, clearAll;
    JTable table;
    DefaultTableModel tableModel;


    public void init() {
        //initialization
        totalPrice = 0;
        counter = 0;
        dogList = new ArrayList<Dog>();
        setSize(800, 800);
        nameArea = new JTextField("Enter your name", 20);
        sizeBox = new JCheckBox("check it if your dog is large");
        aggressiveBox = new JCheckBox("check it if your dog is agressive");
        addCustomer = new JButton("Add");
        addCustomer.addActionListener(this);
        packup = new JButton("Pack up");
        packup.addActionListener(this);
        clearAll = new JButton("Clear All");
        clearAll.addActionListener(this);
        String sampleDog[] = {"Ethan",
                    "small",
                    "no",
                    "13"}; //just for testing

        //add buttons and text fields for adding new dog
        add(nameArea); add(sizeBox); add(aggressiveBox); add(addCustomer);

        //add table
        data = null;
        String[] header = {"#","Name","Size","Agressive","Price"};
        Object[] empty = {"","","","",""};
        Object[] lastLine = {"Total","","","",totalPrice};
        tableModel = new DefaultTableModel(data,header);
        table = new JTable(tableModel);
        tableModel.addRow(header);
        tableModel.addRow(empty);
        tableModel.addRow(lastLine);
        tableModel.addRow(empty);

        //set column width
        for (int i=0; i<5; i++){
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setMinWidth(150);
        }
        add(table);

        add(packup); add(clearAll);

    }

    public void addNewDog(){
        //add new dog to dogList
        String name = nameArea.getText();
        boolean size = sizeBox.isSelected();
        boolean aggressive = aggressiveBox.isSelected();
        Dog newDog = new Dog(name,size,aggressive);
        dogList.add(newDog);

        //update table
        Object[] newLine = {counter,newDog.getName(),newDog.getSize(),newDog.getAggressive(),newDog.getPrice()};
        tableModel.addRow(newLine);
        counter++;
        totalPrice += newDog.getPrice();
        nameArea.setText("");
        tableModel.setValueAt(totalPrice,2,4);
        table.invalidate();
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addCustomer){
            addNewDog();
        }
        else if (e.getSource()==clearAll){
            tableModel.setRowCount(0);
            totalPrice = 0;
            counter = 0;
            dogList = new ArrayList<Dog>();
            String[] header = {"#","Name","Size","Agressive","Price"};
            Object[] empty = {"","","","",""};
            Object[] lastLine = {"Total","","","",totalPrice};
            tableModel.addRow(header);
            tableModel.addRow(empty);
            tableModel.addRow(lastLine);
            tableModel.addRow(empty);
        }
    }
}