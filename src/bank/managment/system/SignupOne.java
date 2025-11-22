package bank.managment.system;


import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    
    //Declaring Global Variables
    long random;
    JTextField nameTextField, fnameTextField, emailTextField, addTextField, cityTextField, stateTextField, pinTextField;
    JButton next;
    JRadioButton male, female, married, unmarried, other;
    JDateChooser dateChooser;
    
    //creating constructor of class, so that when object is call for this class then frame should appears.   
       SignupOne(){
           setLayout(null);
           
           //Random No. generating
           Random ran = new Random();
           random = Math.abs((ran.nextLong() % 9000L) + 1000L);
           
           //showing headline on frame
           JLabel formNo = new JLabel("APPLICATION FORM NO: " + random);
           formNo.setFont(new Font("SanSarif", Font.BOLD, 38));
           formNo.setBounds(140, 20, 600, 40);
           add(formNo);
           
           //showing sub-headline on frame
           JLabel personalDetails = new JLabel("Page 1: Personal Details");
           personalDetails.setFont(new Font("SanSarif", Font.BOLD, 22));
           personalDetails.setBounds(290, 80, 300, 30);
           add(personalDetails);
           
           //showing label on frame
           JLabel name = new JLabel("Name:");
           name.setFont(new Font("SanSarif", Font.BOLD, 22));
           name.setBounds(100, 140, 100, 30);
           add(name);
           
           //showing textField on frame
           nameTextField = new JTextField();
           nameTextField.setFont(new Font("SanSerif", Font.BOLD, 15));
           nameTextField.setBounds(300, 140, 400, 30);
           add(nameTextField);
           
            //showing label on frame
           JLabel fName = new JLabel("Father's Name:");
           fName.setFont(new Font("SanSarif", Font.BOLD, 22));
           fName.setBounds(100, 190, 190, 30);
           add(fName);
           
           //showing textField on frame
           fnameTextField = new JTextField();
           fnameTextField.setFont(new Font("SanSerif", Font.BOLD, 15));
           fnameTextField.setBounds(300, 190, 400, 30);
           add(fnameTextField);
           
           //showing label on frame
           JLabel dob = new JLabel("Date of Birth:");
           dob.setFont(new Font("SanSarif", Font.BOLD, 22));
           dob.setBounds(100, 240, 200, 30);
           add(dob);
           
           //Calender field
            dateChooser = new JDateChooser();
            dateChooser.setBounds(300, 240, 400, 30);
            add(dateChooser);
           
           //showing label on frame
           JLabel gender = new JLabel("Gender:");
           gender.setFont(new Font("SanSarif", Font.BOLD, 22));
           gender.setBounds(100, 290, 200, 30);
           add(gender);
           
           // showing radio button
           male = new JRadioButton("Male");
           male.setBounds(300, 290, 60, 30);
           male.setBackground(Color.white);
           add(male);
           
            // showing radio button
           female = new JRadioButton("Female");
           female.setBounds(450, 290, 70, 30);
           female.setBackground(Color.white);
           add(female);
           
           ButtonGroup gendergroup = new ButtonGroup();
           gendergroup.add(male);
           gendergroup.add(female);
           
           //showing label on frame
           JLabel email = new JLabel("Email:");
           email.setFont(new Font("SanSarif", Font.BOLD, 22));
           email.setBounds(100, 340, 200, 30);
           add(email);
           
           //showing textField on frame
           emailTextField = new JTextField();
           emailTextField.setFont(new Font("SanSerif", Font.BOLD, 15));
           emailTextField.setBounds(300, 340, 400, 30);
           add(emailTextField);
           
           //showing label on frame
           JLabel marital = new JLabel("Marital Status:");
           marital.setFont(new Font("SanSarif", Font.BOLD, 22));
           marital.setBounds(100, 390, 200, 30);
           add(marital);
           
           // showing radio button
           married = new JRadioButton("Married");
           married.setBounds(300, 390, 90, 30);
           married.setBackground(Color.white);
           add(married);
           
            // showing radio button
           unmarried = new JRadioButton("Un-Married");
           unmarried.setBounds(450, 390, 100, 30);
           unmarried.setBackground(Color.white);
           add(unmarried);
           
           // showing radio button
           other = new JRadioButton("Other");
           other.setBounds(630, 390, 100, 30);
           other.setBackground(Color.white);
           add(other);
           
           //Radio-Button-grouping
           ButtonGroup maritalgroup = new ButtonGroup();
           maritalgroup.add(married);
           maritalgroup.add(unmarried);
           maritalgroup.add(other);
           
           //showing label on frame
           JLabel address = new JLabel("Address:");
           address.setFont(new Font("SanSarif", Font.BOLD, 22));
           address.setBounds(100, 440, 200, 30);
           add(address);
           
           //showing textField on frame
           addTextField = new JTextField();
           addTextField.setFont(new Font("SanSerif", Font.BOLD, 15));
           addTextField.setBounds(300, 440, 400, 30);
           add(addTextField);
           
           //showing label on frame
           JLabel city = new JLabel("City:");
           city.setFont(new Font("SanSarif", Font.BOLD, 22));
           city.setBounds(100, 490, 200, 30);
           add(city);
           
           //showing textField on frame
           cityTextField = new JTextField();
           cityTextField.setFont(new Font("SanSerif", Font.BOLD, 15));
           cityTextField.setBounds(300, 490, 400, 30);
           add(cityTextField);
           
           //showing label on frame
           JLabel state = new JLabel("State:");
           state.setFont(new Font("SanSarif", Font.BOLD, 22));
           state.setBounds(100, 540, 200, 30);
           add(state);
           
           //showing textField on frame
           stateTextField = new JTextField();
           stateTextField.setFont(new Font("SanSerif", Font.BOLD, 15));
           stateTextField.setBounds(300, 540, 400, 30);
           add(stateTextField);
           
           //showing label on frame
           JLabel pincode = new JLabel("Pincode:");
           pincode.setFont(new Font("SanSarif", Font.BOLD, 22));
           pincode.setBounds(100, 590, 200, 30);
           add(pincode);
           
           //showing textField on frame
           pinTextField = new JTextField();
           pinTextField.setFont(new Font("SanSerif", Font.BOLD, 15));
           pinTextField.setBounds(300, 590, 400, 30);
           add(pinTextField);
           
           next = new JButton("Next");
           next.setBackground(Color.black);
           next.setForeground(Color.white);
           next.setFont(new Font("SanSerif", Font.BOLD, 14));
           next.setBounds(620, 660, 80, 30);
           next.addActionListener(this);//action listener
           add(next);
           
           //frame background color
           getContentPane().setBackground(Color.white);
           
           //creating frame
           setSize(850,850);
           setLocation(350,10); //left, up
           setVisible(true);
    }
       
    public void actionPerformed(ActionEvent ae){ //here only one "next" button no need to define.
        String formNo = "" + random; //long to string
        String name = nameTextField.getText(); // getting value from textField
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText(); //to get dob
        
        String gender = null;
            if(male.isSelected()){
                gender = "Male";
            }else if(female.isSelected()){
                gender = "Female";
            }
            
        String email = emailTextField.getText();
        
        String marital = null;
            if(married.isSelected()){
                marital = "Married";
            }else if(unmarried.isSelected()){
                marital = "Un-Married";
            }else if(other.isSelected()){
                marital = "Other";
            }
            
         String add = addTextField.getText();
         String city = cityTextField.getText();
         String state = stateTextField.getText();
         String pin = pinTextField.getText();
         
         //Database Connection
         try{
             if(name.equals("")){
                 JOptionPane.showMessageDialog(null, "Name Field is Required!"); //Action on next button                 
             } else {
                 conn c = new conn();
                 //step4:Creating MySql query
                 String query = "insert into signup values('" + formNo + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + add + "','" + city + "','" + state + "','" + pin + "')";
                 //DML command to execute above query in MySql. 's'-->step3:to craete statement in conn.java
                 c.s.executeUpdate(query);// this will update query on database
                 
                setVisible(false); //onClick signup it will close
                new SignupTwo(formNo).setVisible(true);// SignupTwo-->constructor of SignupOne class. //Now after clicked--> application form 2 visible.            
             }
         } catch (Exception e){
             System.out.println("Error while saving your data: " + e);
         }
    }
       
    public static void main(String args[]) {
        
     new SignupOne(); //class object called
        
    }
}
