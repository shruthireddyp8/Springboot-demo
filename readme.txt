Pre-requisites: Install MySQL database
1) create a database name 'apple' 
query:
           create database apple;
           use apple;
           
2) create a table named employee with the below query
query:
		create table employee(
		   id INT(6) NOT NULL ,
		   firstname VARCHAR(100) NOT NULL,
		   lastname VARCHAR(40) NOT NULL,
		   salary INT(6),
		   PRIMARY KEY ( id )
		);
		
3) Insert few columns into the table
query:
		insert into employee values(1,"shruthi", "palle",10000);
		insert into employee values(2,"laya", "palle",20000);
		

4) define your MySQL username and password in application.properties

5) Build and run the application
mvn clean install
mvn spring-boot:run

6) below are the API end points
GET : localhost:8080/employees/{id}
PUT: localhost:8080/employees/{id}
		

