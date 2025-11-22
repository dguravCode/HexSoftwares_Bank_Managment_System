package bank.managment.system;

import javax.swing.*; //library to make visual frames
import java.awt.*; //library for image class
import java.awt.event.*; //ActionListener library
import java.sql.*; //Library for to run Sql query

public class Login extends JFrame implements ActionListener{ //ActionListener (interface)--> for button action
    
    JButton login, clear, signUp; //defined globally
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    //creating constructor of class, so that when object is call for this class then frame should appears.   
    Login(){
        setTitle("Automated Teller Machine"); //title of page
        
        setLayout(null);//by-default image location is center on frame
        
        //putting bank-icon on the frame
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/bank2.png")); //set image path
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT); //set image dimantion
        ImageIcon i3 = new ImageIcon(i2); 
        JLabel label = new JLabel (i3); //to put/set image on frame
        label.setBounds(70,10, 100, 100); // set location of image (X, Y, width of img, hight of image)
        add(label); 
        
        //showing headline on frame
        JLabel text = new JLabel("Welcome to the Banking System");
        text.setFont(new Font("SanSarif", Font.BOLD, 25)); //set text-font style
        text.setBounds(228, 40, 400, 40); //set location of text
        add(text);
        
        //showing card text on frame
        JLabel cardNo = new JLabel("Card No:");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 24)); //set text-font style
        cardNo.setBounds(120, 150, 150, 30); //set location of text
        add(cardNo);
        
        //input card-text field
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
        
        //showing pin text on frame
        JLabel pinNo = new JLabel("PIN:");
        pinNo.setFont(new Font("Raleway", Font.BOLD, 24)); //set font style
        pinNo.setBounds(120, 220, 250, 30); //set location of text
        add(pinNo);
        
        //input pin-text field
        pinTextField = new JPasswordField(); // use password field
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14)); //set font style
        add(pinTextField);
        
        //creating signIn-button
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        //creating clear-button
        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
        
        //creating signUp-button
        signUp = new JButton("SIGN UP");
        signUp.setBounds(300, 350, 230, 30);
        signUp.setBackground(Color.black);
        signUp.setForeground(Color.white);
        signUp.addActionListener(this);
        add(signUp);
        
        //changing back-ground of frame
        getContentPane().setBackground(Color.white);
        
        // creating new frame
        setSize(800, 480); //dimension of frame (X,Y)
        setVisible(true); //by-default it is 'false'
        setLocation(350, 200); //(X, Y) //specifying location to open frame
        
    }
    
    public void actionPerformed(ActionEvent ae){//ActionEvent is class // here after clicking button what action should perform
        
        if(ae.getSource() == clear){
            cardTextField.setText(""); // setting empty value in textField
            pinTextField.setText("");
        }else if(ae.getSource() == login){
            conn c = new conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText(); //strike bcz of JPasswordField
            
            //this query to get/fetch data from database
            String query = "select * from login where CardNum = '"+cardNumber+"' and PinNum = '"+pinNumber+"'";
            try{
               ResultSet res = c.s.executeQuery(query); // we use this for DDL command // this return some data // ResultSet --> is data-type
               if(res.next()){ //if result stored
                   setVisible(false);// login frame close
                   new Transactions(pinNumber).setVisible(true); // Transaction frame open
               }else{
                   JOptionPane.showMessageDialog(null, "Incorrect Card or Pin Number");
               }
                
            }catch(Exception e){
                System.out.println(e);
            }
            
        }else if(ae.getSource() == signUp){
            setVisible(false); //onClick signup it will close
            new SignupOne().setVisible(true);// SignupOne-->constructor of SignupOne class. //Now after clicked--> application form visible.            
        }
        
    }
    
    public static void main(String args[]) {
       new Login(); //class object called
    }
}


