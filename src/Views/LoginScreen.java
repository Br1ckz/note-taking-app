/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Views;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Kaitlin
 */
public class LoginScreen extends JFrame {
    private JLabel FNameLabel = new JLabel("First Name");
    private JLabel LNameLabel = new JLabel("Last Name");
    private JTextField FNameField = new JTextField(15);
    private JTextField LNameField = new JTextField(15);
    private JButton loginButton = new JButton("Login");
    private JPanel loginPanel = new JPanel();
    private JPanel mainPanel = new JPanel();
    private TitledBorder title = BorderFactory.createTitledBorder("Login");
    
    
    public LoginScreen(){
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Note Taking Login");
        setVisible(true);
        
        //textfield
        FNameField.setText("");
        LNameField.setText("");
        

        //Login panel
        loginPanel.add(FNameLabel);
        loginPanel.add(FNameField);
        loginPanel.add(LNameLabel);
        loginPanel.add(LNameField);
        loginPanel.add(loginButton);
        loginPanel.add(Box.createRigidArea(new Dimension(0,37)));
     
        loginPanel.setBorder(title);
        title.setTitleColor(new Color(0, 0, 255));
    
        loginPanel.setPreferredSize(new Dimension(250, 115));
        
        
        //mainPanel
        mainPanel.add(Box.createRigidArea(new Dimension(10,400)));
        mainPanel.add(loginPanel);
        mainPanel.setBackground(new Color(0, 128, 128));
        
        add(mainPanel);
        
repaint();
    }
}   
  

