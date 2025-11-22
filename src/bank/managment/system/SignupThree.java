package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    
    String formNo;
    JRadioButton savingAcc, FD, curr, reCurr;
    JCheckBox cbox1, cbox2, cbox3, cbox4, cbox5, cbox6, cbox7;
    JButton submit, cancel;
    
    //creating constructor of class, so that when object is call for this class then frame should appears.
    SignupThree(String formNo){
        this.formNo = formNo;
        setLayout(null);
        
        //Label
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);
        
        //Label
        JLabel accType = new JLabel("Account Type");
        accType.setFont(new Font("Raleway", Font.BOLD, 20));
        accType.setBounds(100, 100, 200, 30);
        add(accType);
        
        //Radio Button
        savingAcc = new JRadioButton("Saving Account");
        savingAcc.setFont(new Font("Raleway", Font.BOLD,16));
        savingAcc.setBackground(Color.white);
        savingAcc.setBounds(100, 180, 150, 20);
        add(savingAcc);
        
        //Radio Button
        FD = new JRadioButton("FD Account");
        FD.setFont(new Font("Raleway", Font.BOLD,16));
        FD.setBackground(Color.white);
        FD.setBounds(350, 180, 150, 20);
        add(FD);
        
        //Radio Button
        curr = new JRadioButton("Current Account");
        curr.setFont(new Font("Raleway", Font.BOLD,16));
        curr.setBackground(Color.white);
        curr.setBounds(100, 220, 150, 20);
        add(curr);
        
        //Radio Button
        reCurr = new JRadioButton("Recurring Account");
        reCurr.setFont(new Font("Raleway", Font.BOLD,16));
        reCurr.setBackground(Color.white);
        reCurr.setBounds(350, 220, 180, 20);
        add(reCurr);
        
        //Grouping
        ButtonGroup grpAcc = new ButtonGroup();
        grpAcc.add(savingAcc);
        grpAcc.add(FD);
        grpAcc.add(curr);
        grpAcc.add(reCurr);
        
        //Label
        JLabel cardDetail = new JLabel("Your 16 Digit Card Number");
        cardDetail.setFont(new Font("Raleway", Font.BOLD, 10));
        cardDetail.setBounds(100, 320, 350, 45);
        add(cardDetail);
        
        //Label
        JLabel cardNo = new JLabel("Card Number:");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 20));
        cardNo.setBounds(100, 300, 200, 30);
        add(cardNo);
        
        //Label
        JLabel num = new JLabel("XXXX-XXXX-XXXX-5205");
        num.setFont(new Font("Raleway", Font.BOLD, 20));
        num.setBounds(330, 300, 300, 30);
        add(num);
        
        //Label
        JLabel pinDetail = new JLabel("Your 4 Digit Pin Number");
        pinDetail.setFont(new Font("Raleway", Font.BOLD, 10));
        pinDetail.setBounds(100, 390, 350, 45);
        add(pinDetail);
        
        //Label
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 370, 200, 30);
        add(pin);
        
        //Label
        JLabel pnum = new JLabel("XXXX");
        pnum.setFont(new Font("Raleway", Font.BOLD, 20));
        pnum.setBounds(330, 370, 300, 30);
        add(pnum);
        
        //Label
        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 20));
        services.setBounds(100, 450, 200, 30);
        add(services);
        
        //CheckBox-ATM CARD
        cbox1 = new JCheckBox("ATM CARD");
        cbox1.setBackground(Color.white);
        cbox1.setFont(new Font("Raleway", Font.BOLD, 16));
        cbox1.setBounds(100, 500, 180, 30);
        add(cbox1);
        
        //CheckBox-
        cbox2 = new JCheckBox("Internet Banking");
        cbox2.setBackground(Color.white);
        cbox2.setFont(new Font("Raleway", Font.BOLD, 16));
        cbox2.setBounds(350, 500, 180, 30);
        add(cbox2);
        
        //CheckBox-
        cbox3 = new JCheckBox("Mobile Banking");
        cbox3.setBackground(Color.white);
        cbox3.setFont(new Font("Raleway", Font.BOLD, 16));
        cbox3.setBounds(100, 550, 180, 30);
        add(cbox3);
        
        //CheckBox-
        cbox4 = new JCheckBox("EMAIL & SMS Aleart");
        cbox4.setBackground(Color.white);
        cbox4.setFont(new Font("Raleway", Font.BOLD, 16));
        cbox4.setBounds(350, 550, 180, 30);
        add(cbox4);
        
        //CheckBox-
        cbox5 = new JCheckBox("Cheque Book");
        cbox5.setBackground(Color.white);
        cbox5.setFont(new Font("Raleway", Font.BOLD, 16));
        cbox5.setBounds(100, 600, 180, 30);
        add(cbox5);
        
        //CheckBox-
        cbox6 = new JCheckBox("E-Statement");
        cbox6.setBackground(Color.white);
        cbox6.setFont(new Font("Raleway", Font.BOLD, 16));
        cbox6.setBounds(350, 600, 180, 30);
        add(cbox6);
        
        //CheckBox-
        cbox7 = new JCheckBox("I here by declares that above details are correct.");
        cbox7.setBackground(Color.white);
        cbox7.setFont(new Font("Raleway", Font.BOLD, 13));
        cbox7.setBounds(100, 680, 600, 30);
        add(cbox7);
        
        //Button
        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway", Font.BOLD,14));
        submit.setBounds(250, 720, 100, 30);
        submit.addActionListener(this); //Action Listener
        add(submit);
        
        //Button
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway", Font.BOLD,14));
        cancel.setBounds(420, 720, 100, 30);
        cancel.addActionListener(this); //Action Listener        
        add(cancel);
        
        //Change Frame Color
        getContentPane().setBackground(Color.white);
        
        //Frame
        setSize(850, 820);//lenght, bredth
        setLocation(350, 0);
        setVisible(true);        
        
    }
    
    //Overriding function
    public void actionPerformed(ActionEvent ae){
        String formNum = this.formNo;
        if(ae.getSource() == submit){
            
            String accountType = null;
            if(savingAcc.isSelected()){
                accountType = "Saving Account";
            }else if(FD.isSelected()){
                accountType = "FD Account";
            }else if(curr.isSelected()){
                accountType = "Current Account";
            }else if(reCurr.isSelected()){
                accountType = "Reccuring Deposite Account";
            }
         
         //generating random number
         Random ran = new Random();
         String cardNum = "44215521" + String.format("%08d", ran.nextInt(100000000));

         String pinNum = String.format("%04d", ran.nextInt(9000) + 1000);
         
         //Fetching CheckBox value 
        StringBuilder sb = new StringBuilder();
        if (cbox1.isSelected()) sb.append("ATM Card, ");
        if (cbox2.isSelected()) sb.append("Internet Banking, ");
        if (cbox3.isSelected()) sb.append("Mobile Banking, ");
        if (cbox4.isSelected()) sb.append("Email & SMS Alert, ");
        if (cbox5.isSelected()) sb.append("Cheque Book, ");
        if (cbox6.isSelected()) sb.append("E-Statement, ");
        String services = sb.length() > 0 ? sb.substring(0, sb.length() - 2) : ""; // remove trailing ", "

        // Database Connection
        try{
            if(accountType.equals("")){
                JOptionPane.showMessageDialog(null, "Account Type is Require.");//to show message on frame
            }else{
                conn c = new conn();
                String query1 = "insert into signupThree values('"+formNum+"', '"+accountType+"', '"+cardNum+"', '"+pinNum+"', '"+services+"')";
                
                String query2 = "insert into login values('"+formNum+"', '"+cardNum+"', '"+pinNum+"')";

                c.s.executeUpdate(query1); // this will update query1 on database
                c.s.executeUpdate(query2); // this will update query2 on database
                
                JOptionPane.showMessageDialog(null, "Card Number " + cardNum + "\n" + "Pin Number " + pinNum + "\n"); //to show message on frame
                
                setVisible(false);
                new Deposite(pinNum).setVisible(false);
            }
            
            
        }catch(Exception e){
            System.out.println("Error: " + e);
        }

         
        }else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        
        new SignupThree(""); //class object called
    }
}
