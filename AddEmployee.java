package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class AddEmployee extends JFrame implements ActionListener{
    
    JTextField tfname, tfemail, tfage, tfphone, tfsalary, tfaadhar;
    JRadioButton rbmale, rbfemale;
    JButton submit;
    JComboBox cbjob;
    
    AddEmployee() {
        setLayout(null);
         
        JLabel lblname = new JLabel("Full Name");
        lblname.setBounds(60, 30, 120, 30);
        lblname.setFont(new Font("TAHOMA", Font.BOLD,20));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 30, 150, 30);
        add(tfname);
        
        JLabel lblage = new JLabel("AGE");
        lblage.setBounds(60, 80, 120, 30);
        lblage.setFont(new Font("TAHOMA", Font.BOLD,20));
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(200, 80, 150, 30);
        add(tfage);
        
        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(60, 130, 120, 30);
        lblgender.setFont(new Font("TAHOMA", Font.BOLD,17));
        add(lblgender);
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200, 130, 70, 30);
        rbmale.setFont(new Font("TAHOMA", Font.BOLD,14));
        rbmale.setBackground(Color.white);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280, 130, 80, 30);
        rbfemale.setFont(new Font("TAHOMA", Font.BOLD,14));
        rbfemale.setBackground(Color.white);
        add(rbfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);        
        
        JLabel lbljob = new JLabel("JOB");
        lbljob.setBounds(60, 180, 120, 30);
        lbljob.setFont(new Font("TAHOMA", Font.BOLD,20));
        add(lbljob);
        
        String str[] = {"Front Dest Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Chefs", "Waiter/Waitress", "Manager", "Accountant"};                
        cbjob = new JComboBox(str);   
        cbjob.setBounds(200, 180, 150, 30);
        cbjob.setBackground(Color.white);
        add(cbjob);
        
        JLabel lblsalary = new JLabel("SALARY");
        lblsalary.setBounds(60, 230, 120, 30);
        lblsalary.setFont(new Font("TAHOMA", Font.BOLD,20));
        add(lblsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(200, 230, 150, 30);
        add(tfsalary);
        
        JLabel lblphone = new JLabel("PHONE");
        lblphone.setBounds(60, 280, 120, 30);
        lblphone.setFont(new Font("TAHOMA", Font.BOLD,20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(200, 280, 150, 30);
        add(tfphone);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(60, 330, 120, 30);
        lblemail.setFont(new Font("TAHOMA", Font.BOLD,20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 330, 150, 30);
        add(tfemail);
        
        JLabel lblaadhar = new JLabel("Aadhar NO.");
        lblaadhar.setBounds(60, 380, 120, 30);
        lblaadhar.setFont(new Font("TAHOMA", Font.BOLD,17));
        add(lblaadhar);
                
        tfaadhar = new JTextField();
        tfaadhar.setBounds(200, 380, 150, 30);
        add(tfaadhar);
        
        submit = new JButton("SUBMIT");
        submit.setBounds(200, 430, 150, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE); 
        submit.addActionListener(this);
        add(submit);
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = il.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 60, 450, 370);
        add(image);
        
        getContentPane().setBackground(Color.white);              
        setBounds(350, 200, 850, 540);         
        setVisible(true);        
    }
     public void actionPerformed(ActionEvent ae){
             String name = tfname.getText();
             String age = tfage.getText();
             String salary = tfsalary.getText();
             String phone = tfphone.getText();
             String email = tfemail.getText();             
             String aadhar = tfaadhar.getText();             
             
             String gender = null;
             
             if (rbmale.isSelected()){
                 gender = "Male";
             } else if (rbfemale.isSelected()) {
                 gender = "Female";
             }
             
             String job = (String) cbjob.getSelectedItem();
             
             try{
                 Conn conn = new Conn();
                 String query = "insert into employee values('"+name+"', '"+age+"', '"+gender+"', '"+job+"', '"+salary+"', '"+phone+"', '"+email+"', '"+aadhar+"')";
                 conn.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null, "Employee added Successfully");
                 setVisible(false);                
             }catch (Exception e){
                 e.printStackTrace();
             }             
         }                
    public static void main(String[] args){
        new  AddEmployee();
    }
}
