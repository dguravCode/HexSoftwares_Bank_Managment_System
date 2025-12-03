package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame  {
    //global
    
    MiniStatement(String pinNumber){
        setTitle("Transaction Receipt");
        setLayout(null);
        
        JLabel mini = new JLabel();
        add(mini);
        
        JLabel bankName = new JLabel("Indian Bank");
        bankName.setBounds(150, 20, 100, 20);
        add(bankName);
        
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);
        
        try{
            conn c = new conn();
            ResultSet checkBalQuery = c.s.executeQuery("select * from login where pinNum = '"+pinNumber+"'");
            while(checkBalQuery.next()){
                card.setText("Card Number: " + checkBalQuery.getString("CardNum").substring(0,4)+ "********" + checkBalQuery.getString("CardNum").substring(12, 16));
            }
        }catch(Exception e){
            System.out.println("Erro: " + e);
        }
        
        try{
            conn c = new conn();
            int bal = 0;
            ResultSet res = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
            
            StringBuilder statement = new StringBuilder("<html>");
            while(res.next()) {
                statement.append(res.getString("date"))
                         .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                         .append(res.getString("trans_type"))
                         .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                         .append(res.getString("amount"))
                         .append("<br>");
                if(res.getString("trans_type").equals("Deposite")){
                    bal += Integer.parseInt(res.getString("amount"));  //if deposit--> add all amount                      
                }else{
                    bal -= Integer.parseInt(res.getString("amount"));  //if withdrwl--> subtract amount  
                }
            }
            statement.append("</html>");
            mini.setText(statement.toString());             
            balance.setText("your current account balance is Rs. " + bal);
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        
        mini.setBounds(20, 120, 400, 200);

        
        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.white);
//        setUndecorated(true);
        setVisible(true);
        
    }
    
    public static void main(String args[]) {
        new MiniStatement(""); //object 
    }
}
