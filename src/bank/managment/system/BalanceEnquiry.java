package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    //global
    String pinNumber;
    JButton back;
    
    BalanceEnquiry(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATM.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 865);
        add(image);      
        
        back = new JButton("BACK");
        back.setBounds(355, 543, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        //here we added this code bcz, we want to show balance once frame opens
        conn c = new conn();
        int totalBal = 0;
        try{
            // checking balance from bank database
            ResultSet checkBalQuery = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
            while(checkBalQuery.next()){ //.next()--> is used to loop
                if(checkBalQuery.getString("trans_type").equals("Deposite")){
                    totalBal += Integer.parseInt(checkBalQuery.getString("amount"));  //if deposit--> add all amount                      
                }else{
                    totalBal -= Integer.parseInt(checkBalQuery.getString("amount"));  //if withdrwl--> subtract amount  
                }        
            }
        }catch(Exception e){
            System.out.println("Error: "+ e);
        }
        
        JLabel currBal = new JLabel("Your current account balance is Rs. " + totalBal);
        currBal.setForeground(Color.white);
        currBal.setBounds(200, 300, 400, 30);
        image.add(currBal);
        
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    //overriding function
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }
    

    public static void main(String args[]) {
        new BalanceEnquiry("");
    }
}
