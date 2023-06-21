package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class AddDriver  extends JFrame implements ActionListener{
    
    JButton add, cancel;
    JTextField tfname, tfage, tfcompany, tfmodel, tflocation;
    JComboBox typecombo, availablecombo, cleancombo, agecombo, gendercombo;
    
    AddDriver (){
                
        getContentPane().setBackground(Color.white);    
        setLayout(null);
        
        JLabel heading = new JLabel("Add Drivers");
        heading.setBounds(150, 10, 200, 20);
        heading.setFont(new Font("TAHOMA", Font.BOLD,18));
        add(heading); 
        
        JLabel lblroomno = new JLabel("Name");
        lblroomno.setBounds(60, 70, 120, 30);
        lblroomno.setFont(new Font("TAHOMA", Font.PLAIN,16));        
        add(lblroomno); 
        
        tfname = new JTextField();
        tfname.setBounds(200, 80, 150, 30);
        add(tfname);
        
        JLabel lblage = new JLabel("Age");
        lblage.setBounds(60, 110, 120, 30);
        lblage.setFont(new Font("TAHOMA", Font.PLAIN,16));        
        add(lblage); 
        
        tfage = new JTextField();
        tfage.setBounds(200, 110, 150, 30);
        add(tfage);
        
        JLabel lblclean = new JLabel("Gender");
        lblclean.setBounds(60, 150, 120, 30);
        lblclean.setFont(new Font("TAHOMA", Font.PLAIN,16));        
        add(lblclean); 
        
        String cleanOptions[] = {"Male", "Female"};
        gendercombo = new JComboBox(cleanOptions);   
        gendercombo.setBounds(200, 150, 150, 30);
        gendercombo.setBackground(Color.white);
        add(gendercombo);
        
        JLabel lblprice = new JLabel("Car Company");
        lblprice.setBounds(60, 190, 120, 30);
        lblprice.setFont(new Font("TAHOMA", Font.PLAIN,16));        
        add(lblprice); 
        
        tfcompany = new JTextField();
        tfcompany.setBounds(200, 190, 150, 30);
        add(tfcompany);
        
         
        JLabel lbltype = new JLabel("Car Model");
        lbltype.setBounds(60, 230, 120, 30);
        lbltype.setFont(new Font("TAHOMA", Font.PLAIN,16));        
        add(lbltype); 
        
        tfmodel = new JTextField();
        tfmodel.setBounds(200, 230, 150, 30);
        add(tfmodel);
        
        JLabel lblavailable = new JLabel("Available");
        lblavailable.setBounds(60, 270, 120, 30);
        lblavailable.setFont(new Font("TAHOMA", Font.PLAIN,16));        
        add(lblavailable); 
        
        String driverOptions[] = {"Available", "Busy"};
        availablecombo = new JComboBox(driverOptions);   
        availablecombo.setBounds(200, 270, 150, 30);
        availablecombo.setBackground(Color.white);
        add(availablecombo);
        
        JLabel lbllocation = new JLabel("Location");
        lbllocation.setBounds(60, 310, 120, 30);
        lbllocation.setFont(new Font("TAHOMA", Font.PLAIN,16));        
        add(lbllocation); 
        
        tflocation = new JTextField();
        tflocation.setBounds(200, 310, 150, 30);
        add(tflocation);
        
        add = new JButton("Add Driver");
        add.setBounds(60, 370, 130, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE); 
        add.addActionListener(this);
        add(add);
       
        cancel = new JButton("Cancel");
        cancel.setBounds(220, 370, 130, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE); 
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));   
        Image i2 = il.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 500, 300);
        add(image);
        
        setBounds(300, 200, 980, 470);         
        setVisible(true);         
    }
    
    public void actionPerformed(ActionEvent ae){
             if (ae.getSource() == add){
                String name = tfname.getText();
                String age =  tfage.getText();
                String gender = (String) gendercombo.getSelectedItem();
                String company = tfcompany.getText();
                String brand = tfmodel.getText();
                String available = (String) availablecombo.getSelectedItem();;
                String location  = tflocation.getText();
             try{
                 Conn conn = new Conn();
                 String str = "insert into driver values('"+name+"', '"+age+"', '"+gender+"', '"+company+"', '"+brand+"', '"+available+"', '"+location+"')";
                 conn.s.executeUpdate(str);
                 JOptionPane.showMessageDialog(null, "New Driver added Successfully");
                 setVisible(false);
                 
             }catch (Exception e){
                 e.printStackTrace();
             }             
         }else {
             setVisible(false);
            
         }
         }               
    public static void main(String[] args){
        new AddDriver();
    }
}
