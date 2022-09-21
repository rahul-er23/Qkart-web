package com.qgroup.qkart.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Admin extends ViewProduct {
	PreparedStatement pstate = null;
	ResultSet pro = null;
	Scanner s1 = new Scanner(System.in);
	Validation v = new Validation();
	DbConnect db = new DbConnect();
	Connection con = db.getConnectionDetails();
	int count = 0;
	String Adminuser = "User";
	String Adminpass = "User";
	boolean exit = false;

	public void adminLogin() {

		System.out.println("Enter Admin Username: ");
		String adminname = s1.next();

		System.out.println("Enter Admin Password: ");
		String passw = s1.next();

		if (Adminuser.equals(adminname)) {
			if (Adminpass.equals(passw)) {
				System.out.println("\nLogin Successfull...");
				while (!exit) {

					System.out.println("\n***Enter Your Choice***");
					System.out.println("\n1.Product List  " + "\n2.User List  " + "\n3.Purchase List  " + "\n4.Exit");
					int choice = s1.nextInt();

					switch (choice) {
					case 1:
						productList();
						break;
					case 2:
						userList();
						break;
					case 3:
						purchaseList();
						break;
					case 4:
						exit = true;
						System.out.println("\nThank You !");
						System.exit(0);
					}
				}
			} else {
				System.out.println("\nIncorrect Admin Username or Password");
			}
		} else {
			System.out.println("\nIncorrect Admin Username or Password");
			System.exit(0);
		}

	}

	public void productList() {
		try {
			Map<String, String> map = new HashMap<String, String>();

			pstate = con.prepareStatement(
					"select ProductID,Name,Quantity from productdetails group by ProductID order by Quantity asc");
			pro = pstate.executeQuery();
			while (pro.next()) {
				map.put(pro.getString(1), pro.getString(3));
			}
			System.out.println("ProductID = Quantity");
			for (String key : map.keySet()) {
				System.out.println(key + " = " + map.get(key));

			}
			System.out.println("Please Enter product ID to see the Details: ");
			int id = s1.nextInt();
			int p = singleProduct(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println("Please Enter Product ID to see the Details");
		// s1.nextInt();
	}

	public void userList() {
		try {
			// Map<Integer, String> map1=new HashMap<Integer, String>();

			pstate = con.prepareStatement("select * from userdetails group by UserId order by UserId asc");
			pro = pstate.executeQuery();
			while (pro.next()) {
				System.out.println(pro.getInt(1) + " " + pro.getString(2) + " \t\t" + pro.getString(3) + " \t\t"
						+ pro.getString(4) + " \t\t" + pro.getString(5) + " \t\t" + pro.getString(6));
			}
			System.out.println("\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void purchaseList() {
		try {
			pstate = con.prepareStatement("select UserId,UserName,Name,Quantity,Price,ProductID"
					+ " from purchasedetails group by UserId order by UserId asc");
			pro = pstate.executeQuery();
			while (pro.next()) {
				System.out.println(pro.getInt(1) + " " + pro.getString(2) + " \t\t" + pro.getString(3) + " \t\t"
						+ pro.getString(4) + " \t\t" + pro.getString(5) + " \t\t" + pro.getString(6));
			}
			System.out.println("\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}