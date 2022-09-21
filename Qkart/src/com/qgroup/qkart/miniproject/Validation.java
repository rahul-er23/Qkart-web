package com.qgroup.qkart.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Validation {

	Scanner s1 = new Scanner(System.in);
	String username = null;
	PreparedStatement pstate = null;
	ResultSet pro = null;
	DbConnect db = new DbConnect();
	Connection con = db.getConnectionDetails();
	String user1;

	public String uget(String username) {
		try {
			pstate = con.prepareStatement("select * from userdetails where UserName = " + "'" + username + "'");
			pro = pstate.executeQuery();

			while (pro.next()) {
				user1 = pro.getString(1);
			}
		} catch (Exception e) {
			System.out.println("Unexpected Input provided, Please Try Again");
			System.exit(0);
		}
		return user1;
	}

	public String usercheck() {

		try {

			System.out.println("\nPlease Enter UserName (*No WhiteSpace Allowed)");
			username = s1.nextLine();
			if (username.contains(" ")) {
				System.out.println("\nNo WhilteSpaces Allowed, Try Again\n");
				Qkart.t1();
			}
			System.out.println("\nChecking.... ");

			user1 = uget(username);
			if (username.equals(user1)) {
				System.out.print("\nUsername Not Available, please try another");
				System.out.println("\nPlease Enter UserName (*No WhiteSpace Allowed)");
				username = s1.nextLine();
				if (username.contains(" ")) {
					System.out.println("\nNo WhilteSpaces Allowed, Try Again\n");
					Qkart.t1();
				}
				System.out.println("\nChecking.... ");
				user1 = uget(username);
			}
			if (username.equals(user1)) {
				System.out.print("\nUsername Not Available, please try another");
				System.out.println("\nPlease Enter UserName (*No WhiteSpace Allowed)");
				username = s1.nextLine();
				if (username.contains(" ")) {
					System.out.println("\nNo WhilteSpaces Allowed, Try Again\n");
					Qkart.t1();
				}
				System.out.println("\nChecking.... ");
				user1 = uget(username);
			}
			if (username.equals(user1)) {
				System.out.print("\nUsername Not Available, please try another");
				System.out.println("\nPlease Enter UserName (*No WhiteSpace Allowed)");
				username = s1.nextLine();
				if (username.contains(" ")) {
					System.out.println("\nNo WhilteSpaces Allowed, Try Again\n");
					Qkart.t1();
				}
				System.out.println("\nChecking.... ");
				user1 = uget(username);
				System.out.println("\nYour Enter Incorrect Input Multiple Times, Sorry....");
				System.exit(0);
			} else {
				System.out.println("\nUsername Available, Please proceed further");
			}
		} catch (Exception e) {
			System.out.println("\nUsername Available, Please proceed further");
			Qkart.t1();
		}
		return username;
	}
}
