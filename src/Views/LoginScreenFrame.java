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
public class LoginScreenFrame extends JFrame {
    private JLabel FNameLabel;
    private JLabel LNameLabel;
    private JTextField FNameField;
    private JTextField LNameField;
    private JButton loginButton;
    private JPanel buttonPanel;
    private JPanel loginPanel;
    private JPanel mainPanel;
    
    private TitledBorder title;
    
    
    public LoginScreenFrame(){
        setSize(500,500);
        
        //Labels and textfields
        FNameLabel = new JLabel("First Name");
        LNameLabel = new JLabel("Last Name");
        
        FNameField = new JTextField(15);
        FNameField.setText("");
        LNameField = new JTextField(15);
        LNameField.setText("");
        
        //button
        loginButton = new JButton("Login");
        
        
        
        //Login panel
        loginPanel = new JPanel();
        
        loginPanel.add(FNameLabel);
        loginPanel.add(FNameField);
        loginPanel.add(LNameLabel);
        loginPanel.add(LNameField);
        loginPanel.add(loginButton);
        loginPanel.add(Box.createRigidArea(new Dimension(0,37)));
        
        title = BorderFactory.createTitledBorder("Login");
        loginPanel.setBorder(title);
        title.setTitleColor(new Color(0, 0, 255));
    
        loginPanel.setPreferredSize(new Dimension(250, 115));
        
        
        
        //mainPanel
        mainPanel = new JPanel();
        mainPanel.add(Box.createRigidArea(new Dimension(10,400)));
        mainPanel.add(loginPanel);
        mainPanel.setBackground(new Color(0, 128, 128));
        
        add(mainPanel);
        
repaint();
    }
}   
  

