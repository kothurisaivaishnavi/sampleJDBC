package com.teju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Employee {
	private static int id;
	private static String name;
	private static String designation;
	private static double salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public static void showDetails(){
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","October@1998");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from employee");  
			System.out.println("------------------------------------");
			System.out.format("%-5s %-10s %-15s %s\n","ID","Name","Designation","Salary");
			System.out.println("------------------------------------");
			while(rs.next())  
			System.out.format("%-5s %-10s %-15s %s\n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4));  
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
	}
	public static void insertDetails() {
		try{  
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Employee data(id, name, des, salary)");
			String i = sc.next();
			String[] data = i.split(",");
			id=Integer.parseInt(data[0]);
			name=data[1];
			designation=data[2];
			salary=Integer.parseInt(data[3]);
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","October@1998");  
			Statement stmt=con.createStatement();  
			String query = " insert into employee (id,name,designation,salary)"
		        + " values (?, ?, ?, ?)";
	      // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = con.prepareStatement(query);
	      
	      preparedStmt.setInt (1, id);
	      preparedStmt.setString (2, name);
	      preparedStmt.setString (3, designation);
	      preparedStmt.setDouble(4, salary);
	      preparedStmt.executeUpdate();
	      
	      con.close();
		}catch(Exception e) {System.out.println("====");}
	}
}
