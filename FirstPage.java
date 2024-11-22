package universty.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.awt.event.ActionListener;

public class FirstPage extends JFrame implements ActionListener {

    FirstPage() {
        JFrame frame = new JFrame("Chat Application - Start Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 700);
        frame.setLayout(new BorderLayout());

        JLabel label = new JLabel("Please select your role to proceed:", JLabel.LEFT);
        label.setFont(new Font("Arial", Font.PLAIN, 18));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10));

        JButton adminButton = new JButton("Admin");
        adminButton.addActionListener(this);
        buttonPanel.add(adminButton);
        JButton studentButton = new JButton("Student");
        studentButton.addActionListener(this);
        buttonPanel.add(studentButton);
        JButton facultyButton = new JButton("Faculty");
        facultyButton.addActionListener(this);
        buttonPanel.add(facultyButton);

        frame.add(label, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.setVisible(true);
          
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = e.getActionCommand();
        if (msg.equals("Admin")) {
            setVisible(false);
            new Login();
            
        }else if (msg.equals("Student")) {
            setVisible(false);
            new Login1();
            
        }else if (msg.equals("Faculty")) {
            setVisible(false);
            new Login2();
            
        }
        
    }

    public static void main(String[] args) {
        new FirstPage();
    }

}
