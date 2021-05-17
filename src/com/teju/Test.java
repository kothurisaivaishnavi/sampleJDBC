package com.teju;

import java.sql.SQLException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Scanner sc= new Scanner(System.in);
		System.out.println("1.Insert\n2.Show");
		char c;
		do {
			System.out.println("Enter Choice:");
			int ch = sc.nextInt();
			switch(ch) {
				case 1: Employee.insertDetails();
						break;
				case 2: Employee.showDetails();
						break;
				default:System.exit(0);
			}
			System.out.println("Do you want continue Y/N ?");
			c=sc.next().charAt(0);
		}while(c=='Y'||c=='y');
	}
}
