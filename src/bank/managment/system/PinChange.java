package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
    
    //Global
    String pinNumber;
    JButton back, change;
    JPasswordField pin,rePin;
    
    PinChange(String pinNumber){ 
        this.pinNumber = pinNumber; //global = local
        setLayout(null);
        
        ImageIcon atmImg = new ImageIcon(ClassLoader.getSystemResource("icons/ATM.jpg"));
        Image i2 = atmImg.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 900, 865);
        add(img);
        
        JLabel text = new JLabel("Change Your Pin..");
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 285, 500, 35);
        img.add(text);
        
        JLabel pinText = new JLabel("New Pin");
        pinText.setForeground(Color.white);
        pinText.setFont(new Font("System", Font.BOLD, 16));
        pinText.setBounds(165, 320, 180, 25);
        img.add(pinText);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330, 320, 180, 25);
        img.add(pin);
        
        rePin = new JPasswordField();
        rePin.setFont(new Font("Raleway", Font.BOLD, 25));
        rePin.setBounds(330, 360, 180, 25);
        img.add(rePin);
        
        JLabel rePinText = new JLabel("Re-Enter Pin");
        rePinText.setForeground(Color.white);
        rePinText.setFont(new Font("System", Font.BOLD, 16));
        rePinText.setBounds(165, 360, 180, 25);
        img.add(rePinText);
        
        
        change = new JButton("CHANGE");
        change.setBounds(355, 508, 150, 30);
        change.addActionListener(this);
        img.add(change);
        
        back = new JButton("BACK");
        back.setBounds(355, 545, 150, 30);
        back.addActionListener(this);
        img.add(back);
        
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == change){
           try{
                String newPin = pin.getText();
                String repin = rePin.getText();

                if(!newPin.equals(repin)){
                    JOptionPane.showMessageDialog(null, "Pin does not matched");
                    return; 
                } 
                
                if(newPin.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please Enter New Pin");
                    return;
                }
                
                if(repin.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please Re-Enter Pin");
                    return;
                }
                
                conn c = new conn();
                String query1_bank_DB = "update bank set pin = '"+repin+"' where pin = '"+pinNumber+"' ";
                String query2_login_DB = "update login set PinNum = '"+repin+"' where PinNum = '"+pinNumber+"' ";
                String query3_signupThree_DB = "update signupThree set PinNum = '"+repin+"' where PinNum = '"+pinNumber+"' ";
                
                c.s.executeUpdate(query1_bank_DB);
                c.s.executeUpdate(query2_login_DB);
                c.s.executeUpdate(query3_signupThree_DB);
                
                JOptionPane.showMessageDialog(null, "Pin Changed Set Successfully");
                
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);                
                
            }catch(Exception e){
                System.out.println("Error: " + e);
            }
        }else{
               setVisible(false);
               new Transactions(pinNumber).setVisible(true);
        }
        
    }
    
    public static void main(String args[]) {
        new PinChange("").setVisible(true);
    }
}
