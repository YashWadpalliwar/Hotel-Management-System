package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class AddRooms  extends JFrame implements ActionListener{
    
    JButton add, cancel;
    JTextField tfroom, tfprice;
    JComboBox typecombo, availablecombo, cleancombo;
    
    AddRooms (){
                
        getContentPane().setBackground(Color.white);    
        setLayout(null);
        
        JLabel heading = new JLabel("Add Rooms");
        heading.setBounds(150, 20, 200, 20);
        heading.setFont(new Font("TAHOMA", Font.BOLD,18));
        add(heading); 
        
        JLabel lblroomno = new JLabel("Room Number");
        lblroomno.setBounds(60, 80, 120, 30);
        lblroomno.setFont(new Font("TAHOMA", Font.PLAIN,16));        
        add(lblroomno); 
        
        tfroom = new JTextField();
        tfroom.setBounds(200, 80, 150, 30);
        add(tfroom);
        
        JLabel lblavailable = new JLabel("Available");
        lblavailable.setBounds(60, 130, 120, 30);
        lblavailable.setFont(new Font("TAHOMA", Font.PLAIN,16));        
        add(lblavailable); 
        
        String availableOptions[] = {"Available", "Occupied"};
        availablecombo = new JComboBox(availableOptions);   
        availablecombo.setBounds(200, 130, 150, 30);
        availablecombo.setBackground(Color.white);
        add(availablecombo);
        
        JLabel lblclean = new JLabel("Cleaning Status");
        lblclean.setBounds(60, 180, 120, 30);
        lblclean.setFont(new Font("TAHOMA", Font.PLAIN,16));        
        add(lblclean); 
        
        String cleanOptions[] = {"Cleaned", "Dirty"};
        cleancombo = new JComboBox(cleanOptions);   
        cleancombo.setBounds(200, 180, 150, 30);
        cleancombo.setBackground(Color.white);
        add(cleancombo);
        
        JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(60, 230, 120, 30);
        lblprice.setFont(new Font("TAHOMA", Font.PLAIN,16));        
        add(lblprice); 
        
        tfprice = new JTextField();
        tfprice.setBounds(200, 230, 150, 30);
        add(tfprice);
        
         
        JLabel lbltype = new JLabel("Bed Type");
        lbltype.setBounds(60, 280, 120, 30);
        lbltype.setFont(new Font("TAHOMA", Font.PLAIN,16));        
        add(lbltype); 
        
        String typeOptions[] = {"Single Bed", "Double Bed"};
        typecombo = new JComboBox(typeOptions);   
        typecombo.setBounds(200, 280, 150, 30);
        typecombo.setBackground(Color.white);
        add(typecombo);
        
        add = new JButton("Add Room");
        add.setBounds(60, 350, 130, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE); 
        add.addActionListener(this);
        add(add);
       
        cancel = new JButton("Cancel");
        cancel.setBounds(220, 350, 130, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE); 
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));        
        JLabel image = new JLabel(il);
        image.setBounds(400, 30, 500, 300);
        add(image);
        
        setBounds(330, 200, 940, 470);         
        setVisible(true);         
    }
    
    public void actionPerformed(ActionEvent ae){
             if (ae.getSource() == add){
                String roomnumber = tfroom.getText();
                String availability = (String) availablecombo.getSelectedItem();
                String status = (String) cleancombo.getSelectedItem();
                String price = tfprice.getText();
                String type = (String) typecombo.getSelectedItem();
             
             try{
                 Conn conn = new Conn();
                 String str = "insert into room values('"+roomnumber+"', '"+availability+"', '"+status+"', '"+price+"', '"+type+"')";
                 conn.s.executeUpdate(str);
                 JOptionPane.showMessageDialog(null, "New Room added Successfully");
                 setVisible(false);
                 
             }catch (Exception e){
                 e.printStackTrace();
             }             
         }else {
             setVisible(false);
            
         }
         }               
    public static void main(String[] args){
        new AddRooms();
    }
}
