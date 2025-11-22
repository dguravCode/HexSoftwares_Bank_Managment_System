
package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
    //Global Declaration
    JButton deposite, fastCash, withrawl, receipt, pinCh, exit, bal;
    String pinNumber;
    
    //creating constructor of class, so that when object is call for this class then frame should appears.()
    Transactions(String pinNumber){
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
        JLabel text = new JLabel("Please Select Your Transaction...");
        text.setBounds(220, 290, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("SanSerif", Font.BOLD, 16));
        atmImg.add(text); //Here atmImg.add--> is used, bcz text shoul appears on image , not on frame.
        
        //Button
        deposite = new JButton ("Deposite");
        deposite.setBounds(170, 432, 150, 30);
        deposite.addActionListener(this);
        atmImg.add(deposite);
        
        //Button
        fastCash = new JButton ("Fast Cash");
        fastCash.setBounds(170, 470, 150, 30);
        fastCash.addActionListener(this);
        atmImg.add(fastCash);
        
        //Button
        withrawl = new JButton ("Cash Withdrawl");
        withrawl.setBounds(355, 432, 150, 30);
        withrawl.addActionListener(this);
        atmImg.add(withrawl);
        
        //Button
        receipt = new JButton ("Transaction Receipt");
        receipt.setBounds(355, 470, 150, 30);
        receipt.addActionListener(this);
        atmImg.add(receipt);
        
        //Button
        pinCh = new JButton ("Pin Change");
        pinCh.setBounds(170, 508, 150, 30);
        pinCh.addActionListener(this);
        atmImg.add(pinCh);
        
        //Button
        exit = new JButton ("Exit");
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
            System.exit(0); // to close frame directly on click 'exit' button
        }else if(ae.getSource() == deposite){
            setVisible(false); //transaction form close
            new Deposite(pinNumber).setVisible(true); //deposite frame open
        }else if(ae.getSource() == withrawl){
            setVisible(false); //transaction form close
            new withdrawl(pinNumber).setVisible(true); //withdrawl frame open
        }else if(ae.getSource() == fastCash){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }else if(ae.getSource() == pinCh){
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }else if(ae.getSource() == bal){
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        }else if(ae.getSource() == bal){
            setVisible(false);
            new MiniStatement(pinNumber).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Transactions(""); //class object called
        
    }
}
