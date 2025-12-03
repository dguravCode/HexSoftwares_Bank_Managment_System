CREATE DATABASE bankmanagmentsystem;

SHOW DATABASES;

USE bankmanagmentsystem;

CREATE TABLE signup(formNo VARCHAR(20), name VARCHAR(20), father_name VARCHAR(20), dob VARCHAR(20), gender VARCHAR(20), email VARCHAR(30), marital VARCHAR(20), address VARCHAR(50), city VARCHAR(25), state VARCHAR(25), pin VARCHAR(20));

SHOW TABLES;

SELECT * FROM signup;

CREATE TABLE signupTwo(formNumber VARCHAR(20), Religion VARCHAR(20), Category VARCHAR(20), Income VARCHAR(20), Education VARCHAR(20), Occupation VARCHAR(20), Pan VARCHAR(20), Aadhar VARCHAR(20), Senior VARCHAR(20), Existing_Acc VARCHAR(20));

SHOW TABLES;

SELECT * FROM signupTwo;

CREATE TABLE signupThree(formNumber VARCHAR(20), ACC_Type VARCHAR(20), CardNum VARCHAR(20), PinNum VARCHAR(20), Serveces VARCHAR(20));
CREATE TABLE login(formNumber VARCHAR(20), CardNum VARCHAR(20), PinNum VARCHAR(20));

ALTER TABLE signupThree MODIFY COLUMN CardNum VARCHAR(20);
ALTER TABLE signupThree MODIFY COLUMN PinNum VARCHAR(20);
ALTER TABLE signupThree MODIFY COLUMN Serveces TEXT;

SELECT * FROM signupThree;

select * from login;

CREATE TABLE bank(pin VARCHAR(10), date VARCHAR(50), trans_type VARCHAR(20), amount VARCHAR(20));
DESCRIBE bank;

select * from bank;







