package bank.managment.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    // Declaring Global Variables
    JTextField pan, aadhar;
    JButton next;
    JRadioButton senioryes, seniorno, existyes, existno;
    JComboBox religion, category, income, education, occupation;
    String formNo;
    
    //creating constructor of class, so that when object is call for this class then frame should appears.
    SignupTwo(String formNo) {
        this.formNo = formNo;

        setLayout(null);
        setTitle("New Account Application Form - Page-2");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // showing sub-headline on frame
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("SanSerif", Font.BOLD, 27));
        additionalDetails.setBounds(270, 80, 350, 40);
        add(additionalDetails);

        // Religion
        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("SanSerif", Font.BOLD, 22));
        name.setBounds(100, 140, 100, 30);
        add(name);

        String valReligion[] = { "Hindu", "Muslim", "Christian", "Other" };
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.white);
        add(religion);

        // Category
        JLabel fName = new JLabel("Category:");
        fName.setFont(new Font("SanSerif", Font.BOLD, 22));
        fName.setBounds(100, 190, 190, 30);
        add(fName);

        String valcategory[] = { "General", "ST", "OBC", "SC" };
        category = new JComboBox(valcategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.white);
        add(category);

        // Income
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("SanSerif", Font.BOLD, 22));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        String incomecategory[] = { "Null", "< 1.5L", "<2.5L", "<5L", "Up to 10L" };
        income = new JComboBox(incomecategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.white);
        add(income);

        // Educational Qualification
        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("SanSerif", Font.BOLD, 22));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("SanSerif", Font.BOLD, 22));
        email.setBounds(100, 315, 200, 30);
        add(email);

        String educationalVal[] = { "Non-Graduation", "Graduate", "Post-Graduatation", "MBBS", "Other" };
        education = new JComboBox(educationalVal);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.white);
        add(education);

        // Occupation
        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("SanSerif", Font.BOLD, 22));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        String occupationVal[] = { "Salaried", "Self-Emplyed", "Bussiness", "Student", "Retired", "Others" };
        occupation = new JComboBox(occupationVal);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.white);
        add(occupation);

        // PAN
        JLabel address = new JLabel("PAN Number:");
        address.setFont(new Font("SanSerif", Font.BOLD, 22));
        address.setBounds(100, 440, 200, 30);
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("SanSerif", Font.BOLD, 15));
        pan.setBounds(300, 440, 400, 30);
        add(pan);

        // Aadhar
        JLabel city = new JLabel("Aadhar Number:");
        city.setFont(new Font("SanSerif", Font.BOLD, 22));
        city.setBounds(100, 490, 200, 30);
        add(city);

        aadhar = new JTextField();
        aadhar.setFont(new Font("SanSerif", Font.BOLD, 15));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);

        // Senior Citizen
        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("SanSerif", Font.BOLD, 22));
        state.setBounds(100, 540, 200, 30);
        add(state);

        senioryes = new JRadioButton("Yes");
        senioryes.setBounds(300, 540, 90, 30);
        senioryes.setBackground(Color.white);
        add(senioryes);

        seniorno = new JRadioButton("No");
        seniorno.setBounds(450, 540, 100, 30);
        seniorno.setBackground(Color.white);
        add(seniorno);

        ButtonGroup smaritalgroup = new ButtonGroup();
        smaritalgroup.add(senioryes);
        smaritalgroup.add(seniorno);

        // Existing Account
        JLabel pincode = new JLabel("Existing Account:");
        pincode.setFont(new Font("SanSerif", Font.BOLD, 22));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);

        existyes = new JRadioButton("Yes");
        existyes.setBounds(300, 590, 90, 30);
        existyes.setBackground(Color.white);
        add(existyes);

        existno = new JRadioButton("No");
        existno.setBounds(450, 590, 100, 30);
        existno.setBackground(Color.white);
        add(existno);

        ButtonGroup emaritalgroup = new ButtonGroup();
        emaritalgroup.add(existyes);
        emaritalgroup.add(existno);

        // Next button
        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("SanSerif", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        // frame background color and size
        getContentPane().setBackground(Color.white);
        setSize(850, 850);
        setLocation(350, 10); // left, up
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        // Use the formNo passed in the constructor
        String formNumber = this.formNo;

        String strReligion = religion.getSelectedItem().toString(); // getting value from textField and conveted obj-->string
        String strCategory = category.getSelectedItem().toString();
        String strIncome = income.getSelectedItem().toString();
        String strEducation = education.getSelectedItem().toString();
        String strOccupation = occupation.getSelectedItem().toString();

        String strSenior = null;
        if (senioryes.isSelected()) {
            strSenior = "Yes";
        } else if (seniorno.isSelected()) {
            strSenior = "No";
        }

        String strExist = null;
        if (existyes.isSelected()) {
            strExist = "Yes";
        } else if (existno.isSelected()) {   
            strExist = "No";
        }

        String strPan = pan.getText();
        String strAadhar = aadhar.getText();
        //Database Connection
        try {
            conn c = new conn();
            String query = "insert into signupTwo values('" + formNumber + "','" + strReligion + "','" + strCategory + "','" + strIncome + "','" + strEducation + "','" + strOccupation + "','" + strPan + "','" + strAadhar + "','" + strSenior + "','" + strExist + "')";
            c.s.executeUpdate(query);// this will update query on database
            
            //Here-->signUp 3 object.
            setVisible(false);
            new SignupThree (formNumber).setVisible(true); 
            
        } catch (Exception e) {
            System.out.println("Error while saving your data: " + e);
        }
    }

    public static void main(String args[]) {
        new SignupTwo(""); //class object called
    }
}
