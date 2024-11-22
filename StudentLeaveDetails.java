package universty.management;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class StudentLeaveDetails extends JFrame implements ActionListener {

    JTextField crollno;
    JTable table;
    JButton search, print, update, add, cancel,accept ,not_acept;

    StudentLeaveDetails() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading = new JLabel("Search by Id Number");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        crollno = new JTextField();
        crollno.setBounds(180, 20, 150, 20);
        add(crollno);
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from stud");
            while (rs.next()) {
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        table = new JTable();

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from studentleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);

        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        accept = new JButton("Accept");
        accept .setBounds(220, 70, 80, 20);
        accept .addActionListener(this);
        add(accept );

        not_acept = new JButton("Not Accept");
        not_acept.setBounds(320, 70, 115, 20);
        not_acept.addActionListener(this);
        add(not_acept);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }
public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == search){
    String query = "select * from studentleave where rollno = '"+crollno.getText()+"'";
    try{
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery(query);
        table.setModel(DbUtils.resultSetToTableModel(rs));
    }catch(Exception e){
        e.printStackTrace();
    }
}else if (ae.getSource()==print){
    try{
        table.print();
        
    }catch(Exception e){
        e.printStackTrace();
    }
}    else if(ae.getSource()==accept){
    setVisible(false);
 
}    else if(ae.getSource()==not_acept){
    setVisible(false);
 
}
    else if(ae.getSource()==cancel){
    setVisible(false);
 
}
}
    public static void main(String[] args) {
        new StudentLeaveDetails();
    }

}
