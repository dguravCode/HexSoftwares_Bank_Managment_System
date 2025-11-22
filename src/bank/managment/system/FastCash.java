
package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    //Global Declaration
    JButton deposite, fastCash, withrawl, receipt, pinCh, exit, bal;
    String pinNumber;
    
    //creating constructor of class, so that when object is call for this class then frame should appears.()
    FastCash(String pinNumber){
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
        JLabel text = new JLabel("Please Select Withdrawl Amount...");
        text.setBounds(220, 290, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("SanSerif", Font.BOLD, 16));
        atmImg.add(text); //Here atmImg.add--> is used, bcz text shoul appears on image , not on frame.
        
        //Button
        deposite = new JButton ("Rs. 100");
        deposite.setBounds(170, 432, 150, 30);
        deposite.addActionListener(this);
        atmImg.add(deposite);
        
        //Button
        fastCash = new JButton ("Rs. 500");
        fastCash.setBounds(170, 470, 150, 30);
        fastCash.addActionListener(this);
        atmImg.add(fastCash);
        
        //Button
        withrawl = new JButton ("Rs. 1000");
        withrawl.setBounds(355, 432, 150, 30);
        withrawl.addActionListener(this);
        atmImg.add(withrawl);
        
        //Button
        receipt = new JButton ("Rs. 5000");
        receipt.setBounds(355, 470, 150, 30);
        receipt.addActionListener(this);
        atmImg.add(receipt);
        
        //Button
        pinCh = new JButton ("Rs. 10000");
        pinCh.setBounds(170, 508, 150, 30);
        pinCh.addActionListener(this);
        atmImg.add(pinCh);
        
        //Button
        exit = new JButton ("BACK");
        exit.setBounds(355, 545, 150, 30);
        exit.addActionListener(this);
        atmImg.add(exit);
        
        //Button
        bal = new JButton ("Balance Enquiry");
        bal.setBounds(355, 508, 150, 30);
        bal.addActionListener(this);
        atmImg.add(bal);
        
       
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true); // this will remove borders of frame
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }else{
            String wdrAmt = ((JButton)ae.getSource()).getText().substring(4); //getting text from button and remove starting 4 char, using sub-string
            conn c = new conn();
            try{
                // checking balance from bank database
                ResultSet checkBalQuery = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
                int totalBal = 0;
                while(checkBalQuery.next()){ //.next()--> is used to loop
                    if(checkBalQuery.getString("trans_type").equals("Deposite")){
                        totalBal += Integer.parseInt(checkBalQuery.getString("amount"));  //if deposit--> add all amount                      
                    }else{
                        totalBal -= Integer.parseInt(checkBalQuery.getString("amount"));  //if withdrwl--> subtract amount  
                    }
                }
                
                if(ae.getSource() != exit && totalBal < Integer.parseInt(wdrAmt)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'withdrawl', '"+wdrAmt+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs. " + wdrAmt + " Debited Successfully!");
                
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }catch(Exception e){
                System.out.println("Error: " + e);
            }
            
        }
        
    }

    public static void main(String args[]) {
        new FastCash(""); //class object called
        
    }
}
