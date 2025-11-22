package bank.managment.system;

import javax.swing.*;
import java.awt.*; //image Library
import java.awt.event.*;
import java.util.*;

public class Deposite extends JFrame implements ActionListener{
    
    JTextField amt;
    JButton deposit, back;
    String pinNumber;

    Deposite(String pinNumber){
        this.pinNumber = pinNumber;
        
        setLayout(null);
        
        //put image on frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATM.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atmImg = new JLabel(i3);
        atmImg.setBounds(0, 0, 900, 865);//(X, Y, width, Height)
        add(atmImg);
        
        //Label
        JLabel text = new JLabel("Enter the amount you want to deposit..");
        text.setBounds(170, 300, 400, 20);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        atmImg.add(text); //Here atmImg.add--> is used, bcz text shoul appears on image , not on frame.
        
        amt = new JTextField();
        amt.setFont(new Font("System", Font.BOLD, 22));
        amt.setBounds(170, 350, 320, 25);
        atmImg.add(amt);
        
        //Label
        deposit = new JButton("Deposit");
        deposit.setBounds(355, 508, 150, 30);  
        deposit.setFont(new Font("SanSerif", Font.BOLD, 16));
        deposit.addActionListener(this);
        atmImg.add(deposit); //Here atmImg.add--> is used, bcz text shoul appears on image , not on frame.
        
        //Label
        back = new JButton("Back");
        back.setBounds(355, 543, 150, 30);  
        back.setFont(new Font("SanSerif", Font.BOLD, 16));
        back.addActionListener(this);
        atmImg.add(back); //Here atmImg.add--> is used, bcz text shoul appears on image , not on frame.

        
        setSize(900, 900); //(X, Y)
        setLocation(300, 0); //(X, Y)
        setUndecorated(true); // this will remove borders of frame
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deposit){
            
            String amtNum = amt.getText();
            Date date = new Date();
            
            if(amtNum.equals("")){ //if amount is null
                JOptionPane.showMessageDialog(null, "Please enter amount you want deposit.");
            }else{
                try{
                    conn c = new conn();
                    String query = "insert into bank values('"+pinNumber+"', '"+date+"','Deposite' ,'"+amtNum+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. "+ amtNum +" Deposited Successfully"); //if query executed successfully
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }catch(Exception e){
                    System.out.println("Error:" + e);
                }
                
            }
            
        }else if(ae.getSource()== back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new Deposite("");
    }
}
