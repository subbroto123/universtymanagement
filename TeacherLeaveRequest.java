
package universty.management;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class TeacherLeaveRequest extends JFrame implements ActionListener {

    Choice ctime;
    JTextField cempid, trason;
    JDateChooser dcdate;
    JButton submit,cancel;

    TeacherLeaveRequest () {
        setSize(500, 550);
        setLayout(null);
        setLocation(500, 100);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Apply Leave ");
        heading.setBounds(40, 50, 300, 30);
        heading.setFont(new Font("Tohoma", Font.BOLD, 20));
        add(heading);

        JLabel lblrollno = new JLabel("Employee Id");
        lblrollno.setBounds(60, 100, 200, 20);
        lblrollno.setFont(new Font("Tohoma", Font.PLAIN, 18));
        add(lblrollno);

        cempid = new JTextField();
        cempid.setBounds(60, 130, 200, 25);
        add(cempid);

        JLabel lblrason = new JLabel("Leave Reason");
        lblrason.setBounds(300, 100, 200, 20);
        lblrason.setFont(new Font("Tohoma", Font.PLAIN, 20));
        add(lblrason);
        
        trason = new JTextField();
        trason.setBounds(300, 130, 150, 30);
        add(trason);
        
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 180, 200, 20);
        lbldate.setFont(new Font("Tohoma", Font.PLAIN, 20));
        add(lbldate);
        dcdate = new JDateChooser();
        dcdate.setBounds(60, 210, 200, 24);
        add(dcdate);

        JLabel lbltime = new JLabel("Time Duration");
        lbltime.setBounds(60, 260, 200, 20);
        lbltime.setFont(new Font("Tohoma", Font.PLAIN, 18));
        add(lbltime);

       ctime = new Choice();
       ctime.setBounds(60, 290, 200, 20);
       ctime.add("Full Time");
       ctime.add("Half Time");
        add(ctime);
         submit = new JButton("Submit");
        submit.setBounds(60, 350, 100, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma", Font.BOLD, 16));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(200, 350, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 16));
        cancel.addActionListener(this);
        add(cancel);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String empid = cempid.getText();
             String rason = trason.getText();
            String date =((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();
      
            String query ="INSERT INTO teacherleave(empid,date,duration,rason)"
                    + "VALUES('"+empid+"','"+date+"','"+duration+"','"+rason+"')";
             try{
                Conn co = new Conn();
                co.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null,"Leave Confirmod");
             setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
        
    }

    public static void main(String[] args) {
        new TeacherLeaveRequest();
    }
}
