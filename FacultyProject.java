
package universty.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FacultyProject extends JFrame implements ActionListener {

   FacultyProject() {
        setSize(1540, 850);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JMenuBar mb = new JMenuBar();
        //Subject Groub
        JMenu newInformation = new JMenu("Faculty ");
        newInformation.setForeground(Color.BLUE);
        mb.add(newInformation);

        
        JMenuItem facultylist = new JMenuItem("Faculty List");
        facultylist .setBackground(Color.WHITE);
        facultylist .addActionListener(this);
        newInformation.add(facultylist );
        //Result
        JMenu details = new JMenu("Add Result");
        details.setForeground(Color.RED);
        mb.add(details);

        JMenuItem mid = new JMenuItem("Mid Result Insert");
        mid.setBackground(Color.WHITE);
        mid.addActionListener(this);
        details.add(mid);

        JMenuItem finalresult = new JMenuItem("Final Result Insert");
       finalresult.setBackground(Color.WHITE);
        finalresult.addActionListener(this);
        details.add(finalresult);

        JMenuItem ctresult = new JMenuItem("CT Result Insert");
        ctresult .setBackground(Color.WHITE);
        ctresult .addActionListener(this);
        details.add(ctresult );

        //Leave Request
        JMenu leaveDetails = new JMenu("Apply Leave ");
        leaveDetails.setForeground(Color.GREEN);
        mb.add(leaveDetails);

        JMenuItem request = new JMenuItem("Request");
       request.setBackground(Color.WHITE);
        request .addActionListener(this);
       leaveDetails.add(request );
        
        //Student Leave Request
        JMenu slresuest = new JMenu("Student Apply Leave ");
        slresuest.setForeground(Color.GREEN);
        mb.add(slresuest);

        JMenuItem requestdetails = new JMenuItem("Request Details");
       requestdetails.setBackground(Color.WHITE);
       requestdetails .addActionListener(this);
       slresuest.add(requestdetails );
        //Utility
        JMenu utility = new JMenu("Update Details");
        utility.setBackground(Color.RED);
        mb.add(utility);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calc = new JMenuItem("Calcultor");
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this);
        utility.add(calc);

        //Exite
        JMenu exit = new JMenu("Exit");
        exit.setBackground(Color.RED);
        mb.add(exit);

        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);

        setJMenuBar(mb);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if (msg.equals("Exit")) {
            setVisible(false);
        } else if (msg.equals("Calcultor")) {

            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {

            }
        } else if (msg.equals("Notepad")) {

            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {

            }}
            else if (msg.equals("Request")) {
            new TeacherLeaveRequest();
  
        }else if (msg.equals("Request Details")) {
            new StudentLeaveDetails();
        }
    }
    public static void main(String[] args) {
        new FacultyProject();
    }

}

