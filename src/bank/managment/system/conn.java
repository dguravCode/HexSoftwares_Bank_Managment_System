package bank.managment.system;

import java.sql.*; // SQL library
public class conn {
    Connection c; //connection class to connect jdbc
    Statement s; //statement class to create statement
    public conn(){
        try{
          //Class.forName(com.mysql.cj.jdbc.Driver); //step1:to register driver is not require bcz java create its own class path to register driver
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagmentsystem", "root", "root"); //step2:to craete connection-->(databaseName, MySql username(By-default 'root'), MySql password)
            s = c.createStatement(); //step3:to craete statement               
            
        }catch(Exception e){
            System.out.println("DB Connection error: " + e);
        }
    }
}
