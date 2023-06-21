package hotel.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
    
    JTextField username;
    JPasswordField password;
    JButton Login, cancel;
    
    Login () {        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel user = new JLabel("Username");
        user.setBounds(40, 20, 100, 30);
        add(user);
        
        username = new JTextField();
        username.setBounds(150, 20, 150, 30);
        add(username);
        
        JLabel pass = new JLabel("Password");
        pass.setBounds(40, 70, 100, 30);
        add(pass);
        
        password = new JPasswordField();
        password.setBounds(150, 70, 150, 30);
        add(password);
        
        Login = new JButton("Login");
        Login.setBounds(40, 150, 120, 30);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE); 
        Login.addActionListener(this);
        add(Login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 150, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE); 
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = il.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
        
        setBounds(500, 200, 600, 300);        
        setVisible(true);
        
    }
    
     public void actionPerformed(ActionEvent ae){
         if (ae.getSource() == Login){
             String user = username.getText();
             String pass = password.getText();
             
             try{                           
              Conn c = new Conn();
              String query = "select * from login where username = '"+ user +"' and password = '"+ pass +"'";
              
              ResultSet rs = c.s.executeQuery(query);
              if (rs.next()){
                  setVisible(false);
                  new Dashboard();
              }else {
                  JOptionPane.showMessageDialog(null, "Invalid username or password");
                  setVisible(false);
              }
              
              
          }catch (Exception e){
              e.printStackTrace();
          }
             
         }else if (ae.getSource() == cancel){
             setVisible(false);
         }                   
        }
              
    public static void main(String[] args){
        new Login();
    }
}
